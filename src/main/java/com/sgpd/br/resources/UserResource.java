package com.sgpd.br.resources;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgpd.br.entities.User;
import com.sgpd.br.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user = userService.findbyId(id);
		return ResponseEntity.ok().body(user);
	}
	
	
	@PostMapping(value = "/byParam")
	public ResponseEntity<List<User>> findUsuarioByParam(@Valid @RequestBody User user, BindingResult result) throws ParseException {
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list); 
	}
	
	@GetMapping(value = "/validateLogin")
	public User validateLogin() {
		return new User(1L, "javainuse", "phone", "password", "status");
	}

}
