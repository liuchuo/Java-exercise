package net.liuchuo.controller;

import net.liuchuo.repository.TaskRepository;
import net.liuchuo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//CompletedTaskController类
@Controller
@RequestMapping(value = "completed_task")
public class CompletedTaskController {

  private final TaskRepository taskRepository;
  private final UserRepository userRepository;

  @Autowired
  public CompletedTaskController(TaskRepository taskRepository, UserRepository userRepository) {
    this.taskRepository = taskRepository;
    this.userRepository = userRepository;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String completedTask(@RequestParam("task_id") int taskId) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    taskRepository.changeState(taskId, true, userRepository.getUser(user.getUsername()).getId());
    return "redirect:home";
  }
}
