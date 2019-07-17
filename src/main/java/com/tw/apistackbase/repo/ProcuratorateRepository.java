package com.tw.apistackbase.repo;

import com.tw.apistackbase.entity.Procuratorate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcuratorateRepository extends JpaRepository<Procuratorate, Long> {
//    Procuratorate findByName(String name);
}
