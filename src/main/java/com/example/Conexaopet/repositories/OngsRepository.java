package com.example.Conexaopet.repositories;

import com.example.Conexaopet.domain.Ongs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface OngsRepository extends JpaRepository<Ongs,String> {
    UserDetails findByEmail(String email);
}
