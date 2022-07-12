package com.example.demo.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Contact implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Date dob;
	private int age;
	private String email;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	public Contact(){
		id=0;
	}
}