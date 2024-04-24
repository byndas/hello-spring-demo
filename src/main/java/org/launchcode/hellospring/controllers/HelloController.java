package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

	//	@ annotates http-request type
//	handles request to path /hello/bye
	@GetMapping("bye")
	@ResponseBody
	public String bye() {
		return "Bye, Spring!";
	}

	//	handles query string requests
//	  to "/hello?name=anyNameYouWriteHere"
	@ResponseBody
	public String helloWithQueryParam(@RequestParam String name) {
		return "Hello, " + name + "!";
	}

	//	handles requests to "/hello/LaunchCode" requests
//	@GetMapping("hello/{name}")
	@GetMapping("{name}")
	@ResponseBody
	public String helloWithPathParam(@PathVariable String name) {
		return "Hello, " + name + "!";
	}

	@GetMapping("form")
	@ResponseBody
	public String helloForm() {
		return "<html>" +
				"<body>" +
				"<form action='hello' method='post'>" + //submit request to /hello
				"<input type='text name='name' />" +
				"<input type='submit' value='Greet me!' />" +
				"</form>" +
				"</body>" +
				"</html>";
	}


///////////////////////////////////////////////////////////////////////
/*
Modify HelloController class to display a form on a GET request
	ask user for their name & their preferred language

Greeting Form: submission returns & displays “Bonjour Chris”

show language options in dropdown menu

When user submits form via POST request
	greet them in their selected language

	include five languages, default English
	in HelloController,
		public static createMessage(String name, String language)
		   { display & return language+" "+name }
*/

	@RequestMapping(value = "hello", method = RequestMethod.POST)
	@ResponseBody
	public String helloPost(@RequestParam String name, @RequestParam String language) {
		if (name == null) {
			name = "World";
		}

		return createMessage(name, language);
		// bonus mission: prettify this response string HTML
	}

	public static String createMessage(String n, String l) {
		String greeting = "";

		if (l.equals("english")) {
			greeting = "Hello";
		} else if (l.equals("french")) {
			greeting = "Bonjour";
		} else if (l.equals("italian")) {
			greeting = "Bonjourno";
		} else if (l.equals("spanish")) {
			greeting = "Hola";
		} else if (l.equals("german")) {
			greeting = "Hallo";
		}

		return greeting + " " + n;
	}
}