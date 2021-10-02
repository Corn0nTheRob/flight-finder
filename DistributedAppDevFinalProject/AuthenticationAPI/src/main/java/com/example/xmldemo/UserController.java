package com.example.xmldemo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
 
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User newUser) throws IOException
    {   
    	UserUtil.registerUser(newUser);
    	return  ResponseEntity.ok("success");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestHeader(value="Authorization") String loginUser) throws IOException
    {   
        
        if (loginUser != null && loginUser.toLowerCase().startsWith("basic")) {
            // Authorization: Basic base64credentials
            String base64Credentials = loginUser.substring("Basic".length()).trim();
            byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(credDecoded, StandardCharsets.UTF_8);
            // credentials = username:password
            final String[] values = credentials.split(":", 2);
            System.out.println( values[0] + " " + values[1]);
            //get list of users
            List<User> userList = UserUtil.readUsers();

            for (User user : userList) {
            //If the entered username matches an entry in the xml check for password match.    
                if (user.getUsername().equals(values[0]) & user.getPassword().equals(values[1])) {
                System.out.println("success!");
                return  ResponseEntity.ok("flightsearch");
                }
            }
            
        }
        return  ResponseEntity.ok("login");
    }
}
