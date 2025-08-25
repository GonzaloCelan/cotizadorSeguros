package com.cotizador.cotizadorSeguros.model;

public class Plan {

	
		private int idPlan;
	    private int idObraSocial;
	    private String nombre;
	    private int idCobertura;
	    private String descripcion;
	    
		public int getIdPlan() {
			return idPlan;
		}
		public void setIdPlan(int idPlan) {
			this.idPlan = idPlan;
		}
		public int getIdObraSocial() {
			return idObraSocial;
		}
		public void setIdObraSocial(int idObraSocial) {
			this.idObraSocial = idObraSocial;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getIdCobertura() {
			return idCobertura;
		}
		public void setIdCobertura(int idCobertura) {
			this.idCobertura = idCobertura;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
	    
	    
}
