package com.cotizador.cotizadorSeguros.dto.response;

public enum EstadoPlan {
	
	  SIN_ACCESO,      // valor = null
	  COBERTURA_TOTAL, // valor = 0.00
	  CON_DIFERENCIA,  // valor > 0
	  ERROR            // fallo al calcular ese plan

}
