package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleVO;
import org.zerock.domain.SampleVOList;
import org.zerock.domain.TodoVO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample")
@Log4j
public class SampleController {

	@RequestMapping("")
	public String basic() {
		log.info("basic.....");
		return "basic";
	}

	@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST })
	public void basicGet() {
		log.info("basic Get.....");
	}

	@GetMapping("/basicOnlyget")
	public void basicGet2() {
		log.info("basic Only Get.....");
	}

	@GetMapping("/ex01")
	public String ex01(SampleVO vo) {
		log.info("vo: " + vo);
		return "ex01";
	}

	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name: " + name);
		log.info("age: " + age);
		return "ex02";
	}

	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids Array: " + ids);
		return "ex02List";
	}

	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("ids Array: " + ids);
		return "ex02Array";
	}

	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleVOList vo) {
		log.info("vos: " + vo);
		return "ex02Bean";
	}

	@GetMapping("/ex03")
	public String ex03(TodoVO todo) {
		log.info("todo: " + todo);
		return "ex03";
	}

	@GetMapping("/ex04")
//	public String ex04(SampleVO vo, int page) {
	public String ex04(SampleVO vo, @ModelAttribute("page") int page) {
		log.info("vo: " + vo);
		log.info("page: " + page);
		return "sample/ex04";
	}

	@GetMapping("/ex05")
	public void ex05() {
		log.info("ex05.....");
	}

	@GetMapping("/ex05String")
	public String ex05String() {
		log.info("ex05String.....");
		return "ex05";
	}

	@GetMapping("/ex06")
	@ResponseBody
	public SampleVO ex06() {
		log.info("/ex06.....");
		SampleVO vo = new SampleVO();
		vo.setName("sakamoto");
		vo.setAge(32);
		return vo;
	}

	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("/ex07.....");

		// {"msg":"홍길동"}
		String msg = "{\"msg\":\"홍길동\"}";

		HttpHeaders header = new HttpHeaders();
		header.add("content-Type", "application/json;charset=UTF-8");

		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}

	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload.....");
	}

	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		log.info("exUploadPost.....");
		files.forEach(file -> {
			log.info("==================");
			log.info(file.getOriginalFilename());
			log.info(file.getSize());
		});
	}

}
