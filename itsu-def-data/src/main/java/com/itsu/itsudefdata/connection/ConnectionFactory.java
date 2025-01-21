/**
 * 
 */
package com.itsu.itsudefdata.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**Ruben Grauberger
 * clase que se encarga de realizar la configuracion, la conexion y
 * habilitar las transacciones de una base de datos*/

public class ConnectionFactory {

    private static Connection connection;
    private static Statement statement;

    /**metodo que permite conectarse a la BD
	 * 
	 * @return objeto Connection con la informacion de la BD conectada / null
	 * @throws ClassNotFoundException Exception generada al no cargar el driver de conexion
	 * @throws SQLException exception generada al no conectarse a la BD
	 */

    
    
    public static Connection conectar() throws ClassNotFoundException, SQLException {
        if (connection == null || connection.isClosed()) {
            // Paso 1: cargar el driver de conexión
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer los datos de conexión
            String url = "jdbc:mysql://localhost:3306/bdd190924";
            String user = "root";
            String password = "12345";

            // Paso 3: establecer la conexión
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement(); // habilitando proceso para ejecutar SQL
            System.out.println("Conexión a la base de datos establecida.");
        }
        return connection;
    }

    // Método para obtener la conexión (inicializa si es nula)
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                conectar();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
	 * Permite ejecutar sentencia INSERT, UPDATE, DELETE
	 * @param sql  parametro con la sentencia a ejecutarse
	 * @return 1 en caso de ser exitoso o 0 en caso de error
	 * @throws SQLException excepcion generada al ejecutar la sentencia sql
	 */

    public static int ejecutarSQL(String sql) throws SQLException {
        System.out.println("Ejecutando consulta: " + sql);
        if (getConnection() != null) {
            return statement.executeUpdate(sql);
        }
        throw new SQLException("Conexión a la base de datos no establecida.");
    }

    /**
	 * permite ejecutar sentencias SELECT
	 *  @param sql  parametro con la sentencia a ejecutarse
	 * @return objeto con la informacion obtenida de la sentencia select 
	 * @throws SQLException excepcion generada al ejecutar la sentencia sql
	 */

    public static ResultSet ejecutarSQLSelect(String sql) throws SQLException {
        System.out.println("Ejecutando consulta: " + sql);
        if (getConnection() != null) {
            return statement.executeQuery(sql);
        }
        throw new SQLException("Conexión a la base de datos no establecida.");
    }

    // Método para cerrar la conexión y liberar recursos
    public static void cerrarConexion() {
        try {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
            System.out.println("Conexión a la base de datos cerrada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
