package com.example.dodhackathon;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public class Consumption extends GenericJson {
	@Key
	private String _id;
	@Key
	private String userId;
	@Key
	private String itemId;
	@Key
	private String date;
	@Key
	private String when;
	@Key
	private String category;
	@Key
	private String sex;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getItemID() {
		return itemId;
	}
	public void setItemID(String itemID) {
		this.itemId = itemID;
	}
	public String getTimeStamp() {
		return date;
	}
	public void setTimeStamp(String timeStamp) {
		this.date = timeStamp;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getWhen() {
		return when;
	}
	public void setWhen(String when) {
		this.when = when;
	}
	
	
}