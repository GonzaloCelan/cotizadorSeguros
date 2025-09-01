package com.cotizador.cotizadorSeguros.service;

import java.util.List;
import java.util.Map;

import com.cotizador.cotizadorSeguros.dto.request.ConsultaRequestDTO;
import com.cotizador.cotizadorSeguros.dto.response.PlanDTO;
import com.cotizador.cotizadorSeguros.dto.response.PlanDetalleDTO;
import com.cotizador.cotizadorSeguros.model.ClienteConsulta;
import com.cotizador.cotizadorSeguros.model.ResultadoCotizacion;

import jakarta.validation.Valid;

public interface IPrecioPlanService {

	
	
	List<PlanDTO> cotizarPlanes(ClienteConsulta cliente);
	PlanDTO cotizarPlanId(String proveedor,ClienteConsulta cliente, int idPlan);
	PlanDetalleDTO DetallePlanById(ClienteConsulta cliente, int idPlan, String proveedor);
	
  

}
