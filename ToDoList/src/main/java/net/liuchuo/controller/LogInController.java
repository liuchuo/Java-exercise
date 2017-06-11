package net.liuchuo.controller;

import net.liuchuo.bean.UserDTO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/login", "/"})
public class LogInController {

  @RequestMapping(method = RequestMethod.GET)
  public String showView(Model model) {
    model.addAttribute(UserDTO.builder().build());
    return "login";
  }
}
