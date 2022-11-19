package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.CreateUserDto;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public String getUsers(final Model model) {
        final List<User> users = userService.findUsers();
        model.addAttribute("users", users);
        model.addAttribute("dto", new CreateUserDto());
        return "/users";
    }
}
