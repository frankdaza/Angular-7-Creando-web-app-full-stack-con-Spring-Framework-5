import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from './usuario';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private _usuario: Usuario;
  private _token: string;

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

    return this.httpClient.post<any>(urlOauthEndPoint, params.toString(), { headers: httpHeaders });
  }

  guardarUsuario(token: string) {
    let payload = this.obtenerDatosToken(token);
    this._usuario = new Usuario();
    this._usuario.nombre = payload.nombre;
    this._usuario.apellido = payload.apellido;
    this._usuario.email = payload.email;
    this._usuario.username = payload.user_name;
    this._usuario.roles = payload.authorities;
    sessionStorage.setItem('usuario', JSON.stringify(this._usuario));
  }

  guardarToken(token: string) {
    this._token = token;
    sessionStorage.setItem('token', token);
  }

  private obtenerDatosToken(token: string): any {
    if (token) {
      return JSON.parse(atob(token.split('.')[1]));
    }
    return undefined;
  }

  isAuthenticated(): boolean {
    let payload = this.obtenerDatosToken(this._token);
    
    if (payload && payload.user_name && payload.user_name.length > 0) {
      return true;
    }

    return false;
  }

  logout(): void {
    this._token = undefined;
    this._usuario = undefined;
    sessionStorage.clear();
  }

  hasRole(role: string): boolean {
    const usuario: Usuario = this.usuario;

    if (this.usuario.roles.includes(role)) {
      return true;
    } else {
      return false;
    }
  }

  public get usuario(): Usuario {
    if (this._usuario) {
      return this._usuario;
    } else if (sessionStorage.getItem('usuario')) {
      this._usuario = JSON.parse(sessionStorage.getItem('usuario')) as Usuario;
      return this._usuario;
    } else {
      return new Usuario();
    }
  }

  public get token(): string {
    if (this._token) {
      return this._token;
    } else if (sessionStorage.getItem('token')) {
      this._token = JSON.parse(sessionStorage.getItem('token')) as string;
      return this._token;
    } else {
      return undefined;
    }
  }

}
