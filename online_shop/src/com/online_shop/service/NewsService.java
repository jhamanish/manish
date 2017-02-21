package com.online_shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_shop.model.New;
import com.online_shop.repository.NewsRepository;

@Service
public class NewsService {

	@Autowired
	NewsRepository newsRepository;

	public New saveContentsInDB(List<String> contents) {

		New dbcontent = new New();
		if (contents != null) {

			dbcontent.setHeadline(contents.get(0));
			dbcontent.setContent(contents.get(1));
			dbcontent.setImagePath(contents.get(2));
		}

		return newsRepository.save(dbcontent);

	}

	public List<New> getAllNews() {
		List<New> list = newsRepository.findAll();
		System.out.println(list.get(0).getImagePath());
		return list;
	}

}
