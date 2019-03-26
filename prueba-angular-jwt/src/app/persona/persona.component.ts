import { Component, OnInit, OnDestroy } from '@angular/core';
import { PersonaService } from './persona.service';
import { Subscription } from 'rxjs';
import { Persona } from './persona';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html',
  styleUrls: ['./persona.component.css']
})
export class PersonaComponent implements OnInit, OnDestroy {

  private subscription: Subscription;

  personas: Persona[];
  personaForm: FormGroup;

  constructor(
    private personaService: PersonaService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.personaForm = this.formBuilder.group({
      nombres: ['', Validators.required],
      apellidos: ['', Validators.required]
    });

    this.listarPersonas();
  }

  ngOnDestroy(): void {
    if (this.subscription)
      this.subscription.unsubscribe();
  }

  listarPersonas(): void {
    this.subscription = this.personaService.listarPersonas().subscribe(
      (data: any) => {
        this.personas = data.entity as Persona[];
      }
    );
  }

  crearPersona(): void {
    if (this.personaForm.valid) {
      let nuevaPersona: Persona = new Persona();
      nuevaPersona.nombres = this.personaForm.get('nombres').value;
      nuevaPersona.apellidos = this.personaForm.get('apellidos').value;      
      this.subscription = this.personaService.crearPersona(nuevaPersona).subscribe(
        (data: any) => {
          this.limpiarFormulario();
          this.listarPersonas();
          
          Swal.fire({
            text: data.mensaje,
            type: 'success',
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Aceptar'
          });
        }
      );
    } else {
      Swal.fire({
        text: 'Debe ingresar los nombres y apellidos de la persona!',
        type: 'warning',
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Aceptar'
      });
    }
  }

  limpiarFormulario(): void {
    this.personaForm.reset();
  }

}
