package com.springApp.payload;

import jakarta.validation.constraints.*;

public class EmployeePayload {


    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min=2 , message = "name at least 2 charactor")
    private String name;

    @Email(message = "please enter valid email!")
    private String email;

    @Size(min=10 , max =10 , message = "please enter 10 digit mobile")
    private String mobile;
    private String city;
    private String state;
    private String addressLine;

    @NotNull
    @Min(value = 100000, message = "Pincode must be at least 6 digits")
    @Max(value = 999999, message = "Pincode must be at most 6 digits")
    private Long pincode;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }


}
