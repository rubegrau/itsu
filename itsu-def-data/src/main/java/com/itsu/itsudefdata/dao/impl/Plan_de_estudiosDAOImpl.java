/**
 * 
 */
package com.itsu.itsudefdata.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itsu.itsu_def_entities.entity.Carrera;
import com.itsu.itsu_def_entities.entity.Plan_de_estudios;
import com.itsu.itsudefdata.connection.ConnectionFactory;
import com.itsu.itsudefdata.dao.Plan_de_estudiosDAO;
/**
 * 
 */
public class Plan_de_estudiosDAOImpl implements Plan_de_estudiosDAO{

	@Override
	public int guardar(Plan_de_estudios planDeEstudio) throws SQLException {
		String sql = "INSERT INTO bdd190924.plan_de_estudios (nombrePlan_de_Estudios, resolucionPlan_de_Estudios, Carrera_idCarrera) "
		        + "VALUES ('" + planDeEstudio.getNombrePlan_de_estudios() + "', '"
		        + planDeEstudio.getResolucionPlan_de_estudios() + "', '"
		        + planDeEstudio.getIdCarrera().getIdCarrera() + "');"; // Cerrando el paréntesis correctamente

		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		return ejecutado;

	}

	@Override
	public int actualizar(Plan_de_estudios planDeEstudio) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(int idPlan_de_estudios) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Plan_de_estudios> consultar() {
		// TODO Auto-generated method stub
		List<Plan_de_estudios> consultarPlanDeEstudios = new ArrayList<>();
	    String sql = "SELECT * FROM Plan_de_estudios;";

	    try (ResultSet rs = ConnectionFactory.ejecutarSQLSelect(sql)) {
	        if (rs != null) {
	            while (rs.next()) {
	                Plan_de_estudios  plan_de_estudios = new Plan_de_estudios();
	                plan_de_estudios.setIdPlan_de_estudios(rs.getInt("idPlan_de_estudios"));
	                plan_de_estudios.setNombrePlan_de_estudios(rs.getString("nombrePlan_de_estudios"));
	                plan_de_estudios.setResolucionPlan_de_estudios(rs.getString("resolucionPlan_de_estudios"));
	                
	             // Asignar Carrera si existe
		            if (rs.getInt("Carrera_idCarrera") != 0) { // Verifica si la carrera está asignada
		                Carrera carrera = new Carrera();
		                carrera.setIdCarrera(rs.getInt("Carrera_idCarrera"));
		                carrera.setNombreCarrera(rs.getString("nombreCarrera"));
		                plan_de_estudios.setIdCarrera(carrera);
		            }
	                
	                consultarPlanDeEstudios.add(plan_de_estudios);
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al consultar roles: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return consultarPlanDeEstudios;
	}
	

	@Override
	public Plan_de_estudios consultarPorId(int idPlan_de_estudios) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
