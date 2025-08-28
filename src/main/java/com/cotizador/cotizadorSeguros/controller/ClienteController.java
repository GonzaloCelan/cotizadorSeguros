package com.cotizador.cotizadorSeguros.controller;


import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cotizador.cotizadorSeguros.dto.request.ConsultaRequestDTO;
import com.cotizador.cotizadorSeguros.dto.response.PlanDTO;
import com.cotizador.cotizadorSeguros.dto.response.PlanDetalleDTO;
import com.cotizador.cotizadorSeguros.model.ClienteConsulta;
import com.cotizador.cotizadorSeguros.service.IPrecioPlanService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/cotizador")

public class ClienteController {

	
		private IPrecioPlanService service;
		
		ClienteController(IPrecioPlanService service) {this.service = service;};
	
	  	// endpoint para traer todos los planes ya cotizados
		@PostMapping
		("/consultar")
	  
	    public ResponseEntity<List<PlanDTO>> consultarPlan(@RequestBody @Valid ConsultaRequestDTO request) {
			
			 // Mapeo del DTO a la entidad ClienteConsulta
			
			ClienteConsulta cliente = mapToClienteConsulta(request);
		    // recibo una list de planes, desde la capa service 
		    
			List<PlanDTO> resultado = service.cotizarPlanes(cliente);
			return ResponseEntity.ok(resultado);

	    }
		
		//endpoint para traer un plan cotizado en especifico
		
		@PostMapping
		("/consultar/{proveedor}/{id}")
		  
	    public ResponseEntity<PlanDTO> consultarPlanById(
	    		@PathVariable String proveedor,
	    		@PathVariable int id, 
	    		@RequestBody @Valid ConsultaRequestDTO request) {
			
			ClienteConsulta cliente = mapToClienteConsulta(request);
			    
			PlanDTO resultado = service.cotizarPlanId(proveedor, cliente, id);
			
			return ResponseEntity.ok(resultado);

	    }
		
		@PostMapping
		("/detalle/{id}")
		  
	    public ResponseEntity<PlanDetalleDTO> consultarPlanDetalleById(
	    		@PathVariable int id,
	    		@RequestBody @Valid ConsultaRequestDTO request) {
			    
			ClienteConsulta cliente = mapToClienteConsulta(request);
			
			PlanDetalleDTO resultado = service.DetallePlanById(cliente, id);
			
			return ResponseEntity.ok(resultado);

	    }
		
		
		//metodo para mapear el request a un objeto cliente
		
		private ClienteConsulta mapToClienteConsulta(ConsultaRequestDTO request) {
		    ClienteConsulta cliente = new ClienteConsulta();
		    cliente.setCantidad(request.getCantidad());
		    cliente.setEdadTitular(request.getEdadTitular());
		    cliente.setGeneroTitular(request.getGeneroTitular());
		    cliente.setTienePareja(request.isTienePareja());
		    cliente.setGeneroPareja(request.getGeneroPareja());
		    cliente.setEdadPareja(request.getEdadPareja());
		    cliente.setTieneHijos(request.isTieneHijos());
		    cliente.setCantidadHijos(request.getCantidadHijos());
		    cliente.setIdAfiliacion(request.getIdAfiliacion());
		    cliente.setSueldoBruto(request.getSueldoBruto());
		    return cliente;
		}
		
		
	
}
