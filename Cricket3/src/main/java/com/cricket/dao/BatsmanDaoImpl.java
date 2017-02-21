package com.cricket.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.cricket.model.Batsman;

@Repository("batsmandao")
public class BatsmanDaoImpl extends AbstractDao<Serializable, Batsman> implements BatsmanDao {

	public Batsman addBatsman(Batsman batsman) {
		persist(batsman);
		return null;
	}

	public List<Batsman> findAllBatsmans() {
		Criteria criteria = createEntityCriteria();
		return (List<Batsman>) criteria.list();
	}

	public Batsman findBycustomerId(int id) 
	{
		Criteria criteria = createEntityCriteria();
		// TODO Auto-generated method stub
		return null;
	}

}
