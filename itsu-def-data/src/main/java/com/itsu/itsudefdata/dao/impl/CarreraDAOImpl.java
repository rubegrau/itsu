/**
 * 
 */
package com.itsu.itsudefdata.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itsu.itsu_def_entities.entity.Carrera;
import com.itsu.itsu_def_entities.entity.Plan_de_estudios;
import com.itsu.itsudefdata.connection.ConnectionFactory;
import com.itsu.itsudefdata.dao.CarreraDAO;



/**
 * 
 */
public class CarreraDAOImpl implements CarreraDAO{

	@Override
	public Integer guardar(Carrera carrera) throws SQLException {
	    // Armar la consulta SQL correctamente con comillas cerrando el valor
	    String sql = "INSERT INTO bdd190924.carrera (nombreCarrera) VALUES ('" + carrera.getNombreCarrera() + "');";

	    int ejecutado = ConnectionFactory.ejecutarSQL(sql);
	    return ejecutado;
	}

		
	

	@Override
	public Integer actualizar(Carrera carrera) throws SQLException {
	    // Construcción correcta de la consulta SQL con comillas de cierre
	    String sql = "UPDATE carrera SET nombreCarrera = '" + carrera.getNombreCarrera() +
	                 "' WHERE idCarrera = " + carrera.getIdCarrera(); // Condición WHERE

	    int ejecutado = ConnectionFactory.ejecutarSQL(sql);
	    return ejecutado;
	}


	@Override
	public Integer eliminar(int idCarrera) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM carrera WHERE idCarrera  = " + idCarrera + ";";

		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		return ejecutado;
	}

	
	@Override
	public List<Carrera> consultar() throws SQLException {
		String sql = "SELECT c.idCarrera, " +
	             "       c.nombreCarrera, " +
	             "       p.idPlan_de_estudios, " +
	             "       p.nombrePlan_de_estudios, " +
	             "       p.resolucionPlan_de_estudios " +
	             "FROM Carrera c " +
	             "LEFT JOIN Plan_de_estudios p " +
	             "ON c.idCarrera = p.Carrera_idCarrera " +
	             "ORDER BY c.nombreCarrera;";


	    List<Carrera> carreras = new ArrayList<>();

	    try (ResultSet rs = ConnectionFactory.ejecutarSQLSelect(sql)) {
	        while (rs != null && rs.next()) {
	            Carrera carrera = new Carrera();
	            carrera.setIdCarrera(rs.getInt("idCarrera"));
	            carrera.setNombreCarrera(rs.getString("nombreCarrera"));

	            // Asociar el plan de estudios si está presente
	            int idPlan = rs.getInt("idPlan_de_estudios");
	            if (!rs.wasNull()) { // Verifica si hay un plan asociado
	                Plan_de_estudios plan = new Plan_de_estudios();
	                plan.setIdPlan_de_estudios(idPlan);
	                plan.setNombrePlan_de_estudios(rs.getString("nombrePlan_de_estudios"));
	                plan.setResolucionPlan_de_estudios(rs.getString("resolucionPlan_de_estudios"));
	                carrera.setPlanDeEstudios(plan); // Asocia el plan a la carrera
	            }

	            carreras.add(carrera);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new SQLException("Error al consultar las carreras", e); // Agrega contexto a la excepción
	    }

	    return carreras;
	}


	@Override
	public Carrera consultarPorId(int idCarrera) throws SQLException {
		String sql = "SELECT * FROM Carrera WHERE idCarrera = " + idCarrera + ";";

		ResultSet rs = ConnectionFactory.ejecutarSQLSelect(sql);

		Carrera carrera = null;

		if (rs != null) {
			if (rs.next()) {

				carrera = new Carrera();
				carrera.setIdCarrera(rs.getInt("idCarrera"));
				carrera.setNombreCarrera(rs.getString("nombreCarrera"));
				
			}

		}
		return carrera;
	}
	
	public Carrera obtenerCarreraPorNombre(String nombreCarrera) throws SQLException {
        Carrera carrera = null;
        String sql = "SELECT * FROM Carrera WHERE nombreCarrera = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombreCarrera);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    carrera = new Carrera();
                    carrera.setIdCarrera(rs.getInt("idCarrera"));
                    carrera.setNombreCarrera(rs.getString("nombreCarrera"));
                }

}
}return carrera;
        }}