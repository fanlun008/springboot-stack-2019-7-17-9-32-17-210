package com.tw.apistackbase;


import com.tw.apistackbase.entity.CrownDetail;
import com.tw.apistackbase.repo.CrownDetailRepository;
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
public class CrownDetailTest {

    @Autowired
    private CrownDetailRepository detailRepository;

    @Test
    public void test_find_By_ID(){
        CrownDetail crownDetail = detailRepository.findById(2l).get();
        Assertions.assertNotNull(crownDetail);
    }
}
