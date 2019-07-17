package com.tw.apistackbase;


import com.tw.apistackbase.entity.CrownCase;
import com.tw.apistackbase.entity.Procuratorate;
import com.tw.apistackbase.repo.CrownCaseRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CrownCaseTest {

    @Autowired
    private CrownCaseRepository caseRepository;

    @Test
    public void test_add_case() {
        Procuratorate procuratorate = new Procuratorate("A检察院");

        CrownCase crownCase = new CrownCase();
        crownCase.setCaseName("潮阳区2次").setHappenTime(new Date()).setProcuratorate(procuratorate);

        CrownCase savedCase = caseRepository.saveAndFlush(crownCase);

        Assertions.assertNotNull(caseRepository.findById(savedCase.getId()));
    }

    @Test
    public void test_findAll_OrderBy_Time() {
        List<CrownCase> happen_time = caseRepository.findAll(new Sort(Sort.Direction.ASC, "happenTime"));
        System.out.println(happen_time.toString());
    }

    @Test
    public void test_findAll_By_Name() {
        List<CrownCase> result = caseRepository.findAllByCaseName("潮阳区贿赂2次");
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void test_delete_By_Id() {
        List<CrownCase> before = caseRepository.findAll();
        caseRepository.deleteById(3l);
        List<CrownCase> after = caseRepository.findAll();
        Assertions.assertSame(1, before.size()-after.size());
    }

    @Test
    public void should_get_CrownCase_when_get_detail_ID() {
//        CrownDetail crownDetail = new CrownDetail("长村案件-主观信息A", "长村案件-客观信息A");
//        CrownCase crownCase = new CrownCase("长村案件");
//        crownCase.setHappenTime(new Date());
//        crownCase.setCrownDetail(crownDetail);
//
//        caseRepository.saveAndFlush(crownCase);

        CrownCase byCrownDetail_id = caseRepository.findByCrownDetail_Id(2l);
        Assertions.assertNotNull(byCrownDetail_id);

        CrownCase crownCase = caseRepository.findById(1l).get();
        Assertions.assertNotNull(crownCase);
    }
}
