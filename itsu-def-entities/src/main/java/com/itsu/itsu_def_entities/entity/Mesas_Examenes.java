/**
 * 
 */
package com.itsu.itsu_def_entities.entity;

/**
 * 
 */
public class Mesas_Examenes {
	private int idMesaExamen;
	private String fechaMesa;
	private String llamadoExamen;
	private String presidenteMesa;
	private String vocal1;
	private String vocal2;
	private Materia idMateria;
	
	private Materia materia;
	
	/**
	 * @return the idMesasExamanes
	 */
	public int getIdMesaExamen() {
		return idMesaExamen;
	}
	/**
	 * @param idMesasExamanes the idMesasExamanes to set
	 */
	public void setIdMesaExamen(int idMesaExamen) {
		this.idMesaExamen = idMesaExamen;
	}
	/**
	 * @return the fechaMesa
	 */
	public String getFechaMesa() {
		return fechaMesa;
	}
	/**
	 * @param fechaMesa the fechaMesa to set
	 */
	public void setFechaMesa(String fechaMesa) {
		this.fechaMesa = fechaMesa;
	}
	/**
	 * @return the llamadoExamen
	 */
	public String getLlamadoExamen() {
		return llamadoExamen;
	}
	/**
	 * @param llamadoExamen the llamadoExamen to set
	 */
	public void setLlamadoExamen(String llamadoExamen) {
		this.llamadoExamen = llamadoExamen;
	}
	/**
	 * @return the presidenteMesa
	 */
	public String getPresidenteMesa() {
		return presidenteMesa;
	}
	/**
	 * @param presidenteMesa the presidenteMesa to set
	 */
	public void setPresidenteMesa(String presidenteMesa) {
		this.presidenteMesa = presidenteMesa;
	}
	/**
	 * @return the vocal1
	 */
	public String getVocal1() {
		return vocal1;
	}
	/**
	 * @param vocal1 the vocal1 to set
	 */
	public void setVocal1(String vocal1) {
		this.vocal1 = vocal1;
	}
	/**
	 * @return the vocal2
	 */
	public String getVocal2() {
		return vocal2;
	}
	/**
	 * @param vocal2 the vocal2 to set
	 */
	public void setVocal2(String vocal2) {
		this.vocal2 = vocal2;
	}
	/**
	 * @return the idMateria
	 */
	public Materia getIdMateria() {
		return idMateria;
	}
	/**
	 * @param idMateria the idMateria to set
	 */
	public void setIdMateria(Materia idMateria) {
		this.idMateria = idMateria;
	}
	/**
	 * @return the materia
	 */
	public Materia getMateria() {
		return materia;
	}
	/**
	 * @param materia the materia to set
	 */
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
}
