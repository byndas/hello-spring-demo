package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//	@ annotates http-request type
//	handles request to path /hello
/*	@GetMapping("hello") // default "/" root if null path
		@ResponseBody
		public String hello() {
			return "Hello, Spring!";
		}
*/
	// to /hello/bye
	@GetMapping("bye")
	@ResponseBody
	public String bye() {
		return "Bye, Spring!";
	}

//	handles query string requests
//	  to "/hello?name=anyNameYouWriteHere"
	@ResponseBody
	public String helloWithQueryParam(@RequestParam String name) {
		return "Hello, "+name+"!";
	}

//	handles requests to "/hello/LaunchCode" requests
//	@GetMapping("hello/{name}")
@GetMapping("{name}")
	@ResponseBody
	public String helloWithPathParam(@PathVariable String name) {
		return "Hello, "+name+"!";
	}

	@GetMapping("form")
	@ResponseBody
	public String helloForm() {
		return  "<html>" +
						"<body>" +
						"<form action='hello' method='post'>" + //submit request to /hello
						"<input type='text name='name' />" +
						"<input type='submit' value='Greet me!' />" +
						"</form>" +
						"</body>" +
						"</html>";
	}
}
