import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Persona } from './persona';

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

  constructor(private httpClient: HttpClient) { }

  listarPersonas(): Observable<any> {
    return this.httpClient.get(this.urlEndPoint, this.httpOptions);
  }

  crearPersona(persona: Persona): Observable<any> {
    return this.httpClient.post(this.urlEndPoint, persona, this.httpOptions);
  }

  eliminarPersona(id: number): Observable<any> {
    return this.httpClient.delete(`${this.urlEndPoint}/${id}`, this.httpOptions);
  }

  actualizarPersona(persona: Persona): Observable<any> {
    return this.httpClient.put(this.urlEndPoint, persona, this.httpOptions);
  }

}
