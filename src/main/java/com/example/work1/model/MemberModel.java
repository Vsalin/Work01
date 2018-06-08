package com.example.work1.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@EntityListeners(AuditingEntityListener.class)// keep log file 
@Table(name = "work01") // create  new table 
@JsonIgnoreProperties(value= {"createdAt","updatedAt"},allowGetters=true)  //allowGetters get 2 value createdAt,updatedAt not use ID 
public class MemberModel implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto increment 
	private Long id ;

	@NotBlank
	private String firstname ;
	@NotBlank
	private String lastname ;
	@NotBlank
	private String username ;
	@NotNull
	private Integer password ;
	
	@Column(nullable=false,updatable=false)
	@Temporal(TemporalType.TIMESTAMP) //Timestamp for date,time 
	@CreatedDate
	private Date createDate;
	
	
	@Column(nullable=false,updatable=false)
	@Temporal(TemporalType.TIMESTAMP) //Timestamp for date,time 
	@LastModifiedDate
	private Date UpdateDate;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
