package com.test.navis.repository;

import java.io.IOException;
import java.util.List;

import com.test.navis.entity.Mine;

public interface FileMineRepository {

	public List<Mine> getAllMines() throws IOException; 
	
}
