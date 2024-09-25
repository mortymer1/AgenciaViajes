import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ClienteDto } from '../models/cliente.dto';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private altaUrl = 'http://localhost:10000/clientes/alta';  // URL registr/alta
  private loginUrl = 'http://localhost:10000/clientes/login/';  // URL login

  constructor(private http: HttpClient) {}

  // Método para hacer el registro/alta de usuario
  altaCliente(clienteData: any): Observable<any> {
    return this.http.post(this.altaUrl, clienteData);
  }
  // Método para hacer la petición de login
  login(usuario: string, password: string): Observable<ClienteDto> {
    const url = `${this.loginUrl}${usuario}/${password}`;
    return this.http.get<ClienteDto>(url);
  }

}
