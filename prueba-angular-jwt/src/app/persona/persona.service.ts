import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Persona } from './persona';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  private urlEndPoint: string = 'http://127.0.0.1:8080/personas';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(
    private httpClient: HttpClient,
    private router: Router
  ) { }

  handleError(e: any): boolean {
    if (e.status === 401 || e.status === 403) {
      this.router.navigate(['/login']);
      return true;
    } else {
      return false;
    }
  }

  listarPersonas(): Observable<any> {
    return this.httpClient.get(this.urlEndPoint, this.httpOptions)
      .pipe(catchError(e => {
        this.handleError(e);
        return throwError(e);
      }));;
  }

  crearPersona(persona: Persona): Observable<any> {
    return this.httpClient.post(this.urlEndPoint, persona, this.httpOptions)
      .pipe(catchError(e => {
        this.handleError(e);
        return throwError(e);
      }));
  }

  eliminarPersona(id: number): Observable<any> {
    return this.httpClient.delete(`${this.urlEndPoint}/${id}`, this.httpOptions)
      .pipe(catchError(e => {
        this.handleError(e);
        return throwError(e);
      }));
  }

  actualizarPersona(persona: Persona): Observable<any> {
    return this.httpClient.put(this.urlEndPoint, persona, this.httpOptions)
      .pipe(catchError(e => {
        this.handleError(e);
        return throwError(e);
      }));
  }

}
