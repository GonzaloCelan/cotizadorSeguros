package com.cotizador.cotizadorSeguros.model;

import java.math.BigDecimal;

public class ResultadoCotizacion {
	
	private int idPlan;
	private String NombrePlan;
	private BigDecimal valor;
   
	
	public ResultadoCotizacion(int idPlan, String nombrePlan, BigDecimal valor) {
        this.idPlan = idPlan;
        this.NombrePlan = nombrePlan;
        this.valor = valor;
        
    }
	
	public ResultadoCotizacion() {
      
        
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	

    
   

}
