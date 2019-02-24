import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente.service';
import { Router, ActivatedRoute } from '@angular/router';
import swal from 'sweetalert2';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  public cliente:Cliente = new Cliente();
  public titulo: string = 'Crear Cliente';

  constructor(
    private clienteService: ClienteService,
    private router: Router,
    private activateRoute: ActivatedRoute
  ) { }

  ngOnInit() {
    this.cargarCliente();
  }

  cargarCliente(): void {
    this.activateRoute.params.subscribe(params => {
      let id: number = +params['id'];

      if (id) {
        this.clienteService.getCliente(id).subscribe(
          cliente => this.cliente = cliente);
      }
    });
  }

  public create(): void {
    this.clienteService.create(this.cliente).subscribe(
      cliente => {
        this.router.navigate(['/clientes']);
        swal.fire(
          'Nuevo Cliente',
          `Cliente ${cliente.nombre} creado exitosamente!`,
          'success'
        );
      }
    );
  }

}
