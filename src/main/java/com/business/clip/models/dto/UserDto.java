package com.business.clip.models.dto;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Eddy
 */
public class UserDto implements Serializable {

	private static final long serialVersionUID = 1220625609202085033L;

	private int id;
	private String nombre;
	private Date createTs;
	private Date lastTs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getCreateTs() {
		return createTs;
	}

	public void setCreateTs(Date createTs) {
		this.createTs = createTs;
	}

	public Date getLastTs() {
		return lastTs;
	}

	public void setLastTs(Date lastTs) {
		this.lastTs = lastTs;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", nombre=" + nombre + ", createTs=" + createTs + ", lastTs=" + lastTs + "]";
	}

}
