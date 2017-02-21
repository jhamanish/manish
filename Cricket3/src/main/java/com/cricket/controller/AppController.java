package com.cricket.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cricket.model.Batsman;
import com.cricket.model.Bowler;
import com.cricket.service.CricketService;

@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	CricketService service;
	
	List<Batsman> bat=null;
	List<Bowler> bowler=null;
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String index()
	{
		return "index";
	}
	@RequestMapping(value={"/batsman"}, method=RequestMethod.GET)
	public String batsman(Model model)
	{
		return "addbatsman";
		
	}
	@RequestMapping(value={"/bowler"}, method=RequestMethod.GET)
	public String bowler(Model model)
	{
		return "addbowler";
		
	}
	@RequestMapping(value={"/addbatsman"}, method=RequestMethod.GET)
	public String addbatsman(Model model,HttpServletRequest req,HttpServletResponse res)
	{
		String name=req.getParameter("name");
		String batting_style=req.getParameter("batting_style");
		int runs=Integer.parseInt(req.getParameter("runs"));
		int maidens=Integer.parseInt(req.getParameter("maidens"));
		int balls=Integer.parseInt(req.getParameter("balls"));
		int fours=Integer.parseInt(req.getParameter("fours"));
		int sixes=Integer.parseInt(req.getParameter("sixes"));
		Batsman b=new Batsman();
		b.setName(name);
		b.setBatting_style(batting_style);
		b.setRuns(runs);
		b.setMaidens(maidens);
		b.setBalls(balls);
		b.setFours(fours);
		b.setSixes(sixes);
		service.addBatsman(b);
		bat=service.findAllBatsmans();
		bowler=service.findAllBowlers();
		model.addAttribute("bat", bat);
		model.addAttribute("bowler", bowler);
		return "Details";
		
	}
	
	@RequestMapping(value={"/addbowler"}, method=RequestMethod.GET)
	public String addbowler(Model model,HttpServletRequest req,HttpServletResponse res)
	{
		String name=req.getParameter("name");
		System.out.println(name);
		String bowling_style=req.getParameter("bowling_style");
		System.out.println(bowling_style);
		int runs=Integer.parseInt(req.getParameter("runs"));
		System.out.println(runs);
		int maidens=Integer.parseInt(req.getParameter("maidens"));
		System.out.println(maidens);
		int balls=Integer.parseInt(req.getParameter("balls"));
		System.out.println(balls);
		int overs=Integer.parseInt(req.getParameter("overs"));
		System.out.println(overs);
		int fours=Integer.parseInt(req.getParameter("fours"));
		System.out.println(fours);
		int sixes=Integer.parseInt(req.getParameter("sixes"));
		System.out.println(sixes);
		int wides=Integer.parseInt(req.getParameter("wides"));
		System.out.println(wides);
		int noballs=Integer.parseInt(req.getParameter("noballs"));
		System.out.println(noballs);
		int wickets=Integer.parseInt(req.getParameter("wickets"));
		System.out.println(wickets);
		int economy=Integer.parseInt(req.getParameter("economy"));
		System.out.println(economy);
		
		
		Bowler bow=new Bowler();
		bow.setName(name);
		bow.setBowling_style(bowling_style);
		bow.setRuns(runs);
		bow.setMaidens(maidens);
		bow.setBalls(balls);
		bow.setOvers(overs);
		bow.setFours(fours);
		bow.setSixes(sixes);
		bow.setNoballs(noballs);
		bow.setWides(wides);
		bow.setWickets(wickets);
		bow.setEconomy(economy);
		
		System.out.println();
		
		service.addBowler(bow);
		bat=service.findAllBatsmans();
		bowler=service.findAllBowlers();
		model.addAttribute("bat", bat);
		model.addAttribute("bowler", bowler);
		
		return "Details";
		
	}

}
