package com.sumedhahire.sumedhahire.Enums;


import java.io.Serializable;

public enum Gender  implements Serializable {
    Male,Female;

    public String getGender() {
        return this.name();
    }

}
