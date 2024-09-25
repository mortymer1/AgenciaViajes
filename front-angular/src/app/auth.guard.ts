import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {

  constructor(private router: Router) {}

  canActivate(): boolean {
    const clienteString = localStorage.getItem('cliente');
    
    // Verificar si el cliente está en localStorage (usuario logado)
    if (clienteString) {
      return true;
    } else {
      // Si no está logado, redirigir al login o acceso
      this.router.navigate(['/acceso']);
      return false;
    }
  }
}
