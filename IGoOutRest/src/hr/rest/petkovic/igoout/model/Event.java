package hr.rest.petkovic.igoout.model;

import hr.rest.petkovic.igoout.Constants;
import hr.rest.petkovic.igoout.db.SimpleMySQLResult;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Event {
	private int id;
	private int locationId;
	private String name;
	private String startTime;
	private String summary;
	private String detailsUrl;
	private String pictureUrl;
	private String interest;
	private float ratingAvg;
	private int[] comments;
	private int[] assignedInterest;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDetailsUrl() {
		return detailsUrl;
	}

	public void setDetailsUrl(String detailsUrl) {
		this.detailsUrl = detailsUrl;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public float getRatingAvg() {
		return ratingAvg;
	}

	public void setRatingAvg(float ratingAvg) {
		this.ratingAvg = ratingAvg;
	}

	public int[] getComments() {
		return comments;
	}

	public void setComments(int[] comments) {
		this.comments = comments;
	}

	public int[] getAssignedInterest() {
		return assignedInterest;
	}

	public void setAssignedInterest(int[] assignedInterest) {
		this.assignedInterest = assignedInterest;
	}
	

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public static Event getEventFromResult(SimpleMySQLResult result) {
		Event event = new Event();
		event.setDetailsUrl(result.getString("website"));
		event.setId(Integer.valueOf(result.getString("id")));
		event.setLocationId(Integer.valueOf(result.getString("location_id")));
		event.setName(result.getString("name"));
		event.setPictureUrl(Constants.LIVE_URL + Constants.IMAGES_FOLDER + result.getString("picture_url"));
		event.setRatingAvg(Float.valueOf(result.getString("rating")));
		event.setStartTime(result.getString("start_time"));
		event.setSummary(result.getString("summary"));
		event.setInterest(result.getString("interests"));
		return event;
	}

}
