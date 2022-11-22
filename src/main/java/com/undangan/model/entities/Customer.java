package com.undangan.model.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname_man", length = 50)
    private String manFullName;

    @Column(name = "callname_man", length = 50)
    private String manCallName;

    @Column(name = "fathername_man", length = 50)
    private String manFatherName;

    @Column(name = "mothername_man", length = 50)
    private String manMotherName;

    @Column(name = "fullname_woman", length = 50)
    private String womanFullName;

    @Column(name = "callname_woman", length = 50)
    private String womancallName;

    @Column(name = "fathername_woman", length = 50)
    private String womanFatherName;

    @Column(name = "mothername_woman", length = 50)
    private String womanMotherName;

    @Column(name = "akad_date", length = 10)
    private String akadDate;

    @Column(name = "akad_address", length = 100)
    private String akadAddress;

    @Column(name = "resepsi_date", length = 10)
    private String resepsiDate;

    @Column(name = "resepsi_address", length = 100)
    private String resepsiAddress;

    @Column(name = "path", length = 100)
    private String path;

    @ManyToOne
	private Theme theme;

    public Customer() {
    }

    public Customer(Long id, String manFullName, String manCallName, String manFatherName, String manMotherName,
            String womanFullName, String womancallName, String womanFatherName, String womanMotherName, String akadDate,
            String akadAddress, String resepsiDate, String resepsiAddress, String path, Theme theme) {
        this.id = id;
        this.manFullName = manFullName;
        this.manCallName = manCallName;
        this.manFatherName = manFatherName;
        this.manMotherName = manMotherName;
        this.womanFullName = womanFullName;
        this.womancallName = womancallName;
        this.womanFatherName = womanFatherName;
        this.womanMotherName = womanMotherName;
        this.akadDate = akadDate;
        this.akadAddress = akadAddress;
        this.resepsiDate = resepsiDate;
        this.resepsiAddress = resepsiAddress;
        this.path = path;
        this.theme = theme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManFullName() {
        return manFullName;
    }

    public void setManFullName(String manFullName) {
        this.manFullName = manFullName;
    }

    public String getManCallName() {
        return manCallName;
    }

    public void setManCallName(String manCallName) {
        this.manCallName = manCallName;
    }

    public String getManFatherName() {
        return manFatherName;
    }

    public void setManFatherName(String manFatherName) {
        this.manFatherName = manFatherName;
    }

    public String getManMotherName() {
        return manMotherName;
    }

    public void setManMotherName(String manMotherName) {
        this.manMotherName = manMotherName;
    }

    public String getWomanFullName() {
        return womanFullName;
    }

    public void setWomanFullName(String womanFullName) {
        this.womanFullName = womanFullName;
    }

    public String getWomancallName() {
        return womancallName;
    }

    public void setWomancallName(String womancallName) {
        this.womancallName = womancallName;
    }

    public String getWomanFatherName() {
        return womanFatherName;
    }

    public void setWomanFatherName(String womanFatherName) {
        this.womanFatherName = womanFatherName;
    }

    public String getWomanMotherName() {
        return womanMotherName;
    }

    public void setWomanMotherName(String womanMotherName) {
        this.womanMotherName = womanMotherName;
    }

    public String getAkadDate() {
        return akadDate;
    }

    public void setAkadDate(String akadDate) {
        this.akadDate = akadDate;
    }

    public String getAkadAddress() {
        return akadAddress;
    }

    public void setAkadAddress(String akadAddress) {
        this.akadAddress = akadAddress;
    }

    public String getResepsiDate() {
        return resepsiDate;
    }

    public void setResepsiDate(String resepsiDate) {
        this.resepsiDate = resepsiDate;
    }

    public String getResepsiAddress() {
        return resepsiAddress;
    }

    public void setResepsiAddress(String resepsiAddress) {
        this.resepsiAddress = resepsiAddress;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    
    
    
}
