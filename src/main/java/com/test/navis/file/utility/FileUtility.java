package com.test.navis.file.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtility {

	public static List<String> getAllPathFiles(String directoryFile,String extension) throws IOException{
	  List<String> result = Files.walk(Paths.get(directoryFile)).map(x -> x.toString())
				.filter(f -> f.endsWith(extension)).collect(Collectors.toList());

	   return result; 
	}
}
