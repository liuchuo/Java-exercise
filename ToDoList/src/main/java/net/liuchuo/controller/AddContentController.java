package net.liuchuo.controller;

import net.liuchuo.bean.UserDTO;
import net.liuchuo.repository.TaskRepository;
import net.liuchuo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "add_content")
public class AddContentController {
  private final TaskRepository taskRepository;
  private final UserRepository userRepository;

  @Autowired
  public AddContentController(TaskRepository taskRepository, UserRepository userRepository) {
    this.taskRepository = taskRepository;
    this.userRepository = userRepository;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String addContent(@RequestParam String content) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    UserDTO userDTO = userRepository.getUser(user.getUsername());
    taskRepository.addTask(content, userDTO.getId());
    return "redirect:home";
  }
}
