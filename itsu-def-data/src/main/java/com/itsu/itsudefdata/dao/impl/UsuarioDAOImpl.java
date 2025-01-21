	/**
 * 
 */
package com.itsu.itsudefdata.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itsu.itsu_def_entities.entity.Carrera;
import com.itsu.itsu_def_entities.entity.Rol;
import com.itsu.itsu_def_entities.entity.Usuario;
import com.itsu.itsudefdata.connection.ConnectionFactory;
import com.itsu.itsudefdata.dao.UsuarioDAO;



/**DAOimpl ES LA IMPLEMENTACION CONCRETA DE LA INTERFAZ usuarioDAO define COMO SE REALIZAN LAS OPERACIONES DE ACCESO A LA BD
 * WEB SE COMUNICA CON SERVICE / data / ENTITIES
 * CLASE QUE IMPLEMENTA EL CRUD Y OTROS METODOS PERSONALIZADOS DE TRANSACCIONES A LA BD EN LA TABLA USUARIO 
  */
public class UsuarioDAOImpl implements UsuarioDAO {


	@Override //SOBREESCRIBE EL METODO DE LA INTERFAZ
	/**RECIBE UN OBJETO USUARIO COMO PARAMETRO*/
	public int guardar(Usuario usuario) throws SQLException {
		String sql = "INSERT INTO bdd190924.usuario (nombreUsuario, apellidoUsuario, contraseñaUsuario, telefonoUsuario,"
				+ "emailUsuario, dniUsuario, direccionUsuario, paisUsuario, fechaNacimientoUsuario ,"
				+ " Rol_idRol, Carrera_idCarrera) " + "VALUES ('" + usuario.getNombreUsuario() + "','"
				+ usuario.getApellidoUsuario() + "','" + usuario.getContraseñaUsuario() + "','"
				+ usuario.getTelefonoUsuario() + "','" + usuario.getEmailUsuario() + "','" + usuario.getDniUsuario()
				+ "','" + usuario.getDireccionUsuario() + "','" + usuario.getPaisUsuario() + "','"
				+ usuario.getFechaNacimientoUsuario() + "'," + usuario.getRol().getIdRol() + ","
				+ usuario.getIdCarrera().getIdCarrera() + ");";

		int ejecutado = ConnectionFactory.ejecutarSQL(sql); //DEVUELVE 0 SI FALLO O 1 SI FUE EXITOSA
		return ejecutado;
	}

	/**ACTUALIZA LOS DATOS DEL ALUMNO*/
	@Override
	public int actualizar(Usuario usuario) throws SQLException {
		String sql = "UPDATE usuario SET nombreUsuario = '" + usuario.getNombreUsuario() 
				+ "', apellidoUsuario = '" + usuario.getApellidoUsuario() 
				+ "', contraseñaUsuario = '" + usuario.getContraseñaUsuario()
				+ "', telefonoUsuario = '" + usuario.getTelefonoUsuario() 
				+ "', emailUsuario = '"	+ usuario.getEmailUsuario() 
				+ "', dniUsuario = '" + usuario.getDniUsuario() 
				+ "', direccionUsuario = '" + usuario.getDireccionUsuario() 
				+ "', paisUsuario = '" + usuario.getPaisUsuario()
				+ "', fechaNacimientoUsuario = '" + usuario.getFechaNacimientoUsuario() 
				+ "', Rol_idRol = " + usuario.getRol().getIdRol()
				+ ", Carrera_idCarrera = " + usuario.getIdCarrera().getIdCarrera()
				+ " WHERE idUsuario = " + usuario.getIdUsuario(); // 

		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		return ejecutado;

	}
	
	/**ELIMINA AL ALUMNO SELECCIONADO*/
	@Override
	public int eliminar(int idusuario) throws SQLException {
		String sql = "DELETE FROM usuario WHERE idUsuario  = " + idusuario + ";";

		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		return ejecutado;
	}

