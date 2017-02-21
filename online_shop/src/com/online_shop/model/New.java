package com.online_shop.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the news database table.
 * 
 */
@Entity
@Table(name="news")
@NamedQuery(name="New.findAll", query="SELECT n FROM New n")
public class New implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="headline_id")
	private int headlineId;

	private String content;

	private String headline;

	@Column(name="image_path")
	private String imagePath;

	public New() {
	}

	public int getHeadlineId() {
		return this.headlineId;
	}

	public void setHeadlineId(int headlineId) {
		this.headlineId = headlineId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHeadline() {
		return this.headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}