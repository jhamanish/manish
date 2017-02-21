package com.cricket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bowler")
public class Bowler {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="name")
	private String name;
	@Column(name="bowling_style")
	private String bowling_style;
	@Column(name="overs")
	private int overs;
	@Column(name="runs")
	private int runs;
	@Column(name="balls")
	private int balls;
	@Column(name="maidens")
	private int maidens;
	@Column(name="4s")
	private int fours;
	@Column(name="6s")
	private int sixes;
	@Column(name="noballs")
	private int noballs;
	@Column(name="wides")
	private int wides;
	@Column(name="wickets")
	private int wickets;
	@Column(name="economy")
	private int economy;
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
	public String getBowling_style() {
		return bowling_style;
	}
	public void setBowling_style(String bowling_style) {
		this.bowling_style = bowling_style;
	}
	public int getOvers() {
		return overs;
	}
	public void setOvers(int overs) {
		this.overs = overs;
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
	public int getNoballs() {
		return noballs;
	}
	public void setNoballs(int noballs) {
		this.noballs = noballs;
	}
	public int getWides() {
		return wides;
	}
	public void setWides(int wides) {
		this.wides = wides;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public int getEconomy() {
		return economy;
	}
	public void setEconomy(int economy) {
		this.economy = economy;
	}

}
