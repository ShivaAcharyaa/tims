package com.tims.tims.controller;


import com.tims.tims.model.Course;
import com.tims.tims.service.CourseService;
import com.tims.tims.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "admin/index";
    }

    @PostMapping("/addCourse")
    public String addCourse(Course course) {
        courseService.saveCourse(course);
        return "redirect:/";
    }

    @GetMapping("/loadaddCourse")
    public String loadaddCourse() {
        return "admin/addCourse";
    }
    @GetMapping("/courses")
    public String loadViewCourse(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "admin/courses";
    }
    @GetMapping("/editCourse/{id}")
    public String editCourse(@PathVariable int id, Model model) {
        model.addAttribute("course",courseService.getCourseById(id));
        return "admin/editCourse";
    }

//    @GetMapping("/loadUser")
//    public String loadUser(Model model) {
//        model.addAttribute("UserDtls", userService.getAllUser());
//        return "admin/users";
//    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute Course course, HttpSession session) {
        Course saveCourse = courseService.saveCourse(course);
        if (!ObjectUtils.isEmpty(saveCourse)) {
            session.setAttribute("succMsg", "Course saved successfully");

        } else {
            session.setAttribute("errorMsg", "something wrong on server");
        }

        return "redirect:/admin/loadaddCourse";
    }
    @PostMapping("/updateCourse")
    public String updateCourse(@ModelAttribute Course course, HttpSession session, Model model) {
        Course updateCourse = courseService.updateCourse(course);
        if (!ObjectUtils.isEmpty(updateCourse)) {
            session.setAttribute("succMsg", "course update success");
        } else {
            session.setAttribute("errorMsg", "Something wrong on server");
        }

        return "redirect:/admin/editCourse/"+course.getId();
    }



    @GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable int id, HttpSession session) {
        boolean deleteCourse = courseService.deleteCourse(id);
        if (deleteCourse) {
            session.setAttribute("succMsg", "Course delete success");
        } else {
            session.setAttribute("errorMsg", "Something wrong on server");
        }
        return "redirect:/admin/courses";
    }
}