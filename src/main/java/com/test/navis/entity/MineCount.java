package com.test.navis.entity;

public class MineCount {

	private Mine mine;
	
	private Long totalExploded;

	public Mine getMine() {
		return mine;
	}

	public void setMine(Mine mine) {
		this.mine = mine;
	}

	public Long getTotalExploded() {
		return totalExploded;
	}

	public void setTotalExploded(Long totalExploded) {
		this.totalExploded = totalExploded;
	}

	@Override
	public String toString() {
		return "MineCount [mine=" + mine + ", totalExploded=" + totalExploded + "]";
	}  

	
}
