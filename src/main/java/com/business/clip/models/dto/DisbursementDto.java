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
public class DisbursementDto implements Serializable {
	private static final long serialVersionUID = -4789017742483187413L;
	private int id;
	private BigDecimal amount;
	private Integer clipUser;
	private Date lastTs;
	private Date createTs;

	public DisbursementDto() {
	}

	public DisbursementDto(BigDecimal amount, Integer clipUser) {
		this.amount = amount;
		this.clipUser = clipUser;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getClipUser() {
		return clipUser;
	}

	public void setClipUser(Integer clipUser) {
		this.clipUser = clipUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "DisbursementDto [id=" + id + ", amount=" + amount + ", clipUser=" + clipUser + ", lastTs=" + lastTs
				+ ", createTs=" + createTs + "]";
	}

}
