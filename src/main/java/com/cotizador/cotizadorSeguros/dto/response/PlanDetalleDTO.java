package com.cotizador.cotizadorSeguros.dto.response;

import java.math.BigDecimal;

public class PlanDetalleDTO {
	
	private int idPlan;
	private BigDecimal valorPlan;
	private BigDecimal valorHijo;
	private BigDecimal valorHijoAdicional;
	private int afiliacion;
	private int cantidadPersona;
	private BigDecimal sueldoBruto;
	private BigDecimal aporteObraSocial;
	private BigDecimal valorFinal;
	
	
	public int getIdPlan() {
		return idPlan;
	}
	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}
	public BigDecimal getValorPlan() {
		return valorPlan;
	}
	public void setValorPlan(BigDecimal valorPlan) {
		this.valorPlan = valorPlan;
	}
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
	public BigDecimal getSueldoBruto() {
		return sueldoBruto;
	}
	public void setSueldoBruto(BigDecimal sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}
	public BigDecimal getAporteObraSocial() {
		return aporteObraSocial;
	}
	public void setAporteObraSocial(BigDecimal aporteObraSocial) {
		this.aporteObraSocial = aporteObraSocial;
	}
	public BigDecimal getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}

	
	
}
