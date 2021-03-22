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
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "amount")
	private BigDecimal amount;

	@Column(name = "id_user")
	private int clipUser;

	@Column(name = "card_data")
	private String cardData;

	@Column(name = "disbursed")
	private Boolean disbursed;

	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "create_ts")
	private Date createTs;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "last_ts")
	private Date lastTs;

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

	public String getCardData() {
		return cardData;
	}

	public void setCardData(String cardData) {
		this.cardData = cardData;
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

	public Boolean getDisbursed() {
		return disbursed;
	}

	public void setDisbursed(Boolean disbursed) {
		this.disbursed = disbursed;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", amount=" + amount + ", clipUser=" + clipUser + ", cardData=" + cardData
				+ ", disbursed=" + disbursed + ", createTs=" + createTs + ", lastTs=" + lastTs + "]";
	}

}
