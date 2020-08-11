package com.test.navis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.test.navis.business.MineBusiness;
import com.test.navis.entity.Mine;
import com.test.navis.entity.MineCount;
import com.test.navis.entity.ResponseMine;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/mines")
@Validated
public class MinesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MinesController.class);
    
    @Autowired
    private MineBusiness mineBusiness;
    
   
    
    
    @GetMapping(path = "getNumberMinesExploded/x/{x}/y/{y}", produces = "application/json")
    @ApiOperation(value = "Get Maximum Number Of Mines Exploded")
    public ResponseEntity<ResponseMine<Long>> getNumberMinesExploded(@PathVariable(name="x",required=true) Float x,
    												   @PathVariable(name="y",required=true) Float y){
  	  LOGGER.debug("getNumberMinesExploded[x]{" + x+"}[y]{"+y+"]");
  	  ResponseMine<Long> responseMine=new ResponseMine<>();
 	   
  	  try {
  			responseMine.setResult(mineBusiness.getMaximumNumberOfMinesExploded(x, y));
    		responseMine.setStatus(HttpStatus.OK.ordinal());
    		return new ResponseEntity<ResponseMine<Long>>(responseMine,HttpStatus.OK); 
    		}
	
    	catch (IOException e) {
    		LOGGER.error("Error["+e.getMessage()+"]");  
    		responseMine.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.ordinal());
        	return new ResponseEntity<ResponseMine<Long>>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    
}

    @GetMapping(path = "getMaxMinesExploded", produces = "application/json")
    @ApiOperation(value = "Get Max Explode Mine")
    public ResponseEntity<ResponseMine<Mine>> getMaxExplodeMine(){
  	 
    LOGGER.debug("getMaxExplodeMine");
  	ResponseMine<Mine> responseMine=new ResponseMine<>();
  	  try {
    		 responseMine.setResult(mineBusiness.getMaxExplodeMine());
    		 responseMine.setStatus(HttpStatus.OK.ordinal());
    		 return new ResponseEntity<ResponseMine<Mine>>(responseMine,HttpStatus.OK); 
    		}
	
    	catch (IOException e) {
    		e.printStackTrace();
    		LOGGER.error("Error["+e.getMessage()+"]");  
    		responseMine.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.ordinal());
    		return new ResponseEntity<ResponseMine<Mine>>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    
} 

    @GetMapping(path = "getDetailMinesExploded", produces = "application/json")
    @ApiOperation(value = "Get detail Explode Mine")
    public ResponseEntity<ResponseMine<List<MineCount>>> getDetailExplodeMine(){
  	  
      LOGGER.debug("getMaxExplodeMine");
      ResponseMine<List<MineCount>> responseMine=new ResponseMine<>();
      try {
    	  responseMine.setResult(mineBusiness.getAllCountMineExploded());
    	  responseMine.setStatus(HttpStatus.OK.ordinal());
    	 return new ResponseEntity<ResponseMine<List<MineCount>>>(responseMine,HttpStatus.OK); 
    	}
	
    	catch (IOException e) {
    		LOGGER.error("Error["+e.getMessage()+"]");  
    		responseMine.setStatus(HttpStatus.OK.ordinal());
    		return new ResponseEntity<ResponseMine<List<MineCount>>>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    
}
    
}