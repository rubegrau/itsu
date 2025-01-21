/**
 * 
 */
package com.itsu.itsu_def_entities.entity;

import java.sql.Date;

/**
 * 
 */
public class Inscripcion {
	private int idInscripcion;
	private Date fechaInscripcion;
	private String estadoInscripcion;
	private Usuario usuario;
	
	private Usuario idUsuario;
	private Mesas_Examenes idMesaExamanes;
	private Mesas_Examenes mesaExamen;
	
	/**
	 * @return the id
	 */
	
	/**
	 * @return the idinscripcion
	 */
	public int getIdInscripcion() {
		return idInscripcion;
	}
	/**
	 * @param idinscripcion the idinscripcion to set
	 */
	public void setIdInscripcion(int idinscripcion) {
		this.idInscripcion = idinscripcion;
	}
	/**
	 * @param id the id to set
	 */
	
	
	/**
	 * @return the fechaInscripcion
	 */
	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}
	/**
	 * @param fechaInscripcion the fechaInscripcion to set
	 */
	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	/**
	 * @return the estadoInscripcion
	 */
	
	/**
	 * @return the idUsuario
	 */
	public Usuario getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * @return the idMesaExamanes
	 */
	public Mesas_Examenes getIdMesaExamanes() {
		return idMesaExamanes;
	}
	/**
	 * @param idMesaExamanes the idMesaExamanes to set
	 */
	public void setIdMesaExamanes(Mesas_Examenes idMesaExamanes) {
		this.idMesaExamanes = idMesaExamanes;
	}
	/**
	 * @return the estadoInscripcion
	 */
	public String getEstadoInscripcion() {
		return estadoInscripcion;
	}
	/**
	 * @param estadoInscripcion the estadoInscripcion to set
	 */
	public void setEstadoInscripcion(String estadoInscripcion) {
		this.estadoInscripcion = estadoInscripcion;
	}
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the mesaExamenes
	 */
	public Mesas_Examenes getMesaExamen() {
		return mesaExamen;
	}
	/**
	 * @param mesaExamenes the mesaExamenes to set
	 */
	public void setMesaExamen(Mesas_Examenes mesaExamenes) {
		this.mesaExamen = mesaExamenes;
	}
	

}
