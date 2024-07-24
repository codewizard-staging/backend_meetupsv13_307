package com.app.meetupsv13.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum InterestEnum{
	    Football,
	    Travel,
	    Food,
	    Reading,
	    Fitness; 
    public int value(InterestEnum interestEnum) {
        return interestEnum.ordinal();
    }
    public static InterestEnum getInterestEnum(int ordinal) {
        for(InterestEnum interestEnum : InterestEnum.values())
                if(interestEnum.ordinal() == ordinal)
                        return interestEnum;
        return null;
    }
}


