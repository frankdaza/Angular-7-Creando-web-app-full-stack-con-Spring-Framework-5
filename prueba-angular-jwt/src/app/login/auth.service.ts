import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from './usuario';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private httpClient: HttpClient
  ) { }

  login(usuario: Usuario): Observable<any> {
    const urlOauthEndPoint = 'http://127.0.0.1:8080/oauth/token';
    const credenciales = btoa('angularapp' + ':' + '123456');
    const httpHeaders: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded', 'Authorization': 'Basic ' + credenciales });
    let params = new URLSearchParams();
    params.set('grant_type', 'password');
    params.set('username', usuario.username);
    params.set('password', usuario.password);
    return this.httpClient.post<any>(urlOauthEndPoint, params, );
  }

}
