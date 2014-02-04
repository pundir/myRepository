package com.pundir.location.model;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2575459973862042611L;

}