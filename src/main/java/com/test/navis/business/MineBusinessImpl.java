package com.test.navis.business;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.navis.entity.Mine;
import com.test.navis.entity.MineCount;
import com.test.navis.repository.FileMineRepository;

@Service
public class MineBusinessImpl implements MineBusiness {

	@Autowired
	private FileMineRepository fileMineRepository;
	
	
	
	@Override
	public Long getMaximumNumberOfMinesExploded(Float x,Float y) throws IOException {
       
		return totalMineExploaded(fileMineRepository.getAllMines(),x,y);
	}
	
	@Override
	public Mine getMaxExplodeMine() throws IOException {
		return getMineOrderExploded(fileMineRepository.getAllMines()).stream().
				max(Comparator.comparing(MineCount::getTotalExploded)).orElseThrow(NoSuchElementException::new).getMine(); 
	}
	
	
	@Override
	public List<MineCount> getAllCountMineExploded() throws IOException {
		return getMineOrderExploded(fileMineRepository.getAllMines());
	}
	
	
	 public final boolean mine_exploded(Float x1, Float y1, Float r, Float x2, Float y2) {

	     return r <= Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));

	 }

	private List<MineCount> getMineOrderExploded(List<Mine> mines){
		    return mines.stream().map(x -> {
		    	MineCount mineCount = new MineCount();
		    	mineCount.setMine(x);
		    	mineCount.setTotalExploded(totalMineExploaded(mines,x.getX(),x.getY()));
		    	return mineCount;
		    }).collect(Collectors.toList());  	 
		     
			
			    
		}
	
	
	private Long totalMineExploaded(List<Mine> mines,Float x,Float y) {
	   return mines.stream().filter(mine -> mine_exploded(mine.getX(),mine.getY(),mine.getR(),x,y)).count();      	
	}

	


}
