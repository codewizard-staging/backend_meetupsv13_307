package com.app.meetupsv13.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum Lang{
	    English,
	    Spanish,
	    Hindi,
	    French; 
    public int value(Lang lang) {
        return lang.ordinal();
    }
    public static Lang getLang(int ordinal) {
        for(Lang lang : Lang.values())
                if(lang.ordinal() == ordinal)
                        return lang;
        return null;
    }
}


