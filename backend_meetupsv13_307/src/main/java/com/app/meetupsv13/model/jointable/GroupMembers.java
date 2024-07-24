package com.app.meetupsv13.model.jointable;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;
import lombok.Data;
import javax.persistence.*;

import com.app.meetupsv13.model.Child;
import com.app.meetupsv13.model.Interest;
import com.app.meetupsv13.model.Document;
import com.app.meetupsv13.model.User;
import com.app.meetupsv13.model.Event;
import com.app.meetupsv13.model.Group;
import com.app.meetupsv13.enums.Lang;
import com.app.meetupsv13.enums.InterestEnum;
import com.app.meetupsv13.enums.Currency;
import com.app.meetupsv13.enums.Gender;
import com.app.meetupsv13.enums.Status;
import com.app.meetupsv13.converter.LangConverter;
import com.app.meetupsv13.converter.InterestEnumConverter;
import com.app.meetupsv13.converter.StatusConverter;
import com.app.meetupsv13.converter.GenderConverter;
import com.app.meetupsv13.converter.CurrencyConverter;

@Entity(name = "GroupMembers")
@Table(schema = "\"meetupsv13\"", name = "\"GroupMembers\"")
@Data
public class GroupMembers{

 	@Id
    @Column(name = "\"Id\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "\"GroupId\"")
	private Integer groupId;

    
    @Column(name = "\"UserId\"")
    private Integer userId;
 
}