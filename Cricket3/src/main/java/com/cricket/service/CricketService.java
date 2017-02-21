package com.cricket.service;

import java.util.List;

import com.cricket.model.Batsman;
import com.cricket.model.Bowler;

public interface CricketService {
	
	Batsman addBatsman(Batsman batsman);
	Bowler addBowler(Bowler bowler);
	List<Batsman> findAllBatsmans();
	List<Bowler> findAllBowlers();
}
