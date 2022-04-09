package springboot.pp_3_1_1_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import springboot.pp_3_1_1_2.Service.UserService;
import springboot.pp_3_1_1_2.model.User;
import springboot.pp_3_1_1_2.repository.UserRepository;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "Users";
    }

    @GetMapping(value = "/add")
    public String addPage(Model model) {
        return "AddUser";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editPage(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "EditUser";
    }

    @PostMapping(value = "/edit")
    public String editUser (@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(userService.getById(id));
        return "redirect:/";
    }
}
