package com.barvegas.backend.Controller;

import com.barvegas.backend.Model.AuthRequest;
import com.barvegas.backend.Model.TokenDTO;
import com.barvegas.backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/auth")
    public TokenDTO generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                            authRequest.getUserName(),
                            Base64.getEncoder().encodeToString(authRequest.getPassword().getBytes())));
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }

        return TokenDTO.builder().token(jwtUtil.generateToken(authRequest.getUserName())).build();
    }

}
