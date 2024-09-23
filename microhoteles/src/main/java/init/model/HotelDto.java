package init.model;

public class HotelDto {
	private int idHotel;
	private String nombre;
	private Double precio;
	private int categoria;
	private int disponible;
	private String localizacion;
	
	public HotelDto(int idHotel, String nombre, Double precio, int categoria, int disponible, String localizacion) {
		super();
		this.idHotel = idHotel;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
		this.disponible = disponible;
		this.localizacion = localizacion;
	}

	public HotelDto() {
		super();
	}

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	
}
