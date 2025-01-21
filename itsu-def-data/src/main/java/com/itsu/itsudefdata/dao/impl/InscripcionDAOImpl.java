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

import com.itsu.itsu_def_entities.entity.Inscripcion;
import com.itsu.itsu_def_entities.entity.Materia;
import com.itsu.itsu_def_entities.entity.Mesas_Examenes;
import com.itsu.itsu_def_entities.entity.Usuario;
import com.itsu.itsudefdata.connection.ConnectionFactory;
import com.itsu.itsudefdata.dao.InscripcionDAO;

/**
 * 
 */
public class InscripcionDAOImpl implements InscripcionDAO {

	@Override
	public int crearinscripion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarInscripcion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarInscripcion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int guardar(Inscripcion inscripcion) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizar(Inscripcion inscripcion) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(int idInscricpion) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Inscripcion> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inscripcion cosultarPorId(int idInscripcion) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int registrarInscripcion(int idUsuario, int idMesaExamenes) throws SQLException {
	    String sql = "INSERT INTO Inscripcion (Usuario_idUsuario, Mesas_Examenes_idMesaExamenes, estadoInscripcion, fechaInscripcion) " +
	                 "VALUES (?, ?, 'pendiente', ?)";
	    try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
	        ps.setInt(1, idUsuario); // Asigna el ID del usuario que se inscribe
	        ps.setInt(2, idMesaExamenes); // Asigna el ID de la mesa de exámenes
	        ps.setDate(3, new java.sql.Date(System.currentTimeMillis())); // Establece la fecha actual
	        return ps.executeUpdate(); // Ejecuta la consulta y devuelve el número de filas afectadas
	    } catch (SQLException e) {
	        e.printStackTrace(); // Manejo de excepciones
	        throw e; // Lanza la excepción para que sea manejada en un nivel superior
	    }
	}
	public List<Inscripcion> consultarInscripcionesPendientes() throws SQLException {
	    String sql = "SELECT i.*, u.nombreUsuario, me.fechaMesa, m.nombreMateria " +
	                 "FROM Inscripcion i " +
	                 "INNER JOIN Usuario u ON i.Usuario_idUsuario = u.idUsuario " +
	                 "INNER JOIN Mesas_Examenes me ON i.Mesas_Examenes_idMesaExamenes = me.idMesaExamenes " +
	                 "INNER JOIN Materia m ON me.Materia_idMateria = m.idMateria " +
	                 "	WHERE i.estadoInscripcion = 'pendiente'";
	    
	    List<Inscripcion> inscripcionesPendientes = new ArrayList<>();
	    try (Connection connection = ConnectionFactory.getConnection();
	         PreparedStatement ps = connection.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {
	        
	        while (rs.next()) {
	            Inscripcion inscripcion = new Inscripcion();
	            inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
	            inscripcion.setFechaInscripcion(rs.getDate("fechaInscripcion"));
	            inscripcion.setEstadoInscripcion(rs.getString("estadoInscripcion"));

	            // Información adicional
	            Usuario usuario = new Usuario();
	            usuario.setNombreUsuario(rs.getString("nombreUsuario"));
	            inscripcion.setUsuario(usuario);

	            Mesas_Examenes mesaExamen = new Mesas_Examenes();
	            mesaExamen.setFechaMesa(rs.getString("fechaMesa"));
	            Materia materia = new Materia();
	            materia.setNombreMateria(rs.getString("nombreMateria"));
	            mesaExamen.setMateria(materia);
	            inscripcion.setMesaExamen(mesaExamen);

	            inscripcionesPendientes.add(inscripcion);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;
	    }
	    return inscripcionesPendientes;
	}
	public void cambiarEstadoInscripcion(int idInscripcion, String estado) throws SQLException {
	    String sql = "UPDATE Inscripcion SET estadoInscripcion = ? WHERE idInscripcion = ?";
	    try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
	        ps.setString(1, estado);
	        ps.setInt(2, idInscripcion);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;
	    }
	}

}
