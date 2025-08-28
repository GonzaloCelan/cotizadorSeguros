package com.cotizador.cotizadorSeguros.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import org.springframework.stereotype.Service;

import com.cotizador.cotizadorSeguros.dto.request.ConsultaRequestDTO;
import com.cotizador.cotizadorSeguros.dto.response.PlanDTO;
import com.cotizador.cotizadorSeguros.dto.response.PlanDetalleDTO;
import com.cotizador.cotizadorSeguros.model.ClienteConsulta;
import com.cotizador.cotizadorSeguros.model.ResultadoCotizacion;
import com.cotizador.cotizadorSeguros.repository.PrecioPlanDAO;

import jakarta.validation.Valid;

@Service
public class PrecioPlanServiceImpl implements IPrecioPlanService{

	
	private final PrecioPlanDAO precioPlanDAO;
	
	 public PrecioPlanServiceImpl(PrecioPlanDAO precioPlanDAO) {
	        this.precioPlanDAO = precioPlanDAO;
	 
	 }
	 
	 
	//METODO PRIVADO PARA AÑADIR LOS PLANES
	 
	private void agregarPlanes(String proveedor, List<ResultadoCotizacion> lista, List<PlanDTO> planes) {
	    	
	        for (ResultadoCotizacion r : lista) {
	            planes.add(new PlanDTO(proveedor,r.getIdPlan(), r.getNombrePlan(), r.getValorFinal()));
	        }
	 }
	
	
	
	
	@Override
	public PlanDTO cotizarPlanId (String proveedor,ClienteConsulta cliente, int idPlan) {
		
		PlanDTO plan = null;
		
		List<PlanDTO> planes = new ArrayList<PlanDTO>();
		
		
		switch (proveedor) {
		
		case "Jerarquicos" -> {
			
			agregarPlanes(proveedor, precioPlanDAO.cotizadorJerarquicos(cliente), planes);
		}
		
		case "DoctoRed" -> {
			
			agregarPlanes(proveedor, precioPlanDAO.cotizadorDoctoRed(cliente), planes);
		}
		
		case "SwissMedical" -> {
			
			agregarPlanes(proveedor, precioPlanDAO.cotizadorSwissMedical(cliente), planes);
		}
		
		default -> { }
		
		}
		
		 plan = planes.stream()
			    .filter(p -> p.getIdPlan() == idPlan)
			    .findFirst()
			    .orElse(null);
		 
		 return plan;
		
		
		}
	
	

	
	
	@Override
	public List<PlanDTO> cotizarPlanes(ClienteConsulta cliente)
	{
		// creo una list de planes //
		
		List<PlanDTO> planes = new ArrayList<PlanDTO>();

		// consulto el id afiliacion //
		
	    switch (cliente.getIdAfiliacion()) {

	        case 1 -> {
	        	
	        	agregarPlanes("Jerarquicos", precioPlanDAO.cotizadorJerarquicos(cliente), planes);


	        }

	        case 2 -> {
	        	
	        	agregarPlanes("Jerarquicos", precioPlanDAO.cotizadorJerarquicosPM(cliente), planes);
	        	agregarPlanes("DoctoRed", precioPlanDAO.cotizadorDoctoRed(cliente), planes);
	        }

	        
	        case 3 -> {
	        	
	        	agregarPlanes("DoctoRed", precioPlanDAO.cotizadorDoctoRed(cliente), planes);
	        	agregarPlanes("Jerarquicos", precioPlanDAO.cotizadorJerarquicosPM(cliente), planes);
	            
	        }

	        default -> { }
	        
	    }
	    
	    return planes;
	 
	}
	
	
	@Override
	public PlanDetalleDTO DetallePlanById(ClienteConsulta cliente, int id)
	{
		List<ResultadoCotizacion> resultados = new ArrayList<>();
		
		   switch (cliente.getIdAfiliacion()) {
	        case 1 -> {
	        	resultados.addAll(precioPlanDAO.cotizadorJerarquicos(cliente));
	        }
	        case 2 -> {
	            resultados.addAll(precioPlanDAO.cotizadorJerarquicosPM(cliente));
	            resultados.addAll(precioPlanDAO.cotizadorDoctoRed(cliente));
	        }
	        case 3 -> {
	            resultados.addAll(precioPlanDAO.cotizadorJerarquicosPM(cliente));
	            resultados.addAll(precioPlanDAO.cotizadorDoctoRed(cliente));
	        }
	    }
		
		for (ResultadoCotizacion r : resultados) {
	        if (r.getIdPlan() == id) {
	        	
	            PlanDetalleDTO dto = new PlanDetalleDTO();
	            
	            dto.setIdPlan(r.getIdPlan());
	            dto.setValorPlan(r.getValorPlan());
	            dto.setValorHijo(r.getValorHijo());
	            dto.setValorHijoAdicional(r.getValorHijoAdicional());
	            dto.setAfiliacion(r.getAfiliacion());
	            dto.setCantidadPersona(r.getCantidadPersona());
	            dto.setSueldoBruto(r.getSueldoBruto());
	            dto.setAporteObraSocial(r.getAporteObraSocial());
	            dto.setValorFinal(r.getValorFinal());
	            return dto;
	        }
	    }

	    return null;
	}
	
	
}
	
	
