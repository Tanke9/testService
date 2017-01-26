package bootinicial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import bootinicial.service.TestService;

@RestController
public class InitialRestController {
	@Autowired
	private TestService testService;
	
	@GetMapping(value="/test", produces=MediaType.APPLICATION_JSON_VALUE)
	public String hello(){
		return testService.test();
	}
	
}
