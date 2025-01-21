/**
 * 
 */
package com.itsu.itsudefdata.dao.impl.test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import com.itsu.itsudefdata.dao.impl.UsuarioDAOImpl;
import com.itsu.itsu_def_entities.entity.Usuario;
import com.itsu.itsu_def_entities.entity.Rol;
import com.itsu.itsu_def_entities.entity.Carrera;

/**
 * 
 */
class UsuarioDAOImplTest {

	@Test
	void test() {
		System.out.println("primer test JUNIT");
	}
	
	@Test
	void testGuardarExitoso() {
		UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
		Usuario usuario = new Usuario();
		usuario.setNombreUsuario("Andres");
		usuario.setApellidoUsuario("Korell");
		usuario.setContraseñaUsuario("123");
		usuario.setTelefonoUsuario("3446");
		usuario.setEmailUsuario("a@g");
		usuario.setApellidoUsuario("2370");
		usuario.setDireccionUsuario("Churru 123");
		usuario.setPaisUsuario("arg");
		usuario.setFechaNacimientoUsuario("01/01/");
		
		Rol rol = new Rol();
		rol.setIdRol(1);
		Carrera carrera = new Carrera();
		carrera.setIdCarrera(1);
		
		usuario.setRol(rol);
		usuario.setIdCarrera(carrera);
		int guardado = 0;
		
		try {
			//primer caso si fue exitoso si es mayor a 0
			guardado = usuarioDAOImpl.guardar(usuario);
			
			assertTrue(guardado>0);
			
			System.out.println("Prueba exitosa. Se guardo correctamente, se ve que usted es crack programando");
		} catch (SQLException e) {
					
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testGuardarFallido() {
		UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
		Usuario usuario = new Usuario();
		usuario.setNombreUsuario("Andres");
		usuario.setApellidoUsuario("Korell");
		usuario.setContraseñaUsuario("123");
		usuario.setTelefonoUsuario("3446");
		usuario.setEmailUsuario("a@g");
		usuario.setApellidoUsuario("2370");
		usuario.setDireccionUsuario("Churru 123");
		usuario.setPaisUsuario("arg");
		usuario.setFechaNacimientoUsuario("01/01/");
		
		Rol rol = new Rol();
		rol.setIdRol(1);
		Carrera carrera = new Carrera();
		carrera.setIdCarrera(1);
		
		usuario.setRol(rol);
		usuario.setIdCarrera(carrera);
		int guardado = 0;
		
		try {
			
			guardado = usuarioDAOImpl.guardar(usuario);
			
			
		} catch (SQLException e) {
			//segundo caso de error IGUAL NO VERIFICA SI EXISTE EL USUARIO LO GUARDA IGUAL
			assertTrue(guardado ==0);
			System.err.println("Prueba fallida. Anda y segui probando con ChatGPT nomas");
			
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testActualizarExitoso(){
		UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
		Usuario usuario = new Usuario();
		
		usuario.setIdUsuario(4);
		usuario.setNombreUsuario("Ursula");
		usuario.setApellidoUsuario("Huck");
		usuario.setContraseñaUsuario("123");
		usuario.setTelefonoUsuario("3333");
		usuario.setDniUsuario("1111");
		usuario.setEmailUsuario("u@h");
		usuario.setDireccionUsuario("Libertad 123");
		usuario.setPaisUsuario("arg");
		usuario.setFechaNacimientoUsuario("01/01/30");
		
		Rol rol = new Rol();
		rol.setIdRol(1);
		
		
		Carrera carrera = new Carrera();
		carrera.setIdCarrera(1);
		
		usuario.setRol(rol);
		usuario.setIdCarrera(carrera);
		assertTrue(usuario.getRol().getIdRol()==1);
		
		assertTrue(usuario.getIdCarrera().getIdCarrera()==1);
		int actualizado = 0;
		
		try {
			//primer caso si fue exitoso si es mayor a 0
			actualizado = usuarioDAOImpl.actualizar(usuario);
			
			assertTrue(actualizado>0);
			
			System.out.println("Prueba exitosa. Se actualizo correctamente, esto me confirma que usted es crack programando");
		} catch (SQLException e) {
			//segundo caso de error IGUAL NO VERIFICA SI EXISTE EL USUARIO LO GUARDA IGUAL
			assertTrue(actualizado ==0);
			System.err.println("Actualizacion fallida. Anda y segui probando con ChatGPT nomas");
			
					
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	void testEliminarExitoso(){
		int idusuario = 5;
		UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
		int eliminado = 0;
		try {
			assertTrue(idusuario==5);
			eliminado = usuarioDAOImpl.eliminar(idusuario);
			assertTrue(eliminado>0);
			System.out.println("La eliminacion fue exitosa. Habias sido bueno");
		} catch (SQLException e) {
			assertTrue(eliminado ==0);
			System.err.println("Eliminacion fallida. Anda y segui probando con ChatGPT nomas");
			
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
	@Test
	void testConsultarExitoso() {
		UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
		
		try {
			List<Usuario> usuarios = usuarioDAOImpl.consultar();
			
			assertTrue(usuarios.size()>0);
			for (Usuario usuario : usuarios) {
				System.out.println("id "+ usuario.getIdUsuario());
				System.out.println("apellido "+ usuario.getApellidoUsuario());
				System.out.println("nombre "+usuario.getNombreUsuario());
				System.out.println("contraseña " +usuario.getContraseñaUsuario());
				System.out.println("telefono "+ usuario.getTelefonoUsuario());
				System.out.println("email "+usuario.getEmailUsuario());
				System.out.println("dni "+usuario.getDniUsuario());
				System.out.println("direccion "+usuario.getDireccionUsuario());
				System.out.println("pais "+usuario.getPaisUsuario());
				System.out.println("fecha nac "+usuario.getFechaNacimientoUsuario()+"\n");
				System.out.println("Consulta exitosa. Ahora podeemos seguir con lo que sigue");
				
			}
		} catch (SQLException e) {
			
			System.err.println("Eliminacion fallida. Anda y segui probando con ChatGPT nomas");
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}

