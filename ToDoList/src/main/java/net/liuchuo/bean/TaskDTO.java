package net.liuchuo.bean;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDTO implements Serializable {
  private int id;
  private boolean checked;
  private String content;
  private int userId;
}
