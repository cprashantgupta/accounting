package com.accounting.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class ChildAccountBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long Id;

    // P or S
    @Column
    private char partyType;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private FirmDetailsBean firmDetailsBean;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private PrimaryAccountBean primaryAccountBean;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public FirmDetailsBean getFirmDetailsBean() {
        return firmDetailsBean;
    }

    public void setFirmDetailsBean(FirmDetailsBean firmDetailsBean) {
        this.firmDetailsBean = firmDetailsBean;
    }

    public char getPartyType() {
        return partyType;
    }

    public void setPartyType(char partyType) {
        this.partyType = partyType;
    }

    public PrimaryAccountBean getPrimaryAccountBean() {
        return primaryAccountBean;
    }

    public void setPrimaryAccountBean(PrimaryAccountBean primaryAccountBean) {
        this.primaryAccountBean = primaryAccountBean;
    }

    @Override
    public String toString() {
        return "ChildAccountBean{" +
                "Id=" + Id +
                ", firmDetailsBean=" + firmDetailsBean.toString() +
                '}';
    }
}
