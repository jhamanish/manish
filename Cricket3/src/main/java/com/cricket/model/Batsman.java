package com.cricket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="batsman")
public class Batsman {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="batting_style")
	private String batting_style;
	@Column(name="runs")
	private int runs;
	@Column(name="maidens")
	private int maidens;
	@Column(name="balls")
	private int balls;
	@Column(name="4s")
	private int fours;
	@Column(name="6s")
	private int sixes;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBatting_style() {
		return batting_style;
	}
	public void setBatting_style(String batting_style) {
		this.batting_style = batting_style;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getMaidens() {
		return maidens;
	}
	public void setMaidens(int maidens) {
		this.maidens = maidens;
	}
	public int getBalls() {
		return balls;
	}
	public void setBalls(int balls) {
		this.balls = balls;
	}
	public int getFours() {
		return fours;
	}
	public void setFours(int fours) {
		this.fours = fours;
	}
	public int getSixes() {
		return sixes;
	}
	public void setSixes(int sixes) {
		this.sixes = sixes;
	}
	

}
