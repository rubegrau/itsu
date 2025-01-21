/**
 * 
 */
package com.itsu.itsu_def_entities.entity;



/**
 * 
 */
public class Materia {
	private int idMateria;
	private String nombreMateria;
	private String tipoMateria;
	private Carrera Carrera; //OJO QUE SAQUE ID SEGURO TRAE PROBLEMAS
	/**
	 * @return the carrera
	 */
	
	
	private Años idAños;
	private Años años;
	/**
	 * @return the idMateria
	 */
	public int getIdMateria() {
		return idMateria;
	}
	/**
	 * @return the tipoMateria
	 */
	public String getTipoMateria() {
		return tipoMateria;
	}
	/**
	 * @param tipoMateria the tipoMateria to set
	 */
	public void setTipoMateria(String tipoMateria) {
		this.tipoMateria = tipoMateria;
	}
	/**
	 * @param idMateria the idMateria to set
	 */
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	/**
	 * @return the nombreMateria
	 */
	public String getNombreMateria() {
		return nombreMateria;
	}
	/**
	 * @param nombreMateria the nombreMateria to set
	 */
	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}
	/**
	 * @return the tipoMateria
	 */
	
	/**
	 * @return the idCarrera
	 */
	public Carrera getIdCarrera() {
		return Carrera;
	}
	/**
	 * @param idCarrera the idCarrera to set
	 */
	public void setIdCarrera(Carrera idCarrera) {
		this.Carrera = idCarrera;
	}
	/**
	 * @return the idAños
	 */
	public Años getIdAños() {
		return idAños;
	}
	/**
	 * @param idAños the idAños to set
	 */
	public void setIdAños(Años idAños) {
		this.idAños = idAños;
	}
	/**
	 * @return the idmaterias
	 */
	/**
	 * @return the años
	 */
	public Años getAños() {
		return años;
	}
	/**
	 * @param años the años to set
	 */
	public void setAños(Años años) {
		this.años = años;
	}
	public Carrera getCarrera() {
		return Carrera;
	}
	/**
	 * @param carrera the carrera to set
	 */
	public void setCarrera(Carrera carrera) {
		Carrera = carrera;
	}
}
