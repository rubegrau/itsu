/**
 * 
 */
package com.itsu.itsudefdata.dao.impl;
import java.sql.SQLException;
import java.util.List;

import com.itsu.itsu_def_entities.entity.Años;
import com.itsu.itsudefdata.connection.ConnectionFactory;
import com.itsu.itsudefdata.dao.AñosDAO;


/**
 * 
 */
public class AñosDAOImpl implements AñosDAO {
	

	@Override
	public int guardar(Años años) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Años (descripcionAños)" + "VALUES ('"+años.getDescripcionAños() +"')";
		
		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
	    return ejecutado;
	}

	@Override
	public int actualizar(Años años) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(int idAños) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Años> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Años cosultarPorId(int idAños) {
		// TODO Auto-generated method stub
		return null;
	}

}
