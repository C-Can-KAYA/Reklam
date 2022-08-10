package com.lastSoftware.FirstProfessionalProject.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Hat {
    ISTANBUL("Kadıköy Kartal","Gebze Harem","Kadıköy Maltepe");
    private final List<String> members;
    public List<String> getMembers(){
        return new ArrayList<String>(members);
    }
    private Hat(String... members){
        this.members= Arrays.asList(members);
    }
}
