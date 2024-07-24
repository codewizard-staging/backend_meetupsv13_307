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

@Entity(name = "Event")
@Table(name = "\"Event\"", schema =  "\"meetupsv13\"")
@Data
                        
public class Event {
	public Event () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"EventId\"", nullable = true )
  private Integer eventId;
	  
  @Column(name = "\"Title\"", nullable = true )
  private String title;
  
	  
  @Column(name = "\"StartDate\"", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date startDate;  
  
	  
  @Column(name = "\"StartTime\"", nullable = true )
  private Time startTime;
  
	  
  @Column(name = "\"Description\"", nullable = true )
  private String description;
  
	  
  @Column(name = "\"Venue\"", nullable = true )
  private String venue;
  
	  
  @Column(name = "\"EndDate\"", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date endDate;  
  
	  
  @Column(name = "\"EndDateTime\"", nullable = true )
  private Time endDateTime;
  
	  
  @Column(name = "\"Website\"", nullable = true )
  private String website;
  
	  
  @Column(name = "\"PrimaryInterest\"", nullable = true)
  @Enumerated(value = EnumType.ORDINAL)
  @Convert(converter = InterestEnumConverter.class)
  private InterestEnum primaryInterest;
  
	  
	
	@Column(name = "\"OtherInterests\"")
	@ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(schema = "\"meetupsv13\"", name = "\"EventOtherInterests\"",joinColumns = @JoinColumn(name = "\"EventId\""))
    @Convert(converter = InterestEnumConverter.class)
    private List<InterestEnum> otherInterests = new ArrayList<>();
	  
  @Column(name = "\"IsFree\"", nullable = true )
  private Boolean isFree;
  
	  
  @Column(name = "\"Status\"", nullable = true)
  @Enumerated(value = EnumType.ORDINAL)
  @Convert(converter = StatusConverter.class)
  private Status status;
  
	  
  @Column(name = "\"EventLink\"", nullable = true )
  private String eventLink;
  
	  
  @Column(name = "\"Pincode\"", nullable = true )
  private Long pincode;
  
	  
  @Column(name = "\"MapLink\"", nullable = true )
  private String mapLink;
  
	  
  @Column(name = "\"City\"", nullable = true )
  private String city;
  
	  
  @Column(name = "\"Cost\"", nullable = true )
  private Double cost;
  
  
  
  
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"EventMainImage\"", referencedColumnName = "\"DocId\"", insertable = false, updatable = false)
	private Document mainImage;
	
	@Column(name = "\"EventMainImage\"")
	private Integer eventMainImage;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"EventOrganiser\"", referencedColumnName = "\"UserId\"", insertable = false, updatable = false)
	private User organiser;
	
	@Column(name = "\"EventOrganiser\"")
	private Integer eventOrganiser;
   
	
@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"EventRegisteredUsers\"",
            joinColumns = @JoinColumn( name="\"EventId\""),
            inverseJoinColumns = @JoinColumn( name="\"UserId\""), schema = "\"meetupsv13\"")
private List<User> registeredUsers = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Event [" 
  + "EventId= " + eventId  + ", " 
  + "Title= " + title  + ", " 
  + "StartDate= " + startDate  + ", " 
  + "StartTime= " + startTime  + ", " 
  + "Description= " + description  + ", " 
  + "Venue= " + venue  + ", " 
  + "EndDate= " + endDate  + ", " 
  + "EndDateTime= " + endDateTime  + ", " 
  + "Website= " + website  + ", " 
  + "PrimaryInterest= " + primaryInterest  + ", " 
  + "OtherInterests= " + otherInterests  + ", " 
  + "IsFree= " + isFree  + ", " 
  + "Status= " + status  + ", " 
  + "EventLink= " + eventLink  + ", " 
  + "Pincode= " + pincode  + ", " 
  + "MapLink= " + mapLink  + ", " 
  + "City= " + city  + ", " 
  + "Cost= " + cost 
 + "]";
	}
	
}