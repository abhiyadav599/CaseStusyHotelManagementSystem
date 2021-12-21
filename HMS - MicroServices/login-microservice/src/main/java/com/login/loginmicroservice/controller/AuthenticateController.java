package com.login.loginmicroservice.controller;

import com.login.loginmicroservice.config.JwtUtils;
import com.login.loginmicroservice.model.JwtRequest;
import com.login.loginmicroservice.model.JwtResponse;
import com.login.loginmicroservice.model.User;
import com.login.loginmicroservice.service.UserDetailServiceImpl;
import com.netflix.servo.monitor.StepCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private JwtUtils jwtUtils;

    //generate token
    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("user not found");
        }
        //authenticate
        UserDetails userDetails = this.userDetailService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
            return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try
        {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException e){
            throw new Exception("user disbaled"+e.getMessage());
        }catch (BadCredentialsException e){
            throw new Exception("invalid cred"+e.getMessage());

        }
    }

    //return details of current user
    @GetMapping("/current-user")
    private User getCurrentUser(Principal principal){
        return ((User) this.userDetailService.loadUserByUsername(principal.getName()));
    }

}
