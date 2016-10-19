/*
 * 
 */
package com.kasisripriyawebapps.myindia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Network.
 */
@Entity
@Table(name = "NETWORK_MASTER")
public class Network implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6186755601604059003L;

	@Id
	@Column(name = "NETWORK_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

}
