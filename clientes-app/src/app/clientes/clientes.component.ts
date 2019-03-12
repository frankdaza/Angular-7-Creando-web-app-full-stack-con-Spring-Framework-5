import { Component, OnInit, Input } from '@angular/core';
import { Cliente } from './cliente';
import { CLIENTES } from './clientes.json';
import { ClienteService } from './cliente.service';
import swal from 'sweetalert2';
import { ActivatedRoute } from '@angular/router';
import { ModalService } from './detalle/modal.service';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  public clienteSeleccionado: Cliente;  
  public clientes: Cliente[];
  public paginator: any;
  public urlEndPointImagenes: string = 'http://127.0.0.1:8080/api/uploads/img';
  

  constructor(
    private clienteService: ClienteService,
    private activatedRoute: ActivatedRoute,
    private modalService: ModalService
  ) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe( params => {
      // De esta forma reutiliza el objeto, y no me actualiza la informaciòn con los paràmetros de la nueva url
      // let page: number = +params['page'];

      // De esta forma, hace una nueva instancia de la url, y asi aseguro que me actualiza los parametros de la url
      let page: number = +params.get('page'); 

      if (!page) {
        page = 0;
      }

      this.getClientes(page);
    });
  }

  getClientes(page: number): void {
    this.clienteService.getClientes(page).subscribe((response: any) => {
      this.clientes = response.content as Cliente[];
      this.paginator = response;
    });
  }

  delete(cliente: Cliente): void {
    const swalWithBootstrapButtons = swal.mixin({
      confirmButtonClass: 'btn btn-success',
      cancelButtonClass: 'btn btn-danger',
      buttonsStyling: false,
    })
    
    swalWithBootstrapButtons.fire({
      title: '¿Está seguro?',
      text: `¿Seguro que desea eliminar al cliente ${cliente.nombre} ${cliente.apellido}?`,
      type: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Si, Eliminar!',
      cancelButtonText: 'No, cancelar!',
      reverseButtons: true
    }).then((result) => {
      if (result.value) {
        this.clienteService.delete(cliente.id).subscribe(cliente => {
          this.getClientes(0);

          swalWithBootstrapButtons.fire(
            'Cliente Eliminado!',
            `Cliente ${cliente.nombre} eliminado exitosamente.`,
            'success'
          )
        });
      }
    })
  }

  abrirModal(cliente: Cliente): void {
    this.clienteSeleccionado = cliente;
    this.modalService.abrirModal();
  }

}
