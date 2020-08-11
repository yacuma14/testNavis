package com.test.navis.entity;

public class Mine {

	private Float x;
	
	private Float y;
	
	private Float r;
	
	public Mine() {
		
	}

	public Mine(Float x, Float y, Float r) {
		super();
		this.x = x;
		this.y = y;
		this.r = r;
	}

	public Float getX() {
		return x;
	}

	public void setX(Float x) {
		this.x = x;
	}

	public Float getY() {
		return y;
	}

	public void setY(Float y) {
		this.y = y;
	}

	public Float getR() {
		return r;
	}

	public void setR(Float r) {
		this.r = r;
	}

	
	
	@Override
	public String toString() {
		return "Mine [x=" + x + ", y=" + y + ", r=" + r + "]";
	}
	
	
	
	
	
}
