package com.pundir.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pundir.location.model.LocationMapping;

@Repository
public interface CommonRepository extends
		JpaRepository<LocationMapping, Integer> {

	@Query(value = "select c.addvert from Notifications c ,LocationMapping l  where c.id=l.id and l.latitute= :lati and l.longitute= :longi")
	public String findBylatlong(@Param("lati") String lati,
			@Param("longi") String longi);

}
