package com.test.navis.repository;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.test.navis.entity.Mine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.test.navis.file.utility.FileUtility.getAllPathFiles;
@Repository
public class FileMineRepositoryImpl implements FileMineRepository {

	
	@Value("${path.code.test.file}")
	private  String FILE_DIRECTORY_MINES;
	
	
	@Value("${path.code.test.file.extension}")
	private  String FILE_EXTENSION_MINES;
	
	
	
	@Override
	public List<Mine> getAllMines() throws IOException {
	
	 List<String> pathFiles = getAllPathFiles(FILE_DIRECTORY_MINES,FILE_EXTENSION_MINES);
	 List<Mine> mines =new ArrayList<>();;
	 Validate.notEmpty(pathFiles,"Error there is no file to read");
	 for(String pathFileName:pathFiles) {
		 List<List<String>>	values = Files.lines(Paths.get(pathFileName)).map(line -> Arrays.asList(line.split("\\s+"))).collect(Collectors.toList());
		 mines=values.stream().map(value->{
							return new Mine(Float.parseFloat(value.get(0)),
									        Float.parseFloat(value.get(1)), 
									        Float.parseFloat(value.get(2)));
						} ) .collect(Collectors.toList());	
		  };
		  
		return mines;
	}

}
