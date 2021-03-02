package com.accounting.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class FirmDetailsBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long Id;

    @NotBlank(message = "Name can not be blank")
    @Size(min = 2, max = 100)
    @ApiModelProperty(notes = "Firm Name can not be NULL")
    @Column(nullable = false)
    private String firmName;

    @NotBlank(message = "Name can not be blank")
    @Size(min = 2, max = 100)
    @Column(nullable = false)
    private String firmOwner;

    @Column
    private Long contactNumber;

    @Column
    private String addressLine1;

    @Column
    private String addressLine2;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String pinCode;

    @Column
    private String country;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getFirmOwner() {
        return firmOwner;
    }

    public void setFirmOwner(String firmOwner) {
        this.firmOwner = firmOwner;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "FirmDetailsBean{" +
                "firmName='" + firmName + '\'' +
                ", firmOwner='" + firmOwner + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FirmDetailsBean that = (FirmDetailsBean) o;
        return firmName.equals(that.firmName) && firmOwner.equals(that.firmOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firmName, firmOwner);
    }
}
