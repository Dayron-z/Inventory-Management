package com.inventory.management.domain.entities;

public class Supplier {
    private Long id;
    private String name;
    private String contactName;
    private String address;
    private String email;
    private String phone;

    public Supplier(Long id, String name, String contactName, String address, String email, String phone) {
        this.id = id;
        this.name = name;
        this.contactName = contactName;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public Supplier() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

