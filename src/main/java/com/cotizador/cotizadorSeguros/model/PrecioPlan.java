package com.cotizador.cotizadorSeguros.model;

public class PrecioPlan {

	
	private int idPrecio;
    private int idPlan;
    private int idAfiliacion;
    private int edadMin;
    private int edadMax;
    private double precioBase;
    private double precioPrimerHijo;
    private double precioHijoAdicional;

    
    public PrecioPlan() {
    }

    
    public PrecioPlan(int idPrecio, int idPlan, int idAfiliacion, int edadMin, int edadMax,
                      double precioBase, double precioPrimerHijo, double precioHijoAdicional) {
        this.idPrecio = idPrecio;
        this.idPlan = idPlan;
        this.idAfiliacion = idAfiliacion;
        this.edadMin = edadMin;
        this.edadMax = edadMax;
        this.precioBase = precioBase;
        this.precioPrimerHijo = precioPrimerHijo;
        this.precioHijoAdicional = precioHijoAdicional;
    }

    // Getters y Setters
    public int getIdPrecio() {
        return idPrecio;
    }

    public void setIdPrecio(int idPrecio) {
        this.idPrecio = idPrecio;
    }

    public int getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }

    public int getIdAfiliacion() {
        return idAfiliacion;
    }

    public void setIdAfiliacion(int idAfiliacion) {
        this.idAfiliacion = idAfiliacion;
    }

    public int getEdadMin() {
        return edadMin;
    }

    public void setEdadMin(int edadMin) {
        this.edadMin = edadMin;
    }

    public int getEdadMax() {
        return edadMax;
    }

    public void setEdadMax(int edadMax) {
        this.edadMax = edadMax;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getPrecioPrimerHijo() {
        return precioPrimerHijo;
    }

    public void setPrecioPrimerHijo(double precioPrimerHijo) {
        this.precioPrimerHijo = precioPrimerHijo;
    }

    public double getPrecioHijoAdicional() {
        return precioHijoAdicional;
    }

    public void setPrecioHijoAdicional(double precioHijoAdicional) {
        this.precioHijoAdicional = precioHijoAdicional;
    }
	    
	    
}
