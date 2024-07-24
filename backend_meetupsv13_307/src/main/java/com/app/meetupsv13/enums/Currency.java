package com.app.meetupsv13.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum Currency{
	    USD,
	    INR,
	    SGD; 
    public int value(Currency currency) {
        return currency.ordinal();
    }
    public static Currency getCurrency(int ordinal) {
        for(Currency currency : Currency.values())
                if(currency.ordinal() == ordinal)
                        return currency;
        return null;
    }
}


