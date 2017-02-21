package com.cricket.dao;

import java.util.List;

import com.cricket.model.Batsman;

public interface BatsmanDao {
	
	Batsman addBatsman(Batsman batsman);
	List<Batsman> findAllBatsmans();
	 public  Batsman findBycustomerId(int id);

}
