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

@Entity(name = "Child")
@Table(name = "\"Child\"", schema =  "\"meetupsv13\"")
@Data
                        
public class Child {
	public Child () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"ChildId\"", nullable = true )
  private Integer childId;
	  
  @Column(name = "\"Name\"", nullable = true )
  private String name;
  
	  
  @Column(name = "\"DateOfBirth\"", nullable = true )
  @Temporal(value = TemporalType.DATE)
  private Date dateOfBirth;  
  
	  
  @Column(name = "\"ProfileName\"", nullable = true )
  private String profileName;
  
	  
	
	@Column(name = "\"ChildInterest\"")
	@ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(schema = "\"meetupsv13\"", name = "\"ChildChildInterest\"",joinColumns = @JoinColumn(name = "\"ChildId\""))
    @Convert(converter = InterestEnumConverter.class)
    private List<InterestEnum> childInterest = new ArrayList<>();
	  
  @Column(name = "\"Gender\"", nullable = true)
  @Enumerated(value = EnumType.ORDINAL)
  @Convert(converter = GenderConverter.class)
  private Gender gender;
  
	  
  @Column(name = "\"AvatarName\"", nullable = true )
  private String avatarName;
  
	  
  @Column(name = "\"CreatedDate\"", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date createdDate;  
  
  
  
  
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"ChildChildProfilePhoto\"", referencedColumnName = "\"DocId\"", insertable = false, updatable = false)
	private Document childProfilePhoto;
	
	@Column(name = "\"ChildChildProfilePhoto\"")
	private Integer childChildProfilePhoto;
   
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Child [" 
  + "ChildId= " + childId  + ", " 
  + "Name= " + name  + ", " 
  + "DateOfBirth= " + dateOfBirth  + ", " 
  + "ProfileName= " + profileName  + ", " 
  + "ChildInterest= " + childInterest  + ", " 
  + "Gender= " + gender  + ", " 
  + "AvatarName= " + avatarName  + ", " 
  + "CreatedDate= " + createdDate 
 + "]";
	}
	
}