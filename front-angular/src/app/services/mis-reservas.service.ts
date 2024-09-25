import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ReservaDto } from '../models/reserva.dto';  // Asegúrate de tener este modelo definido

@Injectable({
  providedIn: 'root'
})
export class MisReservasService {

  private reservasUrl = 'http://localhost:10002/reservas';  // URL del microservicio de reservas

  constructor(private http: HttpClient) { }

  // Método para obtener las reservas por usuario
  getReservasPorUsuario(usuario: string): Observable<ReservaDto[]> {
    return this.http.get<ReservaDto[]>(`${this.reservasUrl}/porUsuario/${usuario}`);
  }
}
