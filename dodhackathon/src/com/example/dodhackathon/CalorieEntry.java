package com.example.dodhackathon;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public class CalorieEntry extends GenericJson {
	@Key
	private String _id;
	@Key
	private String userId;
	@Key 
	private String date;
	@Key
	private String activityLevel;
	@Key 
	private double calories;
	public String getId() {
		return _id;
	}
	public void setId(String id) {
		this._id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getCalories() {
		return calories;
	}
	public void setCalories(double calories) {
		this.calories = calories;
	}
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
}
