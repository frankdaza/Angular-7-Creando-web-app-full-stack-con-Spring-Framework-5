import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ModalService {

  public modal: boolean = false;

  constructor() { }

  abrirModal(): void {
    this.modal = true;
  }

  cerrarModal(): void {
    this.modal = false;
  }

}
