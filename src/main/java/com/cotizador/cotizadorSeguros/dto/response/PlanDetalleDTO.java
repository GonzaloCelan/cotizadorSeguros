package com.cotizador.cotizadorSeguros.dto.response;

import java.math.BigDecimal;

public abstract class  PlanDetalleDTO {

	private int idPlan;
	private String NombrePlan;
	private BigDecimal valorPlan;
	private BigDecimal sueldoBruto;
	private BigDecimal aporteObraSocial;
	private BigDecimal valorFinal;
	
	
	
	public BigDecimal getValorPlan() {
		return valorPlan;
	}
	public void setValorPlan(BigDecimal valorPlan) {
		this.valorPlan = valorPlan;
	}
	public int getIdPlan() {
		return idPlan;
	}
	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}
	public String getNombrePlan() {
		return NombrePlan;
	}
	public void setNombrePlan(String nombrePlan) {
		NombrePlan = nombrePlan;
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
