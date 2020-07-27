package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCtrl {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JobRepository jobRepository;

    @RequestMapping("/")
    public String index(Model model) {
        //Grab all the users from the database and send them to the template
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
    @RequestMapping("/addUser")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "addUser";
    }
    @PostMapping("/processUser")
    public String processUser(@ModelAttribute User user){
        userRepository.save(user);
        return "redirect:/";
    }
    @RequestMapping("listUser")
    public String listUser(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "listUser";
    }
    @RequestMapping("sue")
    public String sueUser(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "sue";
    }
    @RequestMapping("nora")
    public String noraUser(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "nora";
    }
    @RequestMapping("ray")
    public String rayUser(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "ray";
    }
    @RequestMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userRepository.findById(id));
        return "addUser";
    }
    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") long id){
        userRepository.deleteById(id);
        return "redirect:/";
    }
    @RequestMapping("/detailUser/{id}")
    public String detailUser(@PathVariable("id")long id, Model model){
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        return "detailUser";
    }
    @RequestMapping("addJob")
    public String addJob(Model model){
        model.addAttribute("job", new Job());
        model.addAttribute("users", userRepository.findAll());//add users to model
        return "addJob";
    }
    @PostMapping("/processJob")
    public String processJob(@ModelAttribute Job job){
        jobRepository.save(job);
        return "redirect:/";
    }
    @RequestMapping("listJob")
    public String listJob(Model model){
        model.addAttribute("jobs", jobRepository.findAll());
        return "listJob";
    }
    @RequestMapping("/updateJob/{id}")
    public String updateJob(@PathVariable("id") long id, Model model){
        model.addAttribute("job", jobRepository.findById(id).get());//find user object and put in model
        model.addAttribute("users", userRepository.findAll());//put all users in the model
        return "addJob";
    }
    @RequestMapping("/deleteJob/{id}")
    public String deleteJob(@PathVariable("id") long id){
        jobRepository.deleteById(id);
        return "redirect:/";
    }
    @RequestMapping("/detailJob/{id}")
    public String detailJob(@PathVariable("id")long id, Model model){
        Job job = jobRepository.findById(id).get();
        model.addAttribute("job", job);
        return "detailJob";
    }


}

