package com.tw.apistackbase.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Procuratorate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(length = 50, unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procuratorate", fetch = FetchType.EAGER)
    private List<CrownCase> cases;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procuratorate")
    private List<Prosecutor> prosecutors;

    public Procuratorate(@NotNull String name) {
        this.name = name;
    }


}
