package com.wishalpha.priyanshu.TaskManagementSystem.dtos.requestDTO;

public class EmployeeUpdateRequestDTO {
    private String name;

    private String address;

    private Long phoneNumber;

    private Long altPhoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getAltPhoneNumber() {
        return altPhoneNumber;
    }

    public void setAltPhoneNumber(Long altPhoneNumber) {
        this.altPhoneNumber = altPhoneNumber;
    }



}
