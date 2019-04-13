import { Component, OnInit } from '@angular/core';
import { Client } from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  chatForm: FormGroup;
  conectado: boolean;

  private client: Client;

  constructor(
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {    
    this.chatForm = this.formBuilder.group({
      texto: ''
    });

    this.conectado = false;

    this.client = new Client();
    this.client.webSocketFactory = () => {
      return new SockJS("http://127.0.0.1:8080/chat-websocket");
    };

    this.client.onConnect = (frame) => {
      console.log(`Conectados: ${this.client.connected} : ${frame}`);
      this.conectado = true;
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

}
