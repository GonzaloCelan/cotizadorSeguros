package com.cotizador.cotizadorSeguros.dto.request;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class ConsultaRequestDTO {

    @Min(1)
    private int cantidad;

    @Min(0)
    private int edadTitular;

    @NotBlank
    private String generoTitular;

    @NotNull
    private boolean tienePareja;

    @NotBlank
    private String generoPareja;

    @Min(0)
    private int edadPareja;

    @NotNull
    private boolean tieneHijos;

    @Min(0)
    private int cantidadHijos;

    @Min(1)
    private int idAfiliacion;

    @PositiveOrZero
    private double sueldoBruto;
    
    private int idProveedor;
    
    private int idPlan;

    
    
    // Getters y Setters

    public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEdadTitular() {
        return edadTitular;
    }

    public void setEdadTitular(int edadTitular) {
        this.edadTitular = edadTitular;
    }

    public String getGeneroTitular() {
        return generoTitular;
    }

    public void setGeneroTitular(String generoTitular) {
        this.generoTitular = generoTitular;
    }

    public boolean isTienePareja() {
        return tienePareja;
    }

    public void setTienePareja(boolean tienePareja) {
        this.tienePareja = tienePareja;
    }

    public String getGeneroPareja() {
        return generoPareja;
    }

    public void setGeneroPareja(String generoPareja) {
        this.generoPareja = generoPareja;
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
