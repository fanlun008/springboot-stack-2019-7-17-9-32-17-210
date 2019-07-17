package com.tw.apistackbase;

import com.tw.apistackbase.entity.Procuratorate;
import com.tw.apistackbase.entity.Prosecutor;
import com.tw.apistackbase.repo.ProcuratorateRepository;
import com.tw.apistackbase.repo.ProsecutorRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProsecutorTest {

    @Autowired
    ProsecutorRepository prosecutorRepository;
    @Autowired
    ProcuratorateRepository procuratorateRepository;

    @Test
    public void save_Prosecutor_With_Procuratorate() {
        Procuratorate procuratorate = new Procuratorate("检察院B");

//        Prosecutor John = new Prosecutor("检察院B--John检察官").setProcuratorate(procuratorate);
        Prosecutor Bill = new Prosecutor("检察院B--Bill检察官").setProcuratorate(procuratorate);

//        prosecutorRepository.saveAndFlush(John);
        prosecutorRepository.saveAndFlush(Bill);

//        Assertions.assertSame(2, procuratorateRepository.findByName(procuratorate.getName()).getProsecutors().size());
    }
}
