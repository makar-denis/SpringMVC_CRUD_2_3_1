package controller;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import servis.UserService;

@Controller
//@RequestMapping("/users")// c этой аннотацией почемуто не работало
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
            this.userService = userService;
    }

    @GetMapping("/users")
    public String allUser( ModelMap model) {
        model.addAttribute("listUsers", userService.all());
    return "user";
    }

    @GetMapping("/create")
    public String createUserForm(User user){
        return "create";
    }

    @PostMapping("/create")
    public String createUser(User user){
        userService.add(user);
        return "redirect:users";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id){
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, ModelMap model){
        User user = userService.getUser(id);
        model.addAttribute("user", user );
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(User user){
        userService.change(user);
        return "redirect:users";
    }

}
