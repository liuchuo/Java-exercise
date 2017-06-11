package net.liuchuo.repository;

import net.liuchuo.bean.ProfileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProfileRepository {
  private final NamedParameterJdbcOperations namedParameterJdbcOperations;

  @Autowired
  public ProfileRepository(NamedParameterJdbcOperations namedParameterJdbcOperations) {
    this.namedParameterJdbcOperations = namedParameterJdbcOperations;
  }

  public ProfileDTO getProfile(int userId) {
    String sql = "SELECT * FROM profile WHERE user_id = :user_id";
    Map<String, Object> map = new HashMap<>();
    map.put("user_id", userId);
    ProfileDTO[] profileDTOS = new ProfileDTO[1];
    namedParameterJdbcOperations.query(sql, map, resultSet -> {
      profileDTOS[0] = ProfileDTO.builder()
        .avatar(resultSet.getString("avatar"))
        .nickname(resultSet.getString("nickname"))
        .userId(resultSet.getInt("user_id"))
        .build();
    });
    return profileDTOS[0];
  }

  public void addProfile(ProfileDTO profileDTO) {
    String sql = "INSERT INTO profile (avatar, nickname, user_id) VALUE ('/img/avatar.png', :nickname, :user_id)";
    Map<String, Object> map = new HashMap<>();
    map.put("nickname", profileDTO.getNickname());
    map.put("user_id", profileDTO.getUserId());
    namedParameterJdbcOperations.update(sql, map);
  }
}
