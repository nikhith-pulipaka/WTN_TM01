package com.wipro.eb.entity;

public class Domestic extends Connection {

	private static final float[] slabs= {2.3f,4.2f,5.5f};
	public Domestic(int cr,int pr) {
		super(cr,pr);
	}
	public float computeBill() {
		int units=this.currentReading-this.previousReading;
		return (units<=50)?units*slabs[0]:((units<=100)?50*slabs[0]+(units-50)*slabs[1]:50*slabs[0]+50*slabs[1]+(units-100)*slabs[2]);
	}
}
