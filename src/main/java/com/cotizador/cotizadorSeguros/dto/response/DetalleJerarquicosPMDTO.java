package com.cotizador.cotizadorSeguros.dto.response;

import java.math.BigDecimal;

public class DetalleJerarquicosPMDTO  extends PlanDetalleDTO {

	
	
	private int afiliacion;
	private int cantidadPersona;
	
	
	
	
	public int getAfiliacion() {
		return afiliacion;
	}
	public void setAfiliacion(int afiliacion) {
		this.afiliacion = afiliacion;
	}
	public int getCantidadPersona() {
		return cantidadPersona;
	}
	public void setCantidadPersona(int cantidadPersona) {
		this.cantidadPersona = cantidadPersona;
	}
	
	
}


