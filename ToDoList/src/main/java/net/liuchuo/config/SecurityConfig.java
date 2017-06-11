package net.liuchuo.config;

import net.liuchuo.repository.UserRepository;
import net.liuchuo.service.UserDetailsServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  private final CharacterEncodingFilter encodingFilter;
  private final UserRepository userRepository;

  @Autowired
  public SecurityConfig(CharacterEncodingFilter encodingFilter, UserRepository userRepository) {
    this.encodingFilter = encodingFilter;
    this.userRepository = userRepository;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .addFilterBefore(encodingFilter, CsrfFilter.class)
      .formLogin()
      .loginPage("/login")
      .defaultSuccessUrl("/home", true)
      .and()
      .authorizeRequests()
      .antMatchers("/login").permitAll()
      .antMatchers("/register").permitAll()
      .anyRequest().authenticated();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(new UserDetailsServerImpl(userRepository));
  }


  @Override
  public void configure(WebSecurity web) throws Exception {
    super.configure(web);
    web.ignoring()
      .antMatchers("/img/**")
      .antMatchers("/css/**")
      .antMatchers("/lib/**");
  }
}
