package net.liuchuo.controller;

import net.liuchuo.bean.UserDTO;
import net.liuchuo.repository.ProfileRepository;
import net.liuchuo.repository.TaskRepository;
import net.liuchuo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

  private final TaskRepository taskRepository;
  private final UserRepository userRepository;
  private final ProfileRepository profileRepository;

  @Autowired
  public HomeController(TaskRepository taskRepository,
                        UserRepository userRepository,
                        ProfileRepository profileRepository) {
    this.taskRepository = taskRepository;
    this.userRepository = userRepository;
    this.profileRepository = profileRepository;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String showView(Model model) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    UserDTO userDTO = userRepository.getUser(user.getUsername());
    model.addAttribute("toDoTask", taskRepository.getTasks(userDTO.getId(), false)); // to do
    model.addAttribute("completedTask", taskRepository.getTasks(userDTO.getId(), true)); // completed
    model.addAttribute("profile", profileRepository.getProfile(userDTO.getId()));
    return "home";
  }
}
