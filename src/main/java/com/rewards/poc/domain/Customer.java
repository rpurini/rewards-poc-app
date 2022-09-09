package com.rewards.poc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
	@Id
	@GeneratedValue
	private Integer id;
	private String customerName;
	@OneToMany(mappedBy="customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<RewardsTx> rewardTxs;

	//constructor to store dummy data
	public Customer(Integer id, String name) {
		super();
		this.id = id;
		this.customerName = name;
	}
	
}
