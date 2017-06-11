package net.liuchuo.bean;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {
  private String avatar;
  private String nickname;
  private int userId;
}
