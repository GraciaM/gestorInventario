package proyectoFinalnventario;

import java.io.Serializable;

public class Proveedor {

	private String CIF;
	private String empresa;
	private String direccion;
	private String ciudad;
	private int telefono;
	private String email;

	public Proveedor(String CIF, String empresa) {
		this.CIF = CIF;
		this.empresa = empresa;
	}

	public String getCIF() {
		return CIF;
	}

	public String getEmpresa() {
		return empresa;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public int getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Proveedor [CIF=" + CIF + ", empresa=" + empresa + ", direccion=" + direccion + ", ciudad=" + ciudad
				+ ", telefono=" + telefono + ", email=" + email + "]";
	}

}
