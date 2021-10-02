package com.ProjectModule5.Module5;


import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class BasicAuthController {

    RestTemplate restTemplate = new RestTemplate();
    String createUserUrl = "http://localhost:8080/register";

    @GetMapping({"/register"})
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam(name="username") String username, 
                           @RequestParam(name="password") String password, Model model) {
        
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        
        ResponseEntity<String> result = restTemplate.postForEntity(createUserUrl, user, String.class);
        if (result.getStatusCodeValue() == 200) {
            return "login";
        } else {
            return "error";
        }
    }
    String respondCall;

    @PostMapping("/login")
    public String login(
    @RequestParam(name="username") String username, 
    @RequestParam(name="password") String password, Model model) {
        try {
            // request url
            String url = "http://localhost:8080/login";
        
            // create auth credentials
            String authStr = username + ":" + password;
            
        
            // create headers
            HttpHeaders headers = new HttpHeaders();
            headers.setBasicAuth(Base64.getEncoder().encodeToString(authStr.getBytes()));
            
            // create request
            HttpEntity request = new HttpEntity(headers);
        
            // make a request
            ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.POST, request, String.class);
            respondCall = response.getBody();
            System.out.println(respondCall);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return respondCall;
    }
    
}
