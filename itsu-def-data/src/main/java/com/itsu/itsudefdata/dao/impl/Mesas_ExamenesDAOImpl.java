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

import com.itsu.itsu_def_entities.entity.Años;
import com.itsu.itsu_def_entities.entity.Materia;
import com.itsu.itsu_def_entities.entity.Mesas_Examenes;
import com.itsu.itsu_def_entities.entity.Rol;
import com.itsu.itsu_def_entities.entity.Usuario;
import com.itsu.itsudefdata.connection.ConnectionFactory;
import com.itsu.itsudefdata.dao.Mesas_ExamenesDAO;
/**
 * 
 */
public class Mesas_ExamenesDAOImpl implements  Mesas_ExamenesDAO  {

	@Override
	public int guardar(Mesas_Examenes mesas_Examenes) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizar(Mesas_Examenes mesas_Examenes) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(int idMesaExamanes) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Mesas_Examenes> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mesas_Examenes cosultarPorId(int idMesaexamenes) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Mesas_Examenes> consultarExamenesDisponibles(int idUsuario) throws SQLException {
	    String sql = "SELECT me.*, m.nombreMateria, a.descripcionAños " +
	                 "FROM Mesas_Examenes me " +
	                 "INNER JOIN Materia m ON me.Materia_idMateria = m.idMateria " +
	                 "INNER JOIN Años a ON m.Años_idAños = a.idAños " +
	                 "INNER JOIN Usuario u ON u.Carrera_idCarrera = m.Carrera_idCarrera " +
	                 "WHERE u.idUsuario = ?";

	    List<Mesas_Examenes> mesasExamenes = new ArrayList<>();
	    try (Connection connection = ConnectionFactory.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	        preparedStatement.setInt(1, idUsuario);
	        try (ResultSet rs = preparedStatement.executeQuery()) {
	            while (rs.next()) {
	                Mesas_Examenes mesaExamen = new Mesas_Examenes();
	                mesaExamen.setIdMesaExamen(rs.getInt("idMesaExamenes"));
	                mesaExamen.setFechaMesa(rs.getString("fechaMesa"));
	                mesaExamen.setLlamadoExamen(rs.getString("llamadoExamen"));
	                mesaExamen.setPresidenteMesa(rs.getString("presidenteMesa"));
	                mesaExamen.setVocal1(rs.getString("vocal1"));
	                mesaExamen.setVocal2(rs.getString("vocal2"));

	                // Asignar información de la materia
	                Materia materia = new Materia();
	                materia.setIdMateria(rs.getInt("Materia_idMateria"));
	                materia.setNombreMateria(rs.getString("nombreMateria"));
	                mesaExamen.setMateria(materia);


	                // Asignar el año de la materia
	                Años años = new Años();
	                años.setDescripcionAños(rs.getString("descripcionAños"));
	                materia.setAños(años);

	                
	                mesasExamenes.add(mesaExamen);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e; // Lanza la excepción para que pueda ser manejada en capas superiores
	    }
	    return mesasExamenes;
	}


	    // Ejecuta SQL y retorna lista de MesasExamenes.
	
	

	
	@Override
	public boolean estaInscrito(int idUsuario, int idMesaExamenes) throws SQLException {
	    String sql = "SELECT COUNT(*) FROM Inscripcion WHERE Usuario_idUsuario = ? AND Mesas_Examenes_idMesaExamenes = ?";
	    try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
	        ps.setInt(1, idUsuario); // Asigna el ID del usuario
	        ps.setInt(2, idMesaExamenes); // Asigna el ID de la mesa de exámenes

	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt(1) > 0; // Si el conteo es mayor a 0, está inscrito
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Manejo de errores para depuración
	        throw e; // Relanzar excepción si es necesario manejarla a nivel superior
	    }
	    return false; // Si no se encontró ninguna fila, retorna false
	}

	@Override
	//REVISAR POSIBLE FALLA
	public int registrarInscripcion(int idUsuario, int idMesaExamenes) throws SQLException {
	    String sql = "INSERT INTO Inscripcion (Usuario_idUsuario, Mesas_Examenes_idMesaExamenes) VALUES (?, ?)";
	    try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
	        ps.setInt(1, idUsuario); // Usuario que se inscribe
	        ps.setInt(2, idMesaExamenes); // Mesa de examen
	        ps.executeUpdate();
	        System.out.println("Inscripción registrada con éxito.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;
	    }
		return idMesaExamenes;
	}



	

}
