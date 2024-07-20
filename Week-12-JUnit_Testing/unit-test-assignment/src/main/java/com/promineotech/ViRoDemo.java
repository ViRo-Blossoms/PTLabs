package com.promineotech;

import java.util.ArrayList;
import java.util.List;

public class ViRoDemo {
	List<String> scaryUsers = new ArrayList<>(
	        List.of("Star_",
	        		"Pablo.gonzales.2007",
	        		"Weezy",
	        		"ClockwerkSmurf",
	        		"Soundsmith",
	        		"LazyPurple",
	        		"Uncle Dane",
	        		"Bing Soy",
	        		"Pulse",        		
	        		"hei",
	        		"Acooma",
	        		"DaFuQWiZaT",        		
	        		"Max",
	        		"sigafoo",
	        		"Meyy",
	        		"kaidus",
	        		"TLR",
	        		"mulaa",
	        		"ixy",
	        		"Toemas",
	        		"Domo",
	        		"Papi",
	        		"Silentes",
	        		"skeez",
	        		"laz",
	        		"highfive",
	        		"branslam",
	        		"artist",
	        		"ash",
	        		"zilly",
	        		"aim",
	        		"SOOOOOAPYMEiSTER",
	        		"kobe1920",
	        		"cap",
	        		"logan",
	        		"botmode",
	        		"marmaloo",
	        		"mirrorman",
	        		"Jayhyunpae",
	        		"habib",
	        		"kaptain",
	        		"arekk",
	        		"stark",
	        		"clockwork",
	                "yomps",
	                "b4nny"));

	public boolean isUserScary(String username) {
		if(scaryUsers.stream().anyMatch(e -> e.equalsIgnoreCase(username))) //Thank you baeldung for the .stream tips
		{
			System.out.println(username + " is scary! Take a flank route and do your best!");
			return true;
		}
		else if(username.isBlank())
		{
			System.out.println("You didn't type anything.");
			return false;
		}
		else
		{
			System.out.println(username + " isn't on my list. You should be fine, just keep on your guard!");
			return false;
		}
	} //IUS
}
