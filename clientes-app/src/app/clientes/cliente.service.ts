import { Injectable } from '@angular/core';
import { CLIENTES } from './clientes.json';
import { Cliente } from './cliente.js';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private urlEndPoint: string = 'http://127.0.0.1:8080/api/clientes';

  constructor(
    private httpClient: HttpClient
  ) { }

  getClientes(): Observable<Cliente[]> {
    return this.httpClient.get<Cliente[]>(this.urlEndPoint);
  }

  create(cliente: Cliente): Observable<Cliente> {
    return this.httpClient.post<Cliente>(this.urlEndPoint, cliente);
  }

  getCliente(id: number): Observable<Cliente> {
    return this.httpClient.get<Cliente>(`${this.urlEndPoint}/${id}`);
  }

}
