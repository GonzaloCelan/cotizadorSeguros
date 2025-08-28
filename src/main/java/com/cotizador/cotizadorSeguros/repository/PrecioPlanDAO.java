package com.cotizador.cotizadorSeguros.repository;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.cotizador.cotizadorSeguros.dto.response.EstadoPlan;
import com.cotizador.cotizadorSeguros.dto.response.PlanDTO;
import com.cotizador.cotizadorSeguros.model.ClienteConsulta;
import com.cotizador.cotizadorSeguros.model.ResultadoCotizacion;

@Repository
public class PrecioPlanDAO {
	
	    

	    private final DataSource dataSource;

	   
	    public PrecioPlanDAO(DataSource dataSource) {
	        this.dataSource = dataSource;
	    }

	    
	    
 	    public List<ResultadoCotizacion> cotizadorSwissMedical(ClienteConsulta consulta) {
	    	
	  
 	    	 List<ResultadoCotizacion> resultados = new ArrayList<>();
 	    	 
	        try (Connection conn = dataSource.getConnection()) {
	        	
	            String sql = "{CALL sp_cotizadorSwissMedical(?, ?, ?, ?, ?, ?, ?)}";
	            
	            CallableStatement stmt = conn.prepareCall(sql);

	            
	            stmt.setInt(1, consulta.getEdadTitular());
	            stmt.setBoolean(2, consulta.isTienePareja());
	            stmt.setInt(3, consulta.getEdadPareja());
	            stmt.setBoolean(4, consulta.isTieneHijos());
	            stmt.setInt(5, consulta.getCantidadHijos());
	            stmt.setInt(6, consulta.getIdAfiliacion());
	            stmt.setDouble(7, consulta.getSueldoBruto());
	            
	            ResultSet rs = stmt.executeQuery(); 
        		
	            while (rs.next()) {
	               ResultadoCotizacion r = new ResultadoCotizacion();
	               r.setIdPlan(rs.getInt("id_plan"));
	               r.setNombrePlan(rs.getString("nombre_plan"));
	               r.setValorPlan(rs.getBigDecimal("valorPlan"));
	               r.setValorHijo(rs.getBigDecimal("valorHijo"));
	               r.setValorHijoAdicional(rs.getBigDecimal("valorHijoAdicional"));
	               r.setAfiliacion(rs.getInt("afiliacion"));
	               r.setCantidadPersona(rs.getInt("cantidadPersona"));
	               r.setSueldoBruto(rs.getBigDecimal("sueldoBruto"));
	               r.setAporteObraSocial(rs.getBigDecimal("aporteObraSocial"));
	               r.setValorFinal(rs.getBigDecimal("valorFinal"));
	               resultados.add(r);
	            }
	            
	            

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return resultados;
	    	
	    }
	    

	    public List<ResultadoCotizacion> cotizadorDoctoRed(ClienteConsulta cliente) {
	    	
	        List<ResultadoCotizacion> resultados = new ArrayList<>();
	        

	        try (Connection conn = dataSource.getConnection()) {
	        	
	            String sql = "{CALL sp_cotizadorDoctoRed(?, ?, ?, ?, ?)}";
	            
	            CallableStatement stmt = conn.prepareCall(sql);
	            
	            
	            stmt.setInt(1, cliente.getEdadTitular());
	            stmt.setBoolean(2, cliente.isTienePareja());
	            stmt.setBoolean(3, cliente.isTieneHijos());
	            stmt.setInt(4, cliente.getCantidadHijos());
	            stmt.setInt(5, cliente.getIdAfiliacion());
	          
	           

	            ResultSet rs = stmt.executeQuery(); 
	            		
	            while (rs.next()) {
	               ResultadoCotizacion r = new ResultadoCotizacion();
	               r.setIdPlan(rs.getInt("id_plan"));
	               r.setNombrePlan(rs.getString("nombre_plan"));
	               r.setValorPlan(rs.getBigDecimal("valorPlan"));
	               r.setValorHijo(rs.getBigDecimal("valorHijo"));
	               r.setValorHijoAdicional(rs.getBigDecimal("valorHijoAdicional"));
	               r.setAfiliacion(rs.getInt("afiliacion"));
	               r.setCantidadPersona(rs.getInt("cantidadPersona"));
	               r.setSueldoBruto(rs.getBigDecimal("sueldoBruto"));
	               r.setAporteObraSocial(rs.getBigDecimal("aporteObraSocial"));
	               r.setValorFinal(rs.getBigDecimal("valorFinal"));
	               resultados.add(r);
	            }
	            
	            
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        
	        return resultados;
	    	
	    }
	    
	    
	    public List<ResultadoCotizacion> cotizadorJerarquicos(ClienteConsulta cliente) {
	    	
	    	List<ResultadoCotizacion> resultados = new ArrayList<>();
	        

	        try (Connection conn = dataSource.getConnection()) {
	        	
	            String sql = "{CALL sp_cotizadorJerarquicos( ?, ?, ?, ?, ?, ?, ?)}";
	            
	            CallableStatement stmt = conn.prepareCall(sql);
	            
	            
	         
	            stmt.setInt(1, cliente.getEdadTitular());
	            stmt.setString(2, cliente.getGeneroTitular());
	            stmt.setBoolean(3, cliente.isTienePareja());
	            stmt.setInt(4, cliente.getEdadPareja());
	            stmt.setString(5, cliente.getGeneroPareja());
	            stmt.setInt(6, cliente.getIdAfiliacion());
	            stmt.setDouble(7,cliente.getSueldoBruto());
	            

	            ResultSet rs = stmt.executeQuery(); 
	            		
	            while (rs.next()) {
	               ResultadoCotizacion r = new ResultadoCotizacion();
	               r.setIdPlan(rs.getInt("id_plan"));
	               r.setNombrePlan(rs.getString("nombre_plan"));
	               r.setValorPlan(rs.getBigDecimal("valorPlan"));
	               r.setValorHijo(rs.getBigDecimal("valorHijo"));
	               r.setValorHijoAdicional(rs.getBigDecimal("valorHijoAdicional"));
	               r.setAfiliacion(rs.getInt("afiliacion"));
	               r.setCantidadPersona(rs.getInt("cantidadPersona"));
	               r.setSueldoBruto(rs.getBigDecimal("sueldoBruto"));
	               r.setAporteObraSocial(rs.getBigDecimal("aporteObraSocial"));
	               r.setValorFinal(rs.getBigDecimal("valorFinal"));
	               resultados.add(r);
	               
	            }
	            

	          
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return resultados;
	    	
	    }
	    	
	    
	    public List<ResultadoCotizacion> cotizadorJerarquicosPM(ClienteConsulta cliente) {
		    	
	    		List<ResultadoCotizacion> resultados = new ArrayList<>();

		        try (Connection conn = dataSource.getConnection()) {
		        	
		            String sql = "{CALL sp_cotizadorJerarquicosPM(?, ?, ?)}";
		            
		            CallableStatement stmt = conn.prepareCall(sql);
		            
		            
		            stmt.setInt(1, cliente.getCantidad());
		            stmt.setInt(2, cliente.getEdadTitular());
		            stmt.setInt(3, cliente.getIdAfiliacion());
		            
		            
		           

		            ResultSet rs = stmt.executeQuery(); 
            		
		            while (rs.next()) {
		               ResultadoCotizacion r = new ResultadoCotizacion();
		               r.setIdPlan(rs.getInt("id_plan"));
		               r.setNombrePlan(rs.getString("nombre_plan"));
		               r.setValorPlan(rs.getBigDecimal("valorPlan"));
		               r.setAfiliacion(rs.getInt("afiliacion"));
		               r.setCantidadPersona(rs.getInt("cantidadPersona"));
		               r.setAporteObraSocial(rs.getBigDecimal("aporteObraSocial"));
		               r.setValorFinal(rs.getBigDecimal("valorFinal"));
		               resultados.add(r);
		            }
		            
		            
		            
		            
		            
		        } catch (Exception e) {
		            e.printStackTrace();
		        }

		        return resultados;
		    	
		    }
	    

}
