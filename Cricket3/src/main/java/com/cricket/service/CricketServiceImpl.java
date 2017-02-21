package com.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cricket.dao.BatsmanDao;
import com.cricket.dao.BowlerDao;
import com.cricket.model.Batsman;
import com.cricket.model.Bowler;
@Service
@Transactional
public class CricketServiceImpl implements CricketService{
	@Autowired
	BatsmanDao batsmandao;
	@Autowired
	BowlerDao bowlerdao;

	public Batsman addBatsman(Batsman batsman) {
		batsmandao.addBatsman(batsman);
		return null;
	}

	public Bowler addBowler(Bowler bowler) {
		bowlerdao.addBowler(bowler);
		return null;
	}

	public List<Batsman> findAllBatsmans() {
		return batsmandao.findAllBatsmans();
	}

	public List<Bowler> findAllBowlers() {
		return bowlerdao.findAllBowlers();
	}

}
