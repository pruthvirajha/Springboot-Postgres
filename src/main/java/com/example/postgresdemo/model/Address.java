package com.example.postgresdemo.model;

import java.util.List;

public class Address {
    private String houseNo;
    private String street;
    private String city;
    private List<String> pincodes;
    private PhoneNumbers phoneNumbers;

    public PhoneNumbers getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public List<String> getPincodes() {
        return pincodes;
    }
}
