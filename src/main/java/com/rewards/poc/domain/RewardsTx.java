package com.rewards.poc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RewardsTx extends Reward{
	@Id
	@GeneratedValue
	private Long txId;
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Customer customer;
	private Double totalTx;
	private String desc;
	@Temporal(TemporalType.TIMESTAMP)
	private Date txDate;

	@Override
	public Long getRewardsPoints() {

		this.points = 0l;
		/**
		 1 point for every dollar spent over $50
		2 points for every dollar spent over $100
		 **/
		if (this.totalTx > 100) {
			this.points += 50;
			this.points += (this.totalTx.intValue() - 100) * 2;
		}

		if (this.totalTx > 50 && this.totalTx <= 100) {
			this.points += (this.totalTx.intValue() - 50) * 1;
			
		}
		
		return this.points;
	}
	
}
