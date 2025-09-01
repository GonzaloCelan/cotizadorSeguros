package com.cotizador.cotizadorSeguros.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import org.springframework.stereotype.Service;

import com.cotizador.cotizadorSeguros.dto.request.ConsultaRequestDTO;
import com.cotizador.cotizadorSeguros.dto.response.DetalleDoctoRedDTO;
import com.cotizador.cotizadorSeguros.dto.response.DetalleJerarquicosDTO;
import com.cotizador.cotizadorSeguros.dto.response.DetalleSwissDTO;
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
	        	
	        	agregarPlanes("SwissMedical", precioPlanDAO.cotizadorSwissMedical(cliente), planes);
	        	agregarPlanes("Jerarquicos", precioPlanDAO.cotizadorJerarquicos(cliente), planes);//


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
	public PlanDetalleDTO DetallePlanById(ClienteConsulta cliente, int id, String proveedor)
	{
		 switch (proveedor) {

	        case "Jerarquicos" : {
	        	
	        	ResultadoCotizacion r = precioPlanDAO.detallePlanJerarquicos(cliente, id);
	        	DetalleJerarquicosDTO plan = new DetalleJerarquicosDTO();
	        	plan.setIdPlan(r.getIdPlan());
	        	plan.setNombrePlan(r.getNombrePlan());
	        	plan.setValorPlan(r.getValorPlan());
	        	plan.setRecargoEdadTitular(r.getRecargoEdadTitular());
	        	plan.setRecargoEdadPareja(r.getRecargoEdadPareja());
	        	plan.setServicioMutual(r.getServicioMutual());
	        	plan.setBonificacion(r.getBonificacion());
	        	plan.setAfiliacion(r.getAfiliacion());
	        	plan.setCantidadPersona(r.getCantidadPersona());
	        	plan.setSueldoBruto(r.getSueldoBruto());
	        	plan.setAporteObraSocial(r.getAporteObraSocial());
	        	plan.setValorFinal(r.getValorFinal());	
	        	
	        	return plan;
	        	

	        }

	        case "SwissMedical" : {
	        	ResultadoCotizacion r = precioPlanDAO.detallePlanSwiss(cliente, id);
	        	DetalleSwissDTO plan = new DetalleSwissDTO();
	        	plan.setIdPlan(r.getIdPlan());
	        	plan.setNombrePlan(r.getNombrePlan());
	        	plan.setValorPlan(r.getValorPlan());
	        	plan.setValorHijo(r.getValorHijo());
	        	plan.setValorHijoAdicional(r.getValorHijoAdicional());
	        	plan.setAfiliacion(r.getAfiliacion());
	        	plan.setCantidadPersona(r.getCantidadPersona());
	        	plan.setSueldoBruto(r.getSueldoBruto());
	        	plan.setAporteObraSocial(r.getAporteObraSocial());
	        	plan.setValorFinal(r.getValorFinal());	
	        	
	        	return plan;
	        	
	        }

	        
	        case "DoctoRed" : {
	        	
	        	ResultadoCotizacion r = precioPlanDAO.detallePlanDoctoRed(cliente, id);
	        	DetalleDoctoRedDTO plan = new DetalleDoctoRedDTO();
	        	plan.setIdPlan(r.getIdPlan());
	        	plan.setNombrePlan(r.getNombrePlan());
	        	plan.setValorPlan(r.getValorPlan());
	        	plan.setValorHijo(r.getValorHijo());
	        	plan.setValorHijoAdicional(r.getValorHijoAdicional());
	        	plan.setAfiliacion(r.getAfiliacion());
	        	plan.setCantidadPersona(r.getCantidadPersona());
	        	plan.setSueldoBruto(r.getSueldoBruto());
	        	plan.setAporteObraSocial(r.getAporteObraSocial());
	        	plan.setValorFinal(r.getValorFinal());	
	        	
	        	return plan;
	        }

	        default : { throw new IllegalArgumentException("Proveedor no reconocido: " + proveedor);}
	        
	    }
	
	}
	
}
	
	
