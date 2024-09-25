export interface ReservaDto {
    idreserva: number;
    destino: string;
    hotel: string;
    vuelo: string;  // O podría ser un número si solo quieres mostrar el ID
    plazas: number;
    fecha: string;
    precio: number;  // Para la columna Total
  }