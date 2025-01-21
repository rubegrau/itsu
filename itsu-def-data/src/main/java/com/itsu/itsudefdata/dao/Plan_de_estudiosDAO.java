/**
 * 
 */
package com.itsu.itsudefdata.dao;

import java.sql.SQLException;
import java.util.List;

import com.itsu.itsu_def_entities.entity.Plan_de_estudios;

/**
 * 
 */
public interface Plan_de_estudiosDAO {
	int guardar(Plan_de_estudios planDeEstudio) throws SQLException;
	/**
	 * Metodo que permite actualizar registro de tipos de restaurantes.
	 * @param usuario objeto a actualizar
	 * @return 1 o mas en caso de ser exitoso, 0 en caso de no actualizarlo
	 * @throws sqlException generada en caso de error de ejecucion en la sentencia sql
	 * */
	
	int actualizar(Plan_de_estudios planDeEstudio);
	
	/**
	 * Metodo que permite eliminar un usuario
	 * @param usuario identificador del tipo de restaurante.
	 * @return 1 o mas en caso de ser exitoso, 0 en caso de no eliminarlo
	 */
	int eliminar(int idPlan_de_estudios);
	/**
	 * Metodo que permite consultar los registros de usuarios
	 * @return lista de usuarios o null 
	 */
	List<Plan_de_estudios> consultar();
	/**
	 * metodo que permite consultar un registro de tipo usuario por identificador
	 * @param idusuario identificador de usuario
	 * @return usuario consultado o null.
	 */
	Plan_de_estudios consultarPorId(int idPlan_de_estudios);

}
