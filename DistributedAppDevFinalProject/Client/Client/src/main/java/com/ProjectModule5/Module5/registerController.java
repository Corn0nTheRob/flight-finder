/* package com.ProjectModule5.Module5;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class registerController {

    @GetMapping("/register")
	public String register() {
		return "register";
	}
    
    @PostMapping("/register")
    public String register(
        @RequestParam(name="username") String username, 
        @RequestParam(name="password") String password,
        Model model) throws IOException{
        
        //registers the user
        User newUser = new User(username, password);
        UserUtil.registerUser(newUser);
        return "login";
    }

}



 */