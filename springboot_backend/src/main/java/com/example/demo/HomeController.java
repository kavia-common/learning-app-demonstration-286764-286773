package com.example.demo;

import com.example.demo.repository.CourseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Controller for server-rendered pages.
 */
@Controller
public class HomeController {

    private final CourseRepository courseRepository;

    public HomeController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    /**
     * Provides the application name to all views.
     * @return the app name
     */
    @ModelAttribute("appName")
    public String appName() {
        return "Learning App";
    }

    // PUBLIC_INTERFACE
    /**
     * Render the home page.
     * @param model view model
     * @return template name
     */
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pageTitle", "Home");
        model.addAttribute("highlight", "home");
        return "index";
    }

    // PUBLIC_INTERFACE
    /**
     * Render the courses catalog page.
     * @param model view model
     * @return template name
     */
    @GetMapping("/courses")
    public String courses(Model model) {
        model.addAttribute("pageTitle", "Courses");
        model.addAttribute("highlight", "courses");
        model.addAttribute("courses", courseRepository.findAll());
        return "courses";
    }

    // PUBLIC_INTERFACE
    /**
     * Render the about page.
     * @param model view model
     * @return template name
     */
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("pageTitle", "About");
        model.addAttribute("highlight", "about");
        return "about";
    }
}
