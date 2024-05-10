package com.example.Conexaopet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Address extends JpaRepository<com.example.Conexaopet.domain.Address , String> {
}
