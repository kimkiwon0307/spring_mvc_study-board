package org.zerock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

import jdk.internal.org.jline.utils.Log;

@Controller
@RequestMapping("/sample/*")
public class SampleController {

		
	@GetMapping(value="/getText", produces ="text/plain; charset=UTF-8")
	public String getText() {
		
		return "안녕하세요";
	}
	
	@GetMapping(value="/getSamle", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
						                       MediaType.APPLICATION_ATOM_XML_VALUE})
	public SampleVO getSample() {
		
		return new SampleVO(111,"스타","화이");
	}
	
	@GetMapping("/getList")
	public List<SampleVO> getList(){
		
		return IntStream.range(1, 10).mapToObj(i->new SampleVO(i,i+"First",i+"Last")).collect(Collectors.toList());
	}
	
	@GetMapping("/getMap")
	public Map<String,SampleVO> getMap(){
		
		Map<String, SampleVO>map = new HashMap<>();
		map.put("First", new SampleVO(222,"ddd","eeee"));
		
		return map;
	}
	
	@GetMapping(value="/check" ,params= {"height", "weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		
		SampleVO vo = new SampleVO(0,""+height,""+weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if(height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid) {
		
		return new String[] {"category: " + cat, "productid:" + pid};
	}
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		
		return ticket;
	}
	
	
	@GetMapping("/all")
	public void doAll() {
		
		System.out.println("접속");
	}
	
	@GetMapping("/member")
	public void doMember() {
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
	}
	
}

