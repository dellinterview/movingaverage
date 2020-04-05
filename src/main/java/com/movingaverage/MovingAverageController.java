package com.movingaverage;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MovingAverageController {

	@Autowired
	private MovingAverageInterface movingAverageInterface;
	
	@PostMapping(path = "/add", consumes = MediaType.ALL_VALUE)
	public void add(@RequestBody  Input input) {		
		movingAverageInterface.add(input.getNumber());
	}
	
	@GetMapping("/movingaverage/{lastN}")
	public ResponseEntity<Float> getMovingAverage(@PathVariable(name ="lastN") int lastN) throws Exception {	
		ResponseEntity<Float> response = new ResponseEntity<Float>(movingAverageInterface.getMovingAverage(lastN), HttpStatus.OK);
		return response;
	}
	
	
}
