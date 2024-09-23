package init.model;

public class ReservaDto {

    private int idreserva;
    private String usuario;
    private int hotel;
    private int vuelo;
    private double precio;
    private int plazas;

    public ReservaDto() {}

    public ReservaDto(int idreserva, String usuario, int hotel, int vuelo, double precio, int plazas) {
        this.idreserva = idreserva;
        this.usuario = usuario;
        this.hotel = hotel;
        this.vuelo = vuelo;
        this.precio = precio;
        this.plazas = plazas;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
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
}
