package com.zelyy.BootApp.contrillers;

import com.zelyy.BootApp.pojo.User;
import com.zelyy.BootApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Main {
    private UserService userService;

    @Autowired
    public Main(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String starter(Model model) {

        model.addAttribute("users", userService.findAll());
        return "main";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping("new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @GetMapping("edit")
    public String editUser(@RequestParam Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "newUser";
    }


    @PostMapping("/save")
    public String saveUser(@ModelAttribute() User user) {
        userService.add(user);
        return "redirect:/";
    }

}
