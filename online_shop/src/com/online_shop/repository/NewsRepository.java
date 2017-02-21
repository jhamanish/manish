package com.online_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online_shop.model.New;

@Repository
public interface NewsRepository extends JpaRepository<New, Integer> {

}
