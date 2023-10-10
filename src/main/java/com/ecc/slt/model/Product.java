package com.ecc.slt.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pNumber")
    private int pNumber;
    @Column(name = "pName")
    private String pName;
    @Column(name = "scrumMaster")
    private String scrumMaster;
    @Column(name = "pOwner")
    private String pOwner;
    @Column(name = "pDevelopers")
    private String pDevelopers;
    @Column(name = "startDate")
    private String startDate;
    @Column(name = "githubLink")
    private String githubLink;
    @Column(name = "pMethodology")
    private String pMethodology;
}
