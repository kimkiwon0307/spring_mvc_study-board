package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jdk.internal.org.jline.utils.Log;

@Controller
@RequestMapping("/sample01/*")
public class SampleController01 {

	@RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		Log.info("basic get.......");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		Log.info("only get");
	}
	
	@PostMapping("/basicOnlyPost")
	public void basicPost() {
		Log.info("only post");
	}


}


