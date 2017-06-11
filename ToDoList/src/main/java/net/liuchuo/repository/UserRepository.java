package net.liuchuo.repository;

import net.liuchuo.bean.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

  private final NamedParameterJdbcOperations namedParameterJdbcOperations;

  @Autowired
  public UserRepository(NamedParameterJdbcOperations namedParameterJdbcOperations) {
    this.namedParameterJdbcOperations = namedParameterJdbcOperations;
  }

  public UserDTO getUser(String username) {
    String sql = "SELECT * FROM user WHERE username = :username";
    Map<String, String> map = new HashMap<>();
    map.put("username", username);
    UserDTO[] users = new UserDTO[1];
    namedParameterJdbcOperations.query(sql, map, resultSet -> {
      users[0] = UserDTO.builder()
        .id(resultSet.getInt("id"))
        .username(resultSet.getString("username"))
        .password(resultSet.getString("password"))
        .build();
    });
    return users[0];
  }

  public void addUser(UserDTO userDTO) {
    String sql = "INSERT INTO user(username, password) VALUE (:username, :password)";
    Map<String, Object> map = new HashMap<>();
    map.put("username", userDTO.getUsername());
    map.put("password", userDTO.getPassword());
    namedParameterJdbcOperations.update(sql, map);
  }
}
