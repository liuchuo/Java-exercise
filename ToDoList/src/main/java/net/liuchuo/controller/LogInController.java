package net.liuchuo.controller;

import net.liuchuo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LogInController {
    @Autowired
    private UserRepository userRepository;
}
