package net.liuchuo.controller;

import net.liuchuo.bean.ProfileDTO;
import net.liuchuo.bean.UserDTO;
import net.liuchuo.repository.ProfileRepository;
import net.liuchuo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "register")
public class RegisterController {

  private final UserRepository userRepository;
  private final ProfileRepository profileRepository;

  @Autowired
  public RegisterController(UserRepository userRepository,
                            ProfileRepository profileRepository) {
    this.userRepository = userRepository;
    this.profileRepository = profileRepository;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String showView(Model model) {
    model.addAttribute(UserDTO.builder().build());
    return "register";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String register(UserDTO userDTO, @RequestParam("nickname")String nickname) {
    userRepository.addUser(userDTO);
    ProfileDTO profileDTO = ProfileDTO.builder()
      .userId(userRepository.getUser(userDTO.getUsername()).getId())
      .nickname(nickname)
      .build();
    profileRepository.addProfile(profileDTO);
    return "redirect:login";
  }
}
