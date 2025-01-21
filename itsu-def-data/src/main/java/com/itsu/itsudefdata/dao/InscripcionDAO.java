/**
 * 
 */
package com.itsu.itsudefdata.dao;

import java.sql.SQLException;
import java.util.List;

import com.itsu.itsu_def_entities.entity.Inscripcion;

/**
 * 
 */
public interface InscripcionDAO {
	
	int crearinscripion();
	
	int actualizarInscripcion();
	
	int eliminarInscripcion();
	
	
		/**
		 * metodo que permite guardar registro de inscripcion
		 * @param usuario
		 * @return 1 o mas en caso de ser exitoso, 0 en caso de no guardar 
		 * @throws SQLException 
		 */
		
		int guardar(Inscripcion inscripcion) throws SQLException;
		/**
		 * Metodo que permite actualizar registro de tipos de restaurantes.
		 * @param usuario objeto a actualizar
		 * @return 1 o mas en caso de ser exitoso, 0 en caso de no actualizarlo
		 * @throws sqlException generada en caso de error de ejecucion en la sentencia sql
		 * */
		
		int actualizar(Inscripcion inscripcion);
		
		/**
		 * Metodo que permite eliminar un usuario
		 * @param usuario identificador del tipo de restaurante.
		 * @return 1 o mas en caso de ser exitoso, 0 en caso de no eliminarlo
		 */
		int eliminar(int idInscricpion);
		/**
		 * Metodo que permite consultar los registros de usuarios
		 * @return lista de usuarios o null 
		 */
		List<Inscripcion> consultar();
		/**
		 * metodo que permite consultar un registro de tipo usuario por identificador
		 * @param idusuario identificador de usuario
		 * @return usuario consultado o null.
		 */
		Inscripcion cosultarPorId(int idInscripcion);

		int registrarInscripcion(int idUsuario, int idMesaExamenes) throws SQLException;

	}



