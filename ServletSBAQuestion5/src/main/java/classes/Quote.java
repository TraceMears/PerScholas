package classes;

import java.time.LocalDateTime;

public class Quote {
	
	private int quoteId;
	private int homeId;
	private double premium;
	private LocalDateTime startDate;
	private LocalDateTime expiration;
	private int activeFlag;
	
	public Quote(int quoteId, int homeId, double premium, LocalDateTime startDate, LocalDateTime expiration,
				int activeFlag) {
		this.quoteId = quoteId;
		this.homeId = homeId;
		this.premium = premium;
		this.startDate = startDate;
		this.expiration = expiration;
		this.activeFlag = activeFlag;
	}
	public Quote() {
		
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getExpiration() {
		return expiration;
	}

	public void setExpiration(LocalDateTime expiration) {
		this.expiration = expiration;
	}

	public int getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}

	public int getQuoteId() {
		return quoteId;
	}

	public int getHomeId() {
		return homeId;
	}	
}
