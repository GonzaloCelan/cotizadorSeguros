package com.cotizador.cotizadorSeguros.dto.response;

import java.math.BigDecimal;


public class PlanDTO
{
	
	private String proveedor;
	private int idPlan;
	private String nombrePlan;
	private BigDecimal valor;
	private EstadoPlan estado;
	
	
	
	public PlanDTO(String proveedor, String nombrePlan, BigDecimal valor) 
	{
		this.proveedor = proveedor;
		this.nombrePlan = nombrePlan;
		setValor(valor);
	}
	
	public PlanDTO(String proveedor,int idPlan, String nombrePlan, BigDecimal valor) 
	{
		this.proveedor = proveedor;
		this.idPlan = idPlan;
		this.nombrePlan = nombrePlan;
		
		setValor(valor);
		
	}
	
	
	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getNombrePlan() {
		return nombrePlan;
	}
	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
		
		 if (valor == null) {
		        this.estado = EstadoPlan.SIN_ACCESO;
		    } else if (valor.compareTo(BigDecimal.ZERO) == 0) {
		    	
		        this.estado = EstadoPlan.COBERTURA_TOTAL;
		        
		    } else {
		        this.estado = EstadoPlan.CON_DIFERENCIA;
		    }
	}
	
	public EstadoPlan getEstado() {
		return estado;
	}
	



}



		