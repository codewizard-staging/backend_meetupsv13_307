package com.app.meetupsv13.model;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


 
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
import com.app.meetupsv13.converter.DurationConverter;
import com.app.meetupsv13.converter.UUIDToByteConverter;
import com.app.meetupsv13.converter.UUIDToStringConverter;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Duration;
import java.util.Date;
import java.sql.Timestamp;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Lob;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmMediaStream;

@Entity(name = "Group")
@Table(name = "\"Group\"", schema =  "\"meetupsv13\"")
@Data
                        
public class Group {
	public Group () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"GroupId\"", nullable = true )
  private Integer groupId;
	  
  @Column(name = "\"GroupName\"", nullable = true )
  private String groupName;
  
	  
	
	@Column(name = "\"Interests\"")
	@ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(schema = "\"meetupsv13\"", name = "\"GroupInterests\"",joinColumns = @JoinColumn(name = "\"GroupId\""))
    @Convert(converter = InterestEnumConverter.class)
    private List<InterestEnum> interests = new ArrayList<>();
	  
  @Column(name = "\"Pincode\"", nullable = true )
  private Long pincode;
  
  
  
  
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"GroupOwner\"", referencedColumnName = "\"UserId\"", insertable = false, updatable = false)
	private User owner;
	
	@Column(name = "\"GroupOwner\"")
	private Integer groupOwner;
   
	
@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"GroupMembers\"",
            joinColumns = @JoinColumn( name="\"GroupId\""),
            inverseJoinColumns = @JoinColumn( name="\"UserId\""), schema = "\"meetupsv13\"")
private List<User> members = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"GroupContacts\"",
            joinColumns = @JoinColumn( name="\"GroupId\""),
            inverseJoinColumns = @JoinColumn( name="\"UserId\""), schema = "\"meetupsv13\"")
private List<User> contacts = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Group [" 
  + "GroupId= " + groupId  + ", " 
  + "GroupName= " + groupName  + ", " 
  + "Interests= " + interests  + ", " 
  + "Pincode= " + pincode 
 + "]";
	}
	
}