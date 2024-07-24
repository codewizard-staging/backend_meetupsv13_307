package com.app.meetupsv13.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum Status{
	    Started,
	    Passed,
	    OnGoing,
	    NotStarted,
	    Draft,
	    Submitted,
	    Approved; 
    public int value(Status status) {
        return status.ordinal();
    }
    public static Status getStatus(int ordinal) {
        for(Status status : Status.values())
                if(status.ordinal() == ordinal)
                        return status;
        return null;
    }
}


