import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Hotel } from '../models/hotel.dto';
import { Vuelo } from '../models/vuelo.dto';

@Injectable({
  providedIn: 'root'
})
export class ReservasService {
  private destinosUrl = 'http://localhost:10001/hoteles/localizaciones';
  private hotelesUrl = 'http://localhost:10001/hoteles/buscarhoteles';
  private vuelosUrl = 'http://localhost:10003/vuelos';
  private altaReservaUrl = 'http://localhost:10002/reservas/altaReserva';

  constructor(private http: HttpClient) { }

  // Método para obtener los destinos
  getDestinos(): Observable<string[]> {
    return this.http.get<string[]>(this.destinosUrl);
  }

  // Método para obtener los hoteles según la localización seleccionada
  getHoteles(localizacion: string): Observable<Hotel[]> {
    return this.http.get<Hotel[]>(`${this.hotelesUrl}/${localizacion}`);
  }

  // Método para obtener los vuelos según el destino y las plazas seleccionadas
  getVuelos(destino: string, plazas: number): Observable<Vuelo[]> {
    return this.http.get<Vuelo[]>(`${this.vuelosUrl}/buscarVuelos?destino=${destino}&plazas=${plazas}`);
  }

   // Método para enviar la reserva al backend
   hacerReserva(reserva: { hotel: number; vuelo: number; plazas: number; precio: number }): Observable<any> {
    return this.http.post<any>(this.altaReservaUrl, reserva);
  }

}



