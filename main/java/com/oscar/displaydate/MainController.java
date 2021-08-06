package com.oscar.displaydate;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	
	@RequestMapping("")
	public String index() {
		return "home.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date today = Calendar.getInstance().getTime();
		DateFormat daynamef = new SimpleDateFormat("EEEE");
		DateFormat daynumf = new SimpleDateFormat("dd");
		DateFormat monthf = new SimpleDateFormat("MMMM");
		DateFormat yearf = new SimpleDateFormat("yyyy");
		String dayName = daynamef.format(today);
		String dayNum = daynumf.format(today);
		String month = monthf.format(today);
		String year = yearf.format(today);
		model.addAttribute("dayName", dayName);
		model.addAttribute("dayNum", dayNum);
		model.addAttribute("month", month);
		model.addAttribute("year", year);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		Date today = Calendar.getInstance().getTime();
		DateFormat df = new SimpleDateFormat("hh:mm aa");
		String time = df.format(today);
		model.addAttribute("time", time);
		return "time.jsp";
	}

}
