package net.liuchuo.service;

import net.liuchuo.bean.UserDTO;
import net.liuchuo.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsServerImpl implements UserDetailsService {

  private final UserRepository userRepository;

  public UserDetailsServerImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserDTO user = userRepository.getUser(username);
    List<GrantedAuthority> authorities = new ArrayList<>();
    return new User(user.getUsername(), user.getPassword(), authorities);
  }
}
