package br.com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Christian Oscar Tejada Pacheco
 *
 */
@Controller
public class MVCSpringWSTest {
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("message", message);
		mv.addObject("qa", "qqqqqqqqq");
		return mv;
	}

}
