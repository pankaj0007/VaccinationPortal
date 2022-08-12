package com.pankaj.vaccination.center.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pankaj.vaccination.center.entity.VaccinationCenter;
import com.pankaj.vaccination.center.repostories.CenterRepo;
import com.pankaj.vaccination.entity.User;
import com.pankaj.vaccincation.center.model.UserCenterData;

@RestController
@RequestMapping("/vaccinationCenter")
public class VaccinationCenterController {

	@Autowired
	private CenterRepo centerRepo;
	
	@Autowired 
	public RestTemplate restTemplate;
	
	@PostMapping("/add")
	public ResponseEntity<VaccinationCenter> createUSer(@RequestBody VaccinationCenter center) {
		VaccinationCenter dbCenter = centerRepo.save(center);
		return new ResponseEntity<VaccinationCenter>(dbCenter, HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	@HystrixCommand(fallbackMethod = "handleUserDownTime")
	public ResponseEntity<List<UserCenterData>> getAllDataBasedOnCenterID(@PathVariable Integer id){
		UserCenterData data = new UserCenterData();
		VaccinationCenter center = centerRepo.findById(id).get();
		//get userDetails for that user id
		List<User> userList = restTemplate.getForObject("http://USER-SERVICE/users/id/"+id, List.class);
		data.setCenter(center);
		data.setUserList(userList);
		return new ResponseEntity(data, HttpStatus.OK);
	}
	
	
	public ResponseEntity<List<UserCenterData>> handleUserDownTime(@PathVariable Integer id){
		UserCenterData data = new UserCenterData();
		VaccinationCenter center = centerRepo.findById(id).get();
		data.setCenter(center);
		return new ResponseEntity(data, HttpStatus.OK);
	}
}
