package net.liuchuo.bean;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
  private int id;
  private String username;
  private String password;
}
