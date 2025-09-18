package com.sip.ams_rest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Address is mandatory")
    @Column(name = "address")
    private  String Address;

    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Address='" + Address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Provider(long id, String name, String address, String email) {
        this.id = id;
        this.name = name;
        Address = address;
        this.email = email;
    }

    public Provider() {
    }
}
