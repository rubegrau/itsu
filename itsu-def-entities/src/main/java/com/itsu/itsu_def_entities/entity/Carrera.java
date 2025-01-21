/**
 * 
 */
package com.itsu.itsu_def_entities.entity;

/**
 * 
 */
public class Carrera {
	private Integer idCarrera;
	private String nombreCarrera;
	private Plan_de_estudios planDeEstudios;
	
	
	
	/**
	 * @return the idcarreras
	 */
	/**
	 * @return the idCarrera
	 */
	public Integer getIdCarrera() {
		return idCarrera;
	}
	/**
	 * @param idCarrera the idCarrera to set
	 */
	public void setIdCarrera(Integer idCarrera) {
		this.idCarrera = idCarrera;
	}
	/**
	 * @return the nombreCarrera
	 */
	public String getNombreCarrera() {
		return nombreCarrera;
	}
	/**
	 * @param nombreCarrera the nombreCarrera to set
	 */
	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	
	
	/**
	 * @return the planDeEstudios
	 */
	public Plan_de_estudios getPlanDeEstudios() {
		return planDeEstudios;
	}
	/**
	 * @param planDeEstudios the planDeEstudios to set
	 */
	public void setPlanDeEstudios(Plan_de_estudios planDeEstudios) {
		this.planDeEstudios = planDeEstudios;
	}
	

	
}
