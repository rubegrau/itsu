/**
 * 
 */
package com.itsu.itsudefdata.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itsu.itsu_def_entities.entity.Materia;
import com.itsu.itsudefdata.connection.ConnectionFactory;
import com.itsu.itsudefdata.dao.MateriaDAO;

/**
 * 
 */
public class MateriaDAOimpl implements MateriaDAO {

	@Override
	// AGREGADO DESDE ACA -->
	public int guardar(Materia materia) throws SQLException {
		String sql = "INSERT INTO Materia (nombreMateria, tipoMateria, Carrera_idCarrera, Años_idAños) " +
                "VALUES (?, ?, ?, ?)";
   try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
       ps.setString(1, materia.getNombreMateria());
       ps.setString(2, materia.getTipoMateria());
       ps.setInt(3, materia.getCarrera().getIdCarrera());
       ps.setInt(4, materia.getAños().getIdAños());
       return ps.executeUpdate();
   }
	}

	@Override
	public int actualizar(Materia materia) throws SQLException {
	    if (materia == null || materia.getCarrera() == null || materia.getAños() == null) {
	        throw new IllegalArgumentException("Datos de materia incompletos");
	    }

	    String sql = "UPDATE Materia SET nombreMateria = ?, tipoMateria = ?, Carrera_idCarrera = ?, Años_idAños = ? " +
	                 "WHERE idMateria = ?";

	    try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
	        ps.setString(1, materia.getNombreMateria());
	        ps.setString(2, materia.getTipoMateria());
	        ps.setInt(3, materia.getCarrera().getIdCarrera());
	        ps.setInt(4, materia.getAños().getIdAños());
	        ps.setInt(5, materia.getIdMateria());
	        return ps.executeUpdate();
	    } catch (SQLException e) {
	        throw new SQLException("Error al actualizar la materia: " + e.getMessage(), e);
	    }
	}


	
	@Override
	public int eliminar(int idMateria) throws SQLException {
	    String sql = "DELETE FROM Materia WHERE idMateria = ?"; // Elimina el registro directamente
	    try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
	        ps.setInt(1, idMateria); // Establece el ID de la materia que se desea eliminar
	        return ps.executeUpdate(); // Devuelve el número de filas afectadas
	    }
	}


	
	
	@Override
	public List<Materia> consultar() throws SQLException {
		 String sql = "SELECT * FROM Materia";
	        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {
	            List<Materia> materias = new ArrayList<>();
	            while (rs.next()) {
	                Materia materia = new Materia();
	                materia.setIdMateria(rs.getInt("idMateria"));
	                materia.setNombreMateria(rs.getString("nombreMateria"));
	                materia.setTipoMateria(rs.getString("tipoMateria"));
	                // Cargar relaciones Carrera y Años si es necesario
	                materias.add(materia);
	            }
	            return materias;
	        }
	}


	@Override
	public Materia cosultarPorId(int idMateria) throws SQLException {
		String sql = "SELECT * FROM Materia WHERE idMateria = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setInt(1, idMateria);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Materia materia = new Materia();
                    materia.setIdMateria(rs.getInt("idMateria"));
                    materia.setNombreMateria(rs.getString("nombreMateria"));
                    materia.setTipoMateria(rs.getString("tipoMateria"));
                    // Cargar relaciones Carrera y Años si es necesario
                    return materia;
                }
            }
        }
        return null;
    }
	//AGREGADO HASTA ACA -->
}
