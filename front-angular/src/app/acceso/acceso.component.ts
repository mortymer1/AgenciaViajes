import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ClienteService } from '../services/cliente.service';
import { ClienteDto } from '../models/cliente.dto';

@Component({
  selector: 'app-acceso',
  templateUrl: './acceso.component.html',
  styleUrls: ['./acceso.component.css']
})
export class AccesoComponent implements OnInit {
  loginForm: FormGroup;
  errorMessage: string = '';
  usuarioEnSesion: ClienteDto | null = null;

  constructor(private fb: FormBuilder, private clienteService: ClienteService, private router: Router) {
    this.loginForm = this.fb.group({
      usuario: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    // Verificar si hay sesión iniciada al cargar el componente
    const usuarioGuardado = localStorage.getItem('cliente');
    if (usuarioGuardado) {
      this.usuarioEnSesion = JSON.parse(usuarioGuardado);
    }
  }

  // Método para enviar los datos del formulario
  onSubmit() {
    if (this.loginForm.valid) {
      const { usuario, password } = this.loginForm.value;

      this.clienteService.login(usuario, password).subscribe(
        (cliente: ClienteDto) => {
          if (cliente) {
            // Guardar la información en localStorage
            localStorage.setItem('cliente', JSON.stringify(cliente));
            this.usuarioEnSesion = cliente;
            this.router.navigate(['/reservar']); // Redirigir si es necesario
          }
        },
        (error) => {
          this.errorMessage = 'Usuario o contraseña incorrectos';
        }
      );
    }
  }

  // Método para cerrar la sesión
  cerrarSesion() {
    localStorage.removeItem('cliente');
    this.usuarioEnSesion = null;
  }
}
