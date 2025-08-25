package com.cotizador.cotizadorSeguros.model;

public class Cliente {
	
	
	private int idCliente;
    private String nombre;
    private String apellido;
    private int edad;
    private int idAfiliacion;
    private double sueldoBruto;
    private Integer telefono; // Usamos Integer por si puede ser NULL
    private String email;
    
    
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getIdAfiliacion() {
		return idAfiliacion;
	}
	public void setIdAfiliacion(int idAfiliacion) {
		this.idAfiliacion = idAfiliacion;
	}
	public double getSueldoBruto() {
		return sueldoBruto;
	}
	public void setSueldoBruto(double sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

    

}
