package com.app.meetupsv13.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum Gender{
	    DONTWANTTODISCLOSE,
	    MALE,
	    FEMALE; 
    public int value(Gender gender) {
        return gender.ordinal();
    }
    public static Gender getGender(int ordinal) {
        for(Gender gender : Gender.values())
                if(gender.ordinal() == ordinal)
                        return gender;
        return null;
    }
}


