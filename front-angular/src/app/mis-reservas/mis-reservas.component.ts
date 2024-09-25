import { Component, OnInit } from '@angular/core';
import { MisReservasService } from '../services/mis-reservas.service';  // Servicio de reservas
import { ReservaDto } from '../models/reserva.dto';  // Modelo de reserva

@Component({
  selector: 'app-mis-reservas',
  templateUrl: './mis-reservas.component.html',
  styleUrls: ['./mis-reservas.component.css']
})
export class MisReservasComponent implements OnInit {
  reservas: ReservaDto[] = [];
  usuario: string = '';

  constructor(private misReservasService: MisReservasService) { }

  ngOnInit(): void {
    // Obtener el usuario de localStorage
    const clienteString = localStorage.getItem('cliente');
    const cliente = clienteString ? JSON.parse(clienteString) : null;

    if (cliente) {
      this.usuario = cliente.usuario;
      this.cargarReservas();  // Cargar las reservas del usuario
    }
  }

  // Método para cargar las reservas del usuario
  cargarReservas() {
    this.misReservasService.getReservasPorUsuario(this.usuario).subscribe(
      (data: ReservaDto[]) => {
        this.reservas = data;
      },
      (error) => {
        console.error('Error al cargar las reservas', error);
      }
    );
  }
}
