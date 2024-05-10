package com.example.Conexaopet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tutor extends JpaRepository<com.example.Conexaopet.domain.Tutor , String > {
}
