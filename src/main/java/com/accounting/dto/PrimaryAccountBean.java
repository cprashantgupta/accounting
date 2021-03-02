package com.accounting.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class PrimaryAccountBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long Id;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private FirmDetailsBean firmDetailsBean;

    @OneToMany(mappedBy = "primaryAccountBean")
    private List<ChildAccountBean> childAccountBeanList;

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

    public List<ChildAccountBean> getChildAccountBeanList() {
        return childAccountBeanList;
    }

    public void setChildAccountBeanList(List<ChildAccountBean> childAccountBeanList) {
        this.childAccountBeanList = childAccountBeanList;
    }

    @Override
    public String toString() {
        return "PrimaryAccountBean{" +
                "Id=" + Id +
                ", firmDetailsBean=" + firmDetailsBean.toString() +
                '}';
    }
}

