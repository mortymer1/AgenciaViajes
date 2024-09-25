import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReservasService } from '../services/reservar.service';  // Importar el servicio
import { Vuelo } from '../models/vuelo.dto';  // Importar el modelo Vuelo
import { Hotel } from '../models/hotel.dto';  // Importar el modelo Hotel

@Component({
  selector: 'app-reservar',
  templateUrl: './reservar.component.html',
  styleUrls: ['./reservar.component.css']
})
export class ReservarComponent implements OnInit {
  reservarForm: FormGroup;
  destinos: string[] = [];
  hoteles: Hotel[] = [];  // Cambia a tipo Hotel[]
  vuelos: Vuelo[] = [];  // Lista de vuelos para mostrar

  constructor(private fb: FormBuilder, private reservasService: ReservasService) {
    this.reservarForm = this.fb.group({
      destino: ['', Validators.required],
      hotel: ['', Validators.required],
      personas: [null, [Validators.required, Validators.min(1), Validators.max(4)]],
      vuelo: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.cargarDestinos();
    this.detectarCambiosEnDestino();
    this.detectarCambiosEnDestinoYPersonas();
  }

  // Método para cargar destinos
  cargarDestinos() {
    this.reservasService.getDestinos().subscribe(
      (data: string[]) => {
        this.destinos = data;
      },
      (error) => {
        console.error('Error al cargar los destinos', error);
      }
    );
  }

  // Detectar cambios en destino para cargar hoteles
  detectarCambiosEnDestino() {
    this.reservarForm.get('destino')?.valueChanges.subscribe(localizacion => {
      if (localizacion) {
        this.cargarHoteles(localizacion);  // Cargar los hoteles cuando se selecciona un destino
      } else {
        this.hoteles = [];  // Limpiar la lista de hoteles si no hay destino seleccionado
      }
    });
  }

  // Método para cargar hoteles cuando se selecciona un destino
  cargarHoteles(localizacion: string) {
    this.reservasService.getHoteles(localizacion).subscribe(
      (data: Hotel[]) => {
        this.hoteles = data;
      },
      (error) => {
        console.error('Error al cargar los hoteles', error);
      }
    );
  }

  // Detectar cambios en destino y número de personas para cargar los vuelos
  detectarCambiosEnDestinoYPersonas() {
    this.reservarForm.get('destino')?.valueChanges.subscribe(() => {
      this.cargarVuelos();
    });

    this.reservarForm.get('personas')?.valueChanges.subscribe(() => {
      this.cargarVuelos();
    });
  }

  // Método para cargar vuelos cuando se selecciona un destino y número de personas
  cargarVuelos() {
    const destino = this.reservarForm.get('destino')?.value;
    const personas = this.reservarForm.get('personas')?.value;

    if (destino && personas) {
      this.reservasService.getVuelos(destino, personas).subscribe(
        (data: Vuelo[]) => {
          this.vuelos = data;
        },
        (error) => {
          console.error('Error al cargar los vuelos', error);
        }
      );
    }
  }

  // Método para seleccionar un vuelo
  seleccionarVuelo(idvuelo: number) {
    this.reservarForm.patchValue({ vuelo: idvuelo });
  }

  // Método para enviar la reserva
  onReservar() {
    if (this.reservarForm.valid) {
      const hotelNombre = this.reservarForm.get('hotel')?.value;
      const vueloId = this.reservarForm.get('vuelo')?.value;
      const personas = this.reservarForm.get('personas')?.value;
  
      // Buscar el hotel seleccionado en el array de hoteles
      const hotelSeleccionado = this.hoteles.find(hotel => hotel.nombre === hotelNombre);
  
      // Buscar el vuelo seleccionado en el array de vuelos
      const vueloSeleccionado = this.vuelos.find(vuelo => vuelo.idvuelo === vueloId);
  
      // Obtener el usuario desde el localStorage
      const clienteString = localStorage.getItem('cliente');
      const cliente = clienteString ? JSON.parse(clienteString) : null;
  
      if (hotelSeleccionado && vueloSeleccionado && cliente) {
        // Calcular el precio total (precio vuelo + precio hotel)
        const precioTotal = vueloSeleccionado.precio + hotelSeleccionado.precio;
  
        // Crear el objeto de reserva con los IDs y el nombre de usuario
        const reserva = {
          hotel: hotelSeleccionado.idHotel,  // Enviar el ID del hotel
          vuelo: vueloSeleccionado.idvuelo,  // Enviar el ID del vuelo
          plazas: personas,
          precio: precioTotal,
          usuario: cliente.usuario  // Extraer el nombre de usuario desde el objeto cliente
        };
  
        // Llamar al servicio para enviar la reserva al backend
        this.reservasService.hacerReserva(reserva).subscribe(
          (response) => {
            console.log('Reserva realizada con éxito:', response);
          },
          (error) => {
            console.error('Error al realizar la reserva:', error);
          }
        );
      }
    }
  }
}