	/**CONSULTA ALUMNOS 
	 * @throws SQLException
	 * 
	 */
	@Override
	public List<Usuario> consultar() throws SQLException {
		String sql = "SELECT u.*, r.nombreRol, c.nombreCarrera "
		           + "FROM Usuario u, rol r, carrera c "
		           + "WHERE u.Carrera_idCarrera = c.idCarrera "
		           + "AND u.Rol_idRol = r.idRol "
		           + "ORDER BY u.apellidoUsuario;";

	    ResultSet rs = ConnectionFactory.ejecutarSQLSelect(sql); //RESULSET PROCESA LOS DATOS QUE DEVUELVE LA CONSULTA

	    List<Usuario> usuarios = new ArrayList<>();

	    if (rs != null) {
	        while (rs.next()) {
	            Usuario usuario = new Usuario();
	            usuario.setIdUsuario(rs.getInt("IdUsuario"));
	            usuario.setNombreUsuario(rs.getString("NombreUsuario"));
	            usuario.setApellidoUsuario(rs.getString("ApellidoUsuario"));
	            usuario.setContraseñaUsuario(rs.getString("ContraseñaUsuario"));
	            usuario.setTelefonoUsuario(rs.getString("TelefonoUsuario"));
	            usuario.setEmailUsuario(rs.getString("EmailUsuario"));
	            usuario.setDniUsuario(rs.getString("DniUsuario"));
	            usuario.setDireccionUsuario(rs.getString("DireccionUsuario"));
	            usuario.setPaisUsuario(rs.getString("PaisUsuario"));
	            usuario.setFechaNacimientoUsuario(rs.getString("FechaNacimientoUsuario"));

	            // ASIGANR ROL SI EXISTE
	            if (rs.getInt("Rol_idRol") != 0) { // VERIFICA SI EL ROL ESTA ASIGNADO
	                Rol rol = new Rol();
	                rol.setIdRol(rs.getInt("Rol_idRol"));
	                rol.setNombreRol(rs.getString("nombreRol"));
	                usuario.setRol(rol);
	            }

	            // ASIGNAR CARRERA SI EXISTE
	            if (rs.getInt("Carrera_idCarrera") != 0) { // VERIFICA SI LA CARRERA ESTA ASIGNADA
	                Carrera carrera = new Carrera();
	                carrera.setIdCarrera(rs.getInt("Carrera_idCarrera"));
	                carrera.setNombreCarrera(rs.getString("nombreCarrera"));
	                usuario.setIdCarrera(carrera);
	            }

	            usuarios.add(usuario);
	        }
	    }
	    return usuarios;
	}

	/**CONSULTA POR ID*/
	@Override
	public Usuario consultarPorId(int idUsuario) throws SQLException {

		String sql = "SELECT u.*, r.nombreRol, c.nombreCarrera "
		           + "FROM Usuario u, rol r, carrera c "
		           + "WHERE u.Carrera_idCarrera = c.idCarrera "
		           + "AND u.Rol_idRol = r.idRol "
		           + "AND u.idUsuario = " + idUsuario + "  " 
		           + "ORDER BY u.apellidoUsuario";
		ResultSet rs = ConnectionFactory.ejecutarSQLSelect(sql);

		Usuario usuario = null;

		if (rs != null) {
			if (rs.next()) {

				usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("IdUsuario"));
				usuario.setNombreUsuario(rs.getString("NombreUsuario"));
				usuario.setApellidoUsuario(rs.getString("ApellidoUsuario"));
				usuario.setContraseñaUsuario(rs.getString("ContraseñaUsuario"));
				usuario.setTelefonoUsuario(rs.getString("TelefonoUsuario"));
				usuario.setEmailUsuario(rs.getString("EmailUsuario"));
				usuario.setDniUsuario(rs.getString("DniUSuario"));
				usuario.setDireccionUsuario(rs.getString("DireccionUsuario"));
				usuario.setPaisUsuario(rs.getString("PaisUsuario"));
				usuario.setFechaNacimientoUsuario(rs.getString("FechaNacimientoUsuario"));
				
				 // OBTENER ROL
		        Rol rol = new Rol();
		        rol.setIdRol(rs.getInt("Rol_idRol"));
		        rol.setNombreRol(rs.getString("nombreRol")); // ACA SACO EL ROL (ADMIN O ALUMNO)
		        usuario.setRol(rol);// ASIGNAR ROL AL USUARIO
		        // OBTENER CARRERA DEL ALUMNO
		        Carrera carrera = new Carrera ();
		        carrera.setIdCarrera(rs.getInt("Carrera_idCarrera"));
		        carrera.setNombreCarrera(rs.getString("nombreCarrera")); // AQUI OBTENGO LA CARRERA
			}

		}
		return usuario;
	}	

	/**CONSULTA PARA EL LOGIN*/
	public Usuario consultarPorNombreYDni(String dniUsuario, String contraseñaUsuario, String nombreRol) throws SQLException {
	    Usuario usuario = null;

	    String sql = "SELECT u.*, r.nombreRol AS nombreRol " +
	                 "FROM usuario u " +
	                 "JOIN rol r ON u.Rol_idRol = r.idRol " +
	                 "WHERE (u.dniUsuario = ? OR u.nombreUsuario = ?) " +
	                 "AND u.contraseñaUsuario = ?";

	    // USO PreparedStatement PARA EVITAR INYECCION SQL AUNQUE no LO ENTIENDO BIEN
	    PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
	    stmt.setString(1, dniUsuario);
	    stmt.setString(2, dniUsuario);
	    stmt.setString(3, contraseñaUsuario);

	    ResultSet rs = stmt.executeQuery();

	    if (rs.next()) {
	        // CREA EL OBJETO USUARIO
	        usuario = new Usuario();
	        usuario.setIdUsuario(rs.getInt("IdUsuario"));
	        usuario.setNombreUsuario(rs.getString("NombreUsuario"));
	        usuario.setApellidoUsuario(rs.getString("ApellidoUsuario"));
	        usuario.setContraseñaUsuario(rs.getString("ContraseñaUsuario"));
	        usuario.setTelefonoUsuario(rs.getString("TelefonoUsuario"));
	        usuario.setEmailUsuario(rs.getString("EmailUsuario"));
	        usuario.setDniUsuario(rs.getString("DniUsuario"));
	        usuario.setDireccionUsuario(rs.getString("DireccionUsuario"));
	        usuario.setPaisUsuario(rs.getString("PaisUsuario"));
	        usuario.setFechaNacimientoUsuario(rs.getString("FechaNacimientoUsuario"));

	     // OBTENER ROL
	        Rol rol = new Rol();
	        rol.setIdRol(rs.getInt("Rol_idRol"));
	        rol.setNombreRol(rs.getString("nombreRol")); // ACA SACO EL ROL (ADMIN O ALUMNO)

	        usuario.setRol(rol);
	    }

	    return usuario;
	}
	
