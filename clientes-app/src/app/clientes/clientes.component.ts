import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { CLIENTES } from './clientes.json';
import { ClienteService } from './cliente.service';
import swal from 'sweetalert2';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  public clientes: Cliente[];
  private page: number = 0;

  constructor(
    private clienteService: ClienteService
  ) { }

  ngOnInit() {
    this.getClientes(this.page);
  }

  getClientes(page: number): void {
    this.clienteService.getClientes(page).subscribe((clientes: any) => {
      this.clientes = clientes.content as Cliente[];
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
          this.getClientes();

          swalWithBootstrapButtons.fire(
            'Cliente Eliminado!',
            `Cliente ${cliente.nombre} eliminado exitosamente.`,
            'success'
          )
        });
      }
    })
  }

}
