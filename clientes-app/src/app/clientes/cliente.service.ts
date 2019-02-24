import { Injectable } from '@angular/core';
import { CLIENTES } from './clientes.json';
import { Cliente } from './cliente.js';
import { Observable, throwError } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Router } from '@angular/router';

import swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private urlEndPoint: string = 'http://127.0.0.1:8080/api/clientes';

  constructor(
    private httpClient: HttpClient,
    private router: Router
  ) { }

  getClientes(page: number): Observable<any> {
    return this.httpClient.get<any>(`${this.urlEndPoint}/page/${page}`);
  }

  create(cliente: Cliente): Observable<Cliente> {
    return this.httpClient.post<Cliente>(this.urlEndPoint, cliente);
  }

  getCliente(id: number): Observable<Cliente> {
    return this.httpClient.get<Cliente>(`${this.urlEndPoint}/${id}`).pipe(
      catchError(e => {
        this.router.navigate(['/clientes']);

        swal.fire(
          'Error al editar',
          e.error.mensaje,
          'error'
        );

        return throwError(e);
      })
    );
  }

  update(cliente: Cliente): Observable<Cliente> {
    return this.httpClient.put<Cliente>(`${this.urlEndPoint}/${cliente.id}`, cliente);
  }

  delete(id: number): Observable<Cliente> {
    return this.httpClient.delete<Cliente>(`${this.urlEndPoint}/${id}`);
  }

}
