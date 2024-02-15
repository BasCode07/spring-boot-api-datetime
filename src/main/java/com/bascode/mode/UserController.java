package com.bascode.mode;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
	
	
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/create")
	public ResponseEntity<User> create(@RequestBody User user){
		user.setCreatedAt(LocalDateTime.now());
		return new ResponseEntity<>(userRepo.save(user), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> update(@PathVariable("id") int id, @RequestBody User user){
		 User exsiting =  userRepo.findById(id)
			.orElseThrow(() -> new RuntimeException("No user found"));
		exsiting.setUpdatedAt(LocalDateTime.now());
		exsiting.setFullName(user.getFullName());
		
		return ResponseEntity.ok(userRepo.save(exsiting));
	}
	
	@GetMapping("/all")
	public List<User> getAll(){
		return userRepo.findAll();
	}

}
