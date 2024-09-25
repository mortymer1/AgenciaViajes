import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';  // Importamos Router
import { ClienteService } from '../services/cliente.service';  // Servicio del backend

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {
  registroForm: FormGroup;
  errorMessage: string = '';

  constructor(private fb: FormBuilder, private clienteService: ClienteService, private router: Router) {  // Inyectamos Router
    this.registroForm = this.fb.group({
      usuario: ['', Validators.required],
      password: ['', Validators.required],
      direccion: ['', Validators.required],
      dni: ['', Validators.required],
      tarjeta: ['', Validators.required]
    });
  }

  ngOnInit(): void { }

  // Método para enviar los datos del formulario de registro
  onSubmit() {
    if (this.registroForm.valid) {
      const nuevoCliente = this.registroForm.value;

      this.clienteService.altaCliente(nuevoCliente).subscribe(
        (response) => {
          console.log('Registro exitoso:', response);
          // Redirigir al usuario a la página de acceso tras el registro
          this.router.navigate(['/acceso']);  // Redirección a la página de acceso
        },
        (error) => {
          this.errorMessage = 'Error al registrar, por favor intente de nuevo';
        }
      );
    }
  }
}
