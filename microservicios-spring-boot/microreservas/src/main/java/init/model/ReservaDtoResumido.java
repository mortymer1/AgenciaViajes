package init.model;

public class ReservaDtoResumido {

    private String usuario;
    private int hotel;
    private int vuelo;
    private int plazas;

	public ReservaDtoResumido(String usuario, int hotel, int vuelo, int plazas) {
		super();
		this.usuario = usuario;
		this.hotel = hotel;
		this.vuelo = vuelo;
		this.plazas = plazas;
	}

	public ReservaDtoResumido() {
		super();
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

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
    
}