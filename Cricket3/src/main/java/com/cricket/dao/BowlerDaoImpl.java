package com.cricket.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.cricket.model.Bowler;

@Repository("boelerdao")
public class BowlerDaoImpl extends AbstractDao<Serializable, Bowler> implements BowlerDao{

	public Bowler addBowler(Bowler bowler) {
		persist(bowler);
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Bowler> findAllBowlers() {
		
		Criteria criteria = createEntityCriteria();
		return (List<Bowler>) criteria.list();
	}
	

}
