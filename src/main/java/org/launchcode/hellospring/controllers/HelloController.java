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
	public String bye() {
		return "Bye, Spring!";
	}

	//	handles query string requests
//	  to "/hello?name=anyNameYouWriteHere"
	public String helloWithQueryParam(@RequestParam String name) {
		return "Hello, " + name + "!";
	}

	//	handles requests to "/hello/LaunchCode" requests
//	@GetMapping("hello/{name}")
	@GetMapping("{name}")
	public String helloWithPathParam(@PathVariable String name) {
		return "Hello, " + name + "!";
	}

	@GetMapping("form")
	public String helloForm() {
		return
				"<html>" +
					"<body>" +
	//				submits request to /greeting
						"<form action='hello' method='post'>" +
							"<input type='text' name='name' />" +
							"<select name='language'>" +
								"<option value='English'>English</option>" +
								"<option value='French'>French</option>" +
								"<option value='Italian'>Italian</option>" +
								"<option value='Spanish'>Spanish</option>" +
								"<option value='Japanese'>Japanese</option>" +
								"<option value='Russian'>Russian</option>" +
							"</select>" +
							"<input type='submit' value='Greet me!' />" +
						"</form>" +
					"</body>" +
				"</html>";
	} // server-side rendering!

///////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "hello", method = RequestMethod.POST)
	public String helloPost(@RequestParam String name, @RequestParam String language) {
		// default name
		if (name.isEmpty()) { name = "World"; }
		return createMessage(name, language);
	}

	public static String createMessage(String name, String language) {
		String greeting = "";

		switch (language) {
			case "French":
				greeting = "Bonjour";
				break;
			case "Italian":
				greeting = "Ciao";
				break;
			case "Spanish":
				greeting = "Hola";
				break;
			case "Japanese":
				greeting = "Konichiwa";
				break;
			case "Russian":
				greeting = "Privet";
				break;
			case "English" : greeting = "Hello";
		}
		return greeting + " " + name;
	}
}