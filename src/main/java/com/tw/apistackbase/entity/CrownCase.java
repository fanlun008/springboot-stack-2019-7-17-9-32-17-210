package com.tw.apistackbase.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class CrownCase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "case_name", nullable = false, length = 255)
    private String caseName;

    @Column(name = "happen_time", nullable = false)
    private Date happenTime;

    @OneToOne(cascade = CascadeType.ALL)
    private CrownDetail crownDetail;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Procuratorate procuratorate;

    public CrownCase(String caseName) {
        this.caseName = caseName;
    }
}
