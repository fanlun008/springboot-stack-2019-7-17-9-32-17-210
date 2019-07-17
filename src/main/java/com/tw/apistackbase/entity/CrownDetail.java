package com.tw.apistackbase.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class CrownDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column
    private String objectiveFactor;

    @Column
    private String subjectiveFactor;

    public CrownDetail(@NotNull String objectiveFactor, String subjectiveFactor) {
        this.objectiveFactor = objectiveFactor;
        this.subjectiveFactor = subjectiveFactor;
    }
}
