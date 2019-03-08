import { Component, OnInit, Input } from '@angular/core';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente.service';
import { ActivatedRoute } from '@angular/router';
import swal from 'sweetalert2';
import { HttpEventType } from '@angular/common/http';

@Component({
  selector: 'app-detalle',
  templateUrl: './detalle.component.html',
  styleUrls: ['./detalle.component.css']
})
export class DetalleComponent implements OnInit {

  @Input()
  public cliente: Cliente;
  public titulo: string = 'Detalle del cliente';
  public urlEndPointImagenes: string = 'http://127.0.0.1:8080/api/uploads/img';
  public progreso: number = 0;

  private fotoSeleccionada: File;

  constructor(
    private clienteService: ClienteService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit() {    
  }

  seleccionarFoto(event: any) {
    this.progreso = 0;
    this.fotoSeleccionada = event.target.files[0];
    console.log(this.fotoSeleccionada);
    
    if (this.fotoSeleccionada.type.indexOf('image') == -1) {
      swal.fire(
        'Error seleccionar imagen:',
        'El archivo debe ser del tipo imagen',
        'error'
      );

      this.fotoSeleccionada = null;
    }
  }

  subirFoto() {
    if (!this.fotoSeleccionada) {
      swal.fire(
        'Error Upload:',
        'Debe seleccionar una foto',
        'error'
      );
    } else {
      this.clienteService.subirFoto(this.fotoSeleccionada, this.cliente.id).subscribe(
        event => {
          if (event.type === HttpEventType.UploadProgress) {
            this.progreso = Math.round((event.loaded / event.total) * 100);
          } else if (event.type === HttpEventType.Response) {
            let response: any = event.body;
            this.cliente = response.cliente as Cliente;
            
            swal.fire(
              'La foto se ha subido completamente',
              response.mensaje,
              'success'
            );

          }

        }
      );
    }
  }

}
