package init.model;

public class MisReservasDto {

    private String destino;
    private String hotel;
    private int vuelo;
    private double precio;
    private int plazas;
    private int idReserva;
    private String fecha;

    public MisReservasDto() {}

	public MisReservasDto(String destino, String hotel, int vuelo, double precio, int plazas, int idReserva,
			String fecha) {
		super();
		this.destino = destino;
		this.hotel = hotel;
		this.vuelo = vuelo;
		this.precio = precio;
		this.plazas = plazas;
		this.idReserva = idReserva;
		this.fecha = fecha;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public int getVuelo() {
		return vuelo;
	}

	public void setVuelo(int vuelo) {
		this.vuelo = vuelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
