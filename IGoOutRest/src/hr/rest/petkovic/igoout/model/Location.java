package hr.rest.petkovic.igoout.model;

import hr.rest.petkovic.igoout.Constants;
import hr.rest.petkovic.igoout.db.SimpleMySQLResult;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Location {
	private int id;
	private String type;
	private String name;
	private String address;
	private double lng;
	private double lat;
	private String phoneNumber;
	private String workingHours;
	private String summary;
	private String website;
	private int[] events;
	private int[] interests;
	private String pictureUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int[] getEvents() {
		return events;
	}

	public void setEvents(int[] events) {
		this.events = events;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public int[] getInterests() {
		return interests;
	}

	public void setInterests(int[] interests) {
		this.interests = interests;
	}

	public static Location getLocationFromResult(SimpleMySQLResult result) {
		Location location = new Location();
		location.setAddress(result.getString("address"));
		location.setId(Integer.valueOf(result.getString("id")));
		location.setLat(Double.valueOf(result.getString("latitude")));
		location.setLng(Double.valueOf(result.getString("longitude")));
		location.setName(result.getString("name"));
		location.setPhoneNumber(result.getString("phone"));
		location.setPictureUrl(Constants.LIVE_URL + Constants.IMAGES_FOLDER + result.getString("picture_url"));
		location.setSummary(result.getString("summary"));
		location.setType(result.getString("type"));
		location.setWebsite(result.getString("website"));
		location.setWorkingHours(result.getString("hours"));
		return location;
	}
}
