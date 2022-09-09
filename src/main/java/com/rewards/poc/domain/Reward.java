package com.rewards.poc.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Transient;

public abstract class Reward {
	@Transient
	@JsonInclude
	protected Long points;
	public abstract Long getRewardsPoints();

}
