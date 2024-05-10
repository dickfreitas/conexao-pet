package com.example.Conexaopet.repositories;

import com.example.Conexaopet.domain.Ongs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OngsRepository extends JpaRepository<Ongs,String> {
}
