package com.pundir.location.restapi;

import java.text.SimpleDateFormat;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pundir.location.dto.NotificationRequest;
import com.pundir.location.dto.NotificationResponse;
import com.pundir.location.services.LocationBaseServices;

@Component
@Path("/getAds")
public class LocationBaseNotification {

	private static final String PATTERN = "dd-mm-yy";
	@Autowired
	LocationBaseServices services;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/asjson")
	public NotificationResponse getNotificationJSON(NotificationRequest request) {
		NotificationResponse notification = new NotificationResponse();
		notification.setAdvertText(services.getAdvertisement(
				request.getLatitute(), request.getLongitute()));
		return notification;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/asjson/test")
	public NotificationResponse getTimeOfTheDayInJSON() {
		SimpleDateFormat df = new SimpleDateFormat(PATTERN);
		NotificationResponse notification = new NotificationResponse();
		notification.setAdvertText(services.getAdvertisement(1000 + "",
				2000 + ""));
		return notification;
	}
}