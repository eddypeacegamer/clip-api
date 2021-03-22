package com.business.clip.models.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Eddy
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "disbursement")
public class Disbursement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "amount")
	private BigDecimal amount;

	@Column(name = "id_user")
	private int clipUser;

	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "create_ts")
	private Date createTs;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "last_ts")
	private Date lastTs;

	public Disbursement(BigDecimal amount, int clipUser) {
		this.amount = amount;
		this.clipUser = clipUser;
	}

	public Disbursement() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getClipUser() {
		return clipUser;
	}

	public void setClipUser(int clipUser) {
		this.clipUser = clipUser;
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
		return "Disbursement [id=" + id + ", amount=" + amount + ", clipUser=" + clipUser + ", createTs=" + createTs
				+ ", lastTs=" + lastTs + "]";
	}

}
