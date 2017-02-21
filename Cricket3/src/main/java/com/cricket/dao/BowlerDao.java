package com.cricket.dao;

import java.util.List;

import com.cricket.model.Bowler;

public interface BowlerDao {

	Bowler addBowler(Bowler bowler);
	List<Bowler> findAllBowlers();
}
