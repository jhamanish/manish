package com.online_shop.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.online_shop.model.New;
import com.online_shop.service.NewsService;

@Controller
public class NewsController {

	@Autowired
	NewsService newsService;
	
	@GetMapping("/")
	public String getHomePage(Model model){
		return "newHomePage";
	}

	@GetMapping("/seeNews")
	public String getGoogleHomePage(Model model) {

		final String FILENAME = "E:\\Office Assignments\\URS Systems\\News\\newsFile.txt";
		List<String> contents = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				contents.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(contents.size());
		New news =newsService.saveContentsInDB(contents);
		if(news !=null){
			System.out.println("Data Saved");
		} else {
			System.out.println("Data  Not Saved.");
		}
		List<New> newsList = newsService.getAllNews();
		
		model.addAttribute("newsList", newsList);
		return "googleNews";
	}
}
