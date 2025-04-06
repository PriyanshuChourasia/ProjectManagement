package com.wishalpha.priyanshu.TaskManagementSystem.enums;

public enum Gender {
    MALE("male"),
    FEMALE("female"),
    OTHERS("others"),
    PREFERNOTTOSAY("prefer not to say"),;


    private String lower;

    private Gender(String lower)
    {
        this.lower = lower;
    }
}
