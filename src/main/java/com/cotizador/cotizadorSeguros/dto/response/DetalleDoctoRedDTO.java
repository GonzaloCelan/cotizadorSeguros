package com.cotizador.cotizadorSeguros.dto.response;

import java.math.BigDecimal;

public class DetalleDoctoRedDTO extends PlanDetalleDTO{
	
	
	
	private BigDecimal valorHijo;
	private BigDecimal valorHijoAdicional;
	private int afiliacion;
	private int cantidadPersona;
	

	
	public BigDecimal getValorHijo() {
		return valorHijo;
	}
	public void setValorHijo(BigDecimal valorHijo) {
		this.valorHijo = valorHijo;
	}
	public BigDecimal getValorHijoAdicional() {
		return valorHijoAdicional;
	}
	public void setValorHijoAdicional(BigDecimal valorHijoAdicional) {
		this.valorHijoAdicional = valorHijoAdicional;
	}
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
