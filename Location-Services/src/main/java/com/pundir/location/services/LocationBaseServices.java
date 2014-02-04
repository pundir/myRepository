package com.pundir.location.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pundir.location.repository.CommonRepository;

@Service
public class LocationBaseServices {

	@Autowired
	private CommonRepository repository;

	public String getAdvertisement(String lat, String longi) {
		return repository.findBylatlong(lat, longi);
	}

}
