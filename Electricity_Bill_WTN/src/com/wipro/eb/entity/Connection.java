package com.wipro.eb.entity;

public abstract class Connection {
	protected int previousReading,currentReading;
	Connection(int cr,int pr){
		this.previousReading=pr;
		this.currentReading=cr;
	}
	public int getPreviousReading() {
		return previousReading;
	}
	public void setPreviousReading(int previousReading) {
		this.previousReading=previousReading;
	}
	public int getCurrentReading() {
		return currentReading;
	}
	public void setCurrentsReading(int currentReading) {
		this.currentReading=currentReading;
	}
	public abstract float computeBill();

}
