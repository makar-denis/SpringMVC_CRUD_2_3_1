package controller;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import servis.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
            this.userService = userService;
    }

    @GetMapping
    public String allUser( ModelMap model) {
        model.addAttribute("listUsers", userService.all());
        return "users/user";
    }

    @GetMapping("/create")
    public String createUserForm(User user){
        return "users/create";
    }

    @PostMapping("users/create")
    public String createUser(User user){
        userService.add(user);
        return "redirect:/users";
    }
    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") long id){
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, ModelMap model){
        User user = userService.getUser(id);
        model.addAttribute("user", user );
        System.out.println("1");
        System.out.println(user);
        return "users/update";
    }

    @PostMapping("users/update")
    public String updateUser(User user){
        System.out.println("2");
        userService.change(user.getId(), user);
        System.out.println("3");
        return "redirect:/users";
    }


}
