package com.cotizador.cotizadorSeguros.model;

import java.math.BigDecimal;

public class ResultadoCotizacion {
	
	private int idPlan;
	private String NombrePlan;
	private BigDecimal valorPlan;
	private BigDecimal valorHijo;
	private BigDecimal valorHijoAdicional;
	private BigDecimal recargoEdadTitular;
	private BigDecimal recargoEdadPareja;
	private BigDecimal servicioMutual;
	private BigDecimal bonificacion;
	private int afiliacion;
	private int cantidadPersona;
	private BigDecimal sueldoBruto;
	private BigDecimal aporteObraSocial;
	private BigDecimal valorFinal;
	
   
	public ResultadoCotizacion(int idPlan, String nombrePlan, BigDecimal valorPlan, BigDecimal valorHijo,
			BigDecimal valorHijoAdicional, int afiliacion, int cantidadPersona, BigDecimal sueldoBruto,
			BigDecimal aporteObraSocial, BigDecimal valorFinal) {
		super();
		this.idPlan = idPlan;
		NombrePlan = nombrePlan;
		this.valorPlan = valorPlan;
		this.valorHijo = valorHijo;
		this.valorHijoAdicional = valorHijoAdicional;
		this.afiliacion = afiliacion;
		this.cantidadPersona = cantidadPersona;
		this.sueldoBruto = sueldoBruto;
		this.aporteObraSocial = aporteObraSocial;
		this.valorFinal = valorFinal;
	}


	
	public ResultadoCotizacion() {
      
        
    }
	
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
