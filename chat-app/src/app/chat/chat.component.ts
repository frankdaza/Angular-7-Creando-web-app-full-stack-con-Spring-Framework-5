import { Component, OnInit } from '@angular/core';
import { Client } from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Mensaje } from './domain/mensaje';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  chatForm: FormGroup;
  conectado: boolean;
  mensajes: Mensaje[] = [];

  private client: Client;

  constructor(
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {    
    this.chatForm = this.formBuilder.group({
      texto: ['', Validators.required]
    });

    this.conectado = false;

    this.client = new Client();
    this.client.webSocketFactory = () => {
      return new SockJS("http://127.0.0.1:8080/chat-websocket");
    };

    this.client.onConnect = (frame) => {
      console.log(`Conectados: ${this.client.connected} : ${frame}`);
      this.conectado = true;

      this.client.subscribe('/chat/mensaje', e => {
        let mensaje: Mensaje = JSON.parse(e.body) as Mensaje;
        mensaje.fecha = new Date(mensaje.fecha);
        this.mensajes.push(mensaje);
      });
    };

    this.client.onDisconnect = (frame) => {
      console.log(`Desconectados: ${!this.client.connected} : ${frame}`);
      this.conectado = false;
    };
  }

  conectar(): void {
    this.client.activate();
  }

  desconectar(): void {
    this.client.deactivate();
  }

  enviarMensaje(): void {
    if (this.chatForm.valid) {
      let mensajeNuevo: Mensaje = new Mensaje();
      mensajeNuevo.texto  = this.chatForm.get('texto').value.trim();
      
      this.client.publish({
        destination: '/app/mensaje',
        body: JSON.stringify(mensajeNuevo)
      });

      this.chatForm.get('texto').setValue('');
    } else {
      Swal.fire(
        'Campos obligatorios!',
        'No puede enviar un mensaje vacío.',
        'warning'
      );
    }  
  }

}
