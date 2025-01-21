/**
 * 
 */
package com.itsu.itsu_def_entities.entity;

/**
 * 
 */
public class Plan_de_estudios {
	private int idPlan_de_estudios;
	private String nombrePlan_de_estudios;
	private String resolucionPlan_de_estudios;
	private Carrera idCarrera;
	/**
	 * @return the idPlan_de_estudios
	 */
	public int getIdPlan_de_estudios() {
		return idPlan_de_estudios;
	}
	/**
	 * @param resolucionPlan_de_estudios the resolucionPlan_de_estudios to set
	 */
	public void setResolucionPlan_de_estudios(String resolucionPlan_de_estudios) {
		this.resolucionPlan_de_estudios = resolucionPlan_de_estudios;
	}
	/**
	 * @param idPlan_de_estudios the idPlan_de_estudios to set
	 */
	public void setIdPlan_de_estudios(int idPlan_de_estudios) {
		this.idPlan_de_estudios = idPlan_de_estudios;
	}
	/**
	 * @return the nombrePlan_de_estudios
	 */
	public String getNombrePlan_de_estudios() {
		return nombrePlan_de_estudios;
	}
	/**
	 * @param nombrePlan_de_estudios the nombrePlan_de_estudios to set
	 */
	public void setNombrePlan_de_estudios(String nombrePlan_de_estudios) {
		this.nombrePlan_de_estudios = nombrePlan_de_estudios;
	}
	/**
	 * @return the resolucionPlan_de_estudios
	 */
	public String getResolucionPlan_de_estudios() {
		return resolucionPlan_de_estudios;
	}
	/**
	 * @param resolucionPlan_de_estudios the resolucionPlan_de_estudios to set
	 */
	
	/**
	 * @return the idCarrera
	 */
	public Carrera getIdCarrera() {
		return idCarrera;
	}
	/**
	 * @param idCarrera the idCarrera to set
	 */
	public void setIdCarrera(Carrera idCarrera) {
		this.idCarrera = idCarrera;
	}
	
	

}
