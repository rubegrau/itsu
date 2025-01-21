/**
 * 
 */
package com.itsu.itsudefsservice.services;

import java.sql.SQLException;
import java.util.List;

import com.itsu.itsu_def_entities.entity.Carrera;
import com.itsu.itsu_def_entities.entity.Inscripcion;
import com.itsu.itsu_def_entities.entity.Materia;
import com.itsu.itsu_def_entities.entity.Mesas_Examenes;
import com.itsu.itsu_def_entities.entity.Plan_de_estudios;
import com.itsu.itsu_def_entities.entity.Rol;
import com.itsu.itsu_def_entities.entity.Usuario;
import com.itsu.itsudefdata.dao.impl.CarreraDAOImpl;
import com.itsu.itsudefdata.dao.impl.InscripcionDAOImpl;
import com.itsu.itsudefdata.dao.impl.MateriaDAOimpl;
import com.itsu.itsudefdata.dao.impl.Mesas_ExamenesDAOImpl;
import com.itsu.itsudefdata.dao.impl.Plan_de_estudiosDAOImpl;
import com.itsu.itsudefdata.dao.impl.RolDAOImpl;
import com.itsu.itsudefdata.dao.impl.UsuarioDAOImpl;

/**              WEB SE COMUNICA SERVICES / DATA / ENTITIES 
 * MODELO : CLASE QUE SE ENCARGA DE REALIZAR LA LOGICA DE NEGOCIO PARA ADMINISTRAR USUARIOS CARRERAS MATERIAS Y EXAMENES
 * MODELO: REPRESENTA LA ESTRUCTURA DE DATOS Y REGLAS DE NEGOCIO, MANEJA LA LOGICA DE LA APLICACION, BD
 */

public class AdminGeneralService {
	private UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
//	OBJETO QUE PERMITE CAMBIOS EN LA TABLA ROLES 
	private RolDAOImpl rolDAOImpl = new RolDAOImpl();
	private CarreraDAOImpl carreraDAOImpl = new CarreraDAOImpl();
	private RolDAOImpl rolDAO = new RolDAOImpl(); 
	private CarreraDAOImpl carreraDAO = new CarreraDAOImpl();
	private MateriaDAOimpl materiaDAOimpl = new MateriaDAOimpl();
	private Plan_de_estudiosDAOImpl plan_de_estudiosDAOImpl = new Plan_de_estudiosDAOImpl();
	private Mesas_ExamenesDAOImpl mesas_examenesDAOImpl = new Mesas_ExamenesDAOImpl();	
	private InscripcionDAOImpl inscripcionDAOImpl = new InscripcionDAOImpl();
	
	
						//	USUARIOS
//	METODO QUE PERMITE CARGAR UN ALUMNO NUEVO
	public int guardarNuevoUsuario(Usuario usuario) throws SQLException {
//		 String nombreRolSeleccionado = usuario.getRol().getNombreRol(); // O la forma en que obtengas el rol seleccionado OJO ESTO SE PUEDE SACAR
//
//		    // Busca el rol correspondiente usando el nombre
//		    Rol rol = obtenerRolPorNombre(nombreRolSeleccionado);
//		    usuario.setRol(rol); // Ahora se asigna un objeto Rol, no un String HASTA ACA SE PUEDE SACAR
		return this.usuarioDAOImpl.guardar(usuario);
	}
	
//	METODO QUE PERMITE ACTUALIZAR USUARIO
	public int actualizarUsuario(Usuario usuario) throws SQLException {
		return this.usuarioDAOImpl.actualizar(usuario);
	}
	
	//	metodod que permite eliminar usuarios
	public int eliminarUsuario(int idUsuario) throws SQLException {
		return this.usuarioDAOImpl.eliminar(idUsuario);
	}
	
	// METODO QUE PERMITE CONSULTAR LA LISTA DE USUARIOS
	public List<Usuario> consultarUsuarios() throws SQLException{
		return this.usuarioDAOImpl.consultar();
	}
	
	//METODO QUE PERMITE CONSULTAR USUARIO POR SU ID
	public Usuario consultarUsuarioPorId(int idUsuario) throws SQLException {
		return usuarioDAOImpl.consultarPorId(idUsuario);
	}
		
	
					//	CARRERAS
	
