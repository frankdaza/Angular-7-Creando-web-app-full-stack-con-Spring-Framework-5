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
    // return of(CLIENTES);
    return this.httpClient.get<Cliente[]>(this.urlEndPoint);
  }

}
