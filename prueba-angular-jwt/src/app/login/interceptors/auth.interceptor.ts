import { Injectable } from '@angular/core';
import {
  HttpEvent, HttpInterceptor, HttpHandler, HttpRequest
} from '@angular/common/http';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import Swal from 'sweetalert2';

import { Observable } from 'rxjs';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

/** Pass untouched request through to the next request handler. */
@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  intercept(req: HttpRequest<any>, next: HttpHandler):
    Observable<HttpEvent<any>> {    
    return next.handle(req).pipe(
      catchError(e => {
        if (e.status === 401) {

          if (this.authService.isAuthenticated()) {
            this.authService.logout();
          }
    
          this.router.navigate(['/login']);
        } else if(e.status === 403) {
          Swal.fire(
            'Acceso Denegado',
            'Hola, no tienes los permisos necesarios para acceder a este recurso!',
            'warning'
          );
        }        
        return throwError(e);
      })
    );
  }
}