	public List<Carrera> consultarCarreras() throws SQLException{
		return this.carreraDAOImpl.consultar();
	}
	  
	
//	METODO QUE PERMITE CARGAR UNA CARRERA NUEVA
	public int guardarCarrera(Carrera carrera) throws SQLException {
        return this.carreraDAOImpl.guardar(carrera);
    }
    
//	METODO QUE PERMITE ACTUALIZAR UNA CARRERA 
	public int actualizarCarrera(Carrera carrera) throws SQLException {
		return this.carreraDAOImpl.actualizar(carrera);
	}
	
//	METODO QUE PERMITE ELIMINAR UNA CARRERA
	public int eliminarCarrera(int idCarrera) throws SQLException {
		return this.carreraDAOImpl.eliminar(idCarrera);
	}
	
//	METODO QUE PERMITE BUSCAR UNA CARRERA POR ID
	public Carrera obtenerCarreraPorId(int idCarrera) throws SQLException {
		return carreraDAOImpl.consultarPorId(idCarrera);
	}
	
//	METODO QUE PERMITE BUSCAR UNA CARRERA PARA DESPLEGAR EN USUARIO
	public Carrera obtenerCarreraPorNombre(String nombreCarreraSeleccionada) throws SQLException {
		return carreraDAO.obtenerCarreraPorNombre(nombreCarreraSeleccionada);
	}
				
						//	ROLES	
	// LLAMA AL METODO DEL DAO PARA OBTENER EL ROL DE LA BD Y DESPLEGAR EN USUARIO
	public Rol obtenerRolPorNombre(String nombreRolSeleccionado) throws SQLException {
        return rolDAO.obtenerRolPorNombre(nombreRolSeleccionado);
    }
	
	public List<Rol> consultarRol() throws SQLException {
		return this.rolDAOImpl.consultarRol();
	}
	
//	               MATERIAS

	public List<Materia> consultarMateria() throws SQLException {
		return this.materiaDAOimpl.consultar();
	}
	
	public int guardarMateria(Materia materia) throws SQLException {
		return this.materiaDAOimpl.guardar(materia);
	}

	public int eliminarMateria(int idMateria) throws SQLException {
		return this.materiaDAOimpl.eliminar(idMateria);
		
	}
	
	
//	  				PLAN DE ESTUDIOS RESOLUCION
	
	public List<Plan_de_estudios> consultarPlanDeEstudios(){
		return this.plan_de_estudiosDAOImpl.consultar();
	}

	public int guardarResolucion(Plan_de_estudios plan_de_estudios) throws SQLException {
		return this.plan_de_estudiosDAOImpl.guardar(plan_de_estudios);
	}
	
	//          EXAMENES

	public List<Mesas_Examenes> consultarExamenesDisponibles(int idUsuario) throws SQLException {
	    System.out.println("Consultando exámenes para el usuario ID: " + idUsuario); // Depuración
	    return this.mesas_examenesDAOImpl.consultarExamenesDisponibles(idUsuario);
	}


	public boolean estaInscrito(int idUsuario, int idMesaExamenes) throws SQLException {
		return this.mesas_examenesDAOImpl.estaInscrito(idUsuario, idMesaExamenes);
	}

	public int registrarInscripcion(int idUsuario, int idMesaExamenes) throws SQLException {
	   
	    return inscripcionDAOImpl.registrarInscripcion(idUsuario, idMesaExamenes);
	}
	public boolean verificarInscripcion(int idUsuario, int idMesaExamenes) throws SQLException {
	    return mesas_examenesDAOImpl.estaInscrito(idUsuario, idMesaExamenes);
	}

	public List<Inscripcion> consultarInscripcionesPendientes() throws SQLException {
	    return inscripcionDAOImpl.consultarInscripcionesPendientes();
	}
	public void cambiarEstadoInscripcion(int idInscripcion, String estado) throws SQLException {
	    inscripcionDAOImpl.cambiarEstadoInscripcion(idInscripcion, estado);
	}
	

	
	
	}
	

