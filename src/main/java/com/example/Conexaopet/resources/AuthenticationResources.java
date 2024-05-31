package com.example.Conexaopet.resources;

import com.example.Conexaopet.domain.Ongs;
import com.example.Conexaopet.dtos.LoginDTO;
import com.example.Conexaopet.dtos.LoginResponseDTO;
import com.example.Conexaopet.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class AuthenticationResources {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping()
    public ResponseEntity login(@RequestBody LoginDTO data){
        var userPassword = new UsernamePasswordAuthenticationToken(data.email() , data.password());
        var auth = this.authenticationManager.authenticate(userPassword);

        var token = tokenService.generateToken((Ongs) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
