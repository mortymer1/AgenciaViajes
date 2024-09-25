import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  usuarioLogado: boolean = false;  // Variable que controla si el usuario está logado

  ngOnInit(): void {
    this.comprobarEstadoUsuario();  // Verificar el estado del usuario al cargar el componente
  }

  // Método para verificar si el usuario está logado (mirando localStorage)
  comprobarEstadoUsuario() {
    this.usuarioLogado = !!localStorage.getItem('cliente');  // Si hay cliente en localStorage, es true
  }
}
