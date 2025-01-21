/**
 * 
 */
package com.itsu.itsudefsservice.services;

import java.sql.SQLException;

import com.itsu.itsu_def_entities.entity.Usuario;
import com.itsu.itsudefdata.dao.impl.UsuarioDAOImpl;

/**clase que realiza la logica de negocio para la pantalla login
 * 
 */
public class LoginService {
	
	private UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
	public Usuario consultarPorNombreYDni(String dniUsuario, String contraseñaUsuario, String nombreRol) throws SQLException {
		return this.usuarioDAOImpl.consultarPorNombreYDni(dniUsuario, contraseñaUsuario, nombreRol);
		
		
		
	}

}
