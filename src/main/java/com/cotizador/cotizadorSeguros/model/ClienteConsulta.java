package com.cotizador.cotizadorSeguros.model;

public class ClienteConsulta {
	
		private String nombre;
		private String telefono;
		private int cantidad;
		private int edadTitular;
		private String generoTitular;
		private boolean tienePareja;
		private String generoPareja;
		private int edadPareja;
		private boolean tieneHijos;
		private int cantidadHijos;
		private int idAfiliacion;
		private double sueldoBruto;
		
		

		public ClienteConsulta() {}
		
		public ClienteConsulta(String nombre, String telefono,int cantidad,int edadTitular,String generoTitular, boolean tienePareja, int edadPareja, String generoPareja,boolean tieneHijos, int cantidadHijos,int idAfiliacion, double sueldoBruto ) {
			this.nombre = nombre;
			this.telefono = telefono;
			this.cantidad = cantidad;
			this.edadTitular = edadTitular;
			this.generoTitular = generoTitular;
			this.tienePareja = tienePareja;
			this.edadPareja = edadPareja;
			this.generoPareja = generoPareja;
			this.tieneHijos = tieneHijos;
			this.cantidadHijos = cantidadHijos;
			this.idAfiliacion = idAfiliacion;
			this.sueldoBruto = sueldoBruto;
			
			
		}
		
		
		
		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		public String getGeneroTitular() {
			return generoTitular;
		}

		public void setGeneroTitular(String generoTitular) {
			this.generoTitular = generoTitular;
		}

		public String getGeneroPareja() {
			return generoPareja;
		}

		public void setGeneroPareja(String generoPareja) {
			this.generoPareja = generoPareja;
		}
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		
		public int getEdadTitular() {
			return edadTitular;
		}
		public void setEdadTitular(int edadTitular) {
			this.edadTitular = edadTitular;
		}
		public boolean isTienePareja() {
			return tienePareja;
		}
		public void setTienePareja(boolean tienePareja) {
			this.tienePareja = tienePareja;
		}
		public int getEdadPareja() {
			return edadPareja;
		}
		public void setEdadPareja(int edadPareja) {
			this.edadPareja = edadPareja;
		}
		public boolean isTieneHijos() {
			return tieneHijos;
		}
		public void setTieneHijos(boolean tieneHijos) {
			this.tieneHijos = tieneHijos;
		}
		public int getCantidadHijos() {
			return cantidadHijos;
		}
		public void setCantidadHijos(int cantidadHijos) {
			this.cantidadHijos = cantidadHijos;
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
		
		

}
