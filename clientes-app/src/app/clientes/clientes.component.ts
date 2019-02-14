import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { CLIENTES } from './clientes.json';
import { ClienteService } from './cliente.service';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  public clientes: Cliente[];

  constructor(
    private clienteService: ClienteService
  ) { }

  ngOnInit() {
    this.clientes = this.clienteService.getClientes();
  }

}
