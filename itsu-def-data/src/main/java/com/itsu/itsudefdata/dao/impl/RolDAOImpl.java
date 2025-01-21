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

import com.itsu.itsu_def_entities.entity.Rol;
import com.itsu.itsudefdata.connection.ConnectionFactory;
import com.itsu.itsudefdata.dao.RolDAO;

/**clase implementacion CRUD interfaz rol
 * 
 */
public class RolDAOImpl implements RolDAO {

	@Override
	public int guardar(Rol rol) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizar(Rol rol) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(int idRol) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Rol> consultar() {
	    List<Rol> consultarRoles = new ArrayList<>();
	    String sql = "SELECT * FROM rol;";

	    try (ResultSet rs = ConnectionFactory.ejecutarSQLSelect(sql)) {
	        if (rs != null) {
	            while (rs.next()) {
	                Rol rol = new Rol();
	                rol.setIdRol(rs.getInt("idRol"));
	                rol.setNombreRol(rs.getString("nombreRol"));
	                
	                consultarRoles.add(rol);
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al consultar roles: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return consultarRoles;
	}


	@Override
	public Rol consultarPorId(int idRol) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public List<Rol> consultarRol() throws SQLException {
        List<Rol> rolesDB = new ArrayList<>();
        String sql = "SELECT * FROM rol;";
        
        ResultSet rs = ConnectionFactory.ejecutarSQLSelect(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    Rol rol = new Rol();
                    rol.setIdRol(rs.getInt("idRol"));
                    rol.setNombreRol(rs.getString("nombreRol"));
                    rolesDB.add(rol);
                }
            } finally {
                rs.close(); // Cierra el ResultSet para liberar recursos
            }
        }
        
        return rolesDB;
	}
// AGREGADO PARA PROBAR
	public Rol obtenerRolPorNombre(String nombreRol) throws SQLException {
        Rol rol = null;
        String sql = "SELECT * FROM Rol WHERE nombreRol = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombreRol);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    rol = new Rol();
                    rol.setIdRol(rs.getInt("idRol"));
                    rol.setNombreRol(rs.getString("nombreRol"));
                }
}
        }return rol;
        
	}}