//	METODO QUE CONSULTA ALUMNO POR AÑO Y POR MATERIA PARA LA PARTE DE CREAR UNA PANTALLA
	//DONDE CARGO LOS ALUMNOS A UNA MATERIA TODAVIA NO ESTA LISTO NI SE SI LA VOY A USAR
	
	public List<Usuario> consultarUsuarioPorAñoYCarrera(Integer idAños, Integer idCarrera) throws SQLException {
	    List<Usuario> usuarios = new ArrayList<Usuario>();
	    String sql = "SELECT u.*,r.nombreRol" +
	                 "FROM usuario u " +
	                 "JOIN rol r ON U.idRol = r.idRol " +
	                 "JOIN carrera c ON u.Carrera_idCarrera = c.idCarrera " +
	                 "JOIN materia m ON c.idCarrera = m.Carrera_idCarrera " +
	                 "JOIN años a ON m.Años_idAños = a.idAños " +
	                 "WHERE a.idAños = ? " +  // FILTRAR POR AÑO
	                 "WHERE r.idRol = ? " +
	                 "AND c.idCarrera = ?";  // FILTRAR POR CARRERA

	    try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
	        ps.setInt(1, idAños);  // ASIGNAR EL VALOR DE IDAÑOS AL PRIMER PARAMETRO
	        ps.setInt(2, idCarrera);  // ASIGNAR el valor DE idMateria AL SEGUNDO PARAMETRO

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                Usuario usuario = new Usuario();
	                usuario.setIdUsuario(rs.getInt("idUsuario"));
	                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
	                usuario.setApellidoUsuario(rs.getString("apellidoUsuario"));
	                usuario.setContraseñaUsuario(rs.getString("contraseñaUsuario"));
	                usuario.setTelefonoUsuario(rs.getString("telefonoUsuario"));
	                usuario.setEmailUsuario(rs.getString("emailUsuario"));
	                usuario.setDniUsuario(rs.getString("dniUsuario"));
	                usuario.setDireccionUsuario(rs.getString("direccionUsuario"));
	                usuario.setPaisUsuario(rs.getString("paisUsuario"));
	                usuario.setFechaNacimientoUsuario(rs.getString("fechaNacimientoUsuario"));
	                
	                Rol rol = new Rol();
	                rol.setIdRol(rs.getInt("idRol"));
	                rol.setNombreRol(rs.getString("nombreRol"));
	                
	                Carrera carrera = new Carrera();
	                carrera.setIdCarrera(rs.getInt("idCarrera"));
	                carrera.setNombreCarrera(rs.getNString("nombreCarrera"));

	                // AÑADIR USUARIO A LA LISTA
	                usuarios.add(usuario);
	            }
	        }
	    }

	    return usuarios;
	}

}