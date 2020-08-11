package com.test.navis.entity;

public class ResponseMine<E> {

	private int status;
	
	private E result;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public E getResult() {
		return result;
	}

	public void setResult(E result) {
		this.result = result;
	}
	
	
}
