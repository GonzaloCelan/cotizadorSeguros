package com.cotizador.cotizadorSeguros.dto.response;

import java.math.BigDecimal;

public class DetalleJerarquicosDTO extends PlanDetalleDTO{
	
	
	private BigDecimal recargoEdadTitular;
	private BigDecimal recargoEdadPareja;
	private BigDecimal servicioMutual;
	private BigDecimal bonificacion;
	private int afiliacion;
	private int cantidadPersona;
	
	
	

	public BigDecimal getRecargoEdadTitular() {
		return recargoEdadTitular;
	}
	public void setRecargoEdadTitular(BigDecimal recargoEdadTitular) {
		this.recargoEdadTitular = recargoEdadTitular;
	}
	public BigDecimal getRecargoEdadPareja() {
		return recargoEdadPareja;
	}
	public void setRecargoEdadPareja(BigDecimal recargoEdadPareja) {
		this.recargoEdadPareja = recargoEdadPareja;
	}
	public BigDecimal getServicioMutual() {
		return servicioMutual;
	}
	public void setServicioMutual(BigDecimal servicioMutual) {
		this.servicioMutual = servicioMutual;
	}
	public BigDecimal getBonificacion() {
		return bonificacion;
	}
	public void setBonificacion(BigDecimal bonificacion) {
		this.bonificacion = bonificacion;
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
