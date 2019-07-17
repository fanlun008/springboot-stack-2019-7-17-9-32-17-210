package com.tw.apistackbase.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Prosecutor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    private Procuratorate procuratorate;

    public Prosecutor(@NotNull String name) {
        this.name = name;
    }
}
