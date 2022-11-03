package com.k8s.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "BIRIM_TEST")
public class Birim {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "AD")
    private String ad;

    @Column(name = "KOD")
    private String kod;

    @Column(name = "YIL")
    private Long yil;

    @Column(name = "TOP")
    private Long count;

}
