package com.business.clip.models.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Eddy
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class TransactionDto implements Serializable {

	private static final long serialVersionUID = -2584718385816946581L;

	private int id;
	private BigDecimal amount;
	private int clipUser;
	private String cardData;
	private Boolean disbursed;
	private Date lastTs;
	private Date createTs;

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

	public Date getLastTs() {
		return lastTs;
	}

	public void setLastTs(Date lastTs) {
		this.lastTs = lastTs;
	}

	public Date getCreateTs() {
		return createTs;
	}

	public void setCreateTs(Date createTs) {
		this.createTs = createTs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getDisbursed() {
		return disbursed;
	}

	public void setDisbursed(Boolean disbursed) {
		this.disbursed = disbursed;
	}

	@Override
	public String toString() {
		return "TransactionDto [id=" + id + ", amount=" + amount + ", clipUser=" + clipUser + ", cardData=" + cardData
				+ ", disbursed=" + disbursed + ", lastTs=" + lastTs + ", createTs=" + createTs + "]";
	}

}
