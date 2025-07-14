package org.example;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

@Embeddable
public class Address
{
    String houseNo;

    String lane;

    public Address() {
    }

    public Address(String houseNo, String lane) {
        this.houseNo = houseNo;
        this.lane = lane;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }
}
