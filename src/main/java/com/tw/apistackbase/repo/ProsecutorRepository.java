package com.tw.apistackbase.repo;

import com.tw.apistackbase.entity.Prosecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProsecutorRepository extends JpaRepository<Prosecutor, Long> {
}
