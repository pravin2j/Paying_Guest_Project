package com.pj.paying_guest_project.dto;

public enum PropertyType {
    HOUSE("House"),
    APARTMENT("Apartment"),
    HOSTEL("Hostel"),
    OTHER("Other");

    private final String value;

    PropertyType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}