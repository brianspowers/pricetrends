package net.brianpowers.blsviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * IndexController for our main web application.
 *
 * This could easily have just been static markup, but running it through Spring MVC & a Thymeleaf template gives us
 * some options for future enhancements.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/avgprice/**")
    public String avgPriceApplication() {
        return "index";
    }
}
