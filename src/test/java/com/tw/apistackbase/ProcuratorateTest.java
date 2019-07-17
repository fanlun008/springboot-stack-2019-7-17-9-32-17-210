package com.tw.apistackbase;

import com.tw.apistackbase.entity.CrownCase;
import com.tw.apistackbase.entity.Procuratorate;
import com.tw.apistackbase.repo.CrownCaseRepository;
import com.tw.apistackbase.repo.ProcuratorateRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProcuratorateTest {

    @Autowired
    ProcuratorateRepository repository;

    @Autowired
    CrownCaseRepository crownCaseRepository;
    @Autowired
    ProcuratorateRepository procuratorateRepository;

    @Test
    public void should_throw_exception_when_add_crownCase_with_no_procuratorate() {
        Procuratorate procuratorate = new Procuratorate("检察院A");

        CrownCase crownCase = new CrownCase("检察院A-case2")
                .setHappenTime(new Date()).setProcuratorate(procuratorate);
        CrownCase result = crownCaseRepository.saveAndFlush(crownCase);
        Assertions.assertNotNull(result);

        CrownCase crownCase2 = new CrownCase("检察院A-case2")
                .setHappenTime(new Date());

        Assertions.assertThrows(DataIntegrityViolationException.class, ()->{crownCaseRepository.saveAndFlush(crownCase2);});
        System.out.println("--");

    }

    @Test
    public void test() {
        CrownCase crownCase = new CrownCase("检察院A-case3")
                .setHappenTime(new Date());
        Procuratorate procuratorate = procuratorateRepository.findById(2l).get();
        procuratorate.getCases().add(crownCase);
        procuratorateRepository.save(procuratorate);

    }

}
