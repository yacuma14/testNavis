package com.test.navis.business;

import java.io.IOException;
import java.util.List;

import com.test.navis.entity.Mine;
import com.test.navis.entity.MineCount;


public interface MineBusiness {

	public Long  getMaximumNumberOfMinesExploded(Float x, Float y) throws IOException;
	
	public Mine getMaxExplodeMine() throws IOException; 
	
	public List<MineCount> getAllCountMineExploded()throws IOException;
}
