package net.liuchuo.repository;

import net.liuchuo.bean.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Repository
public class TaskRepository {
  private final NamedParameterJdbcOperations namedParameterJdbcOperations;

  @Autowired
  public TaskRepository(NamedParameterJdbcOperations namedParameterJdbcOperations) {
    this.namedParameterJdbcOperations = namedParameterJdbcOperations;
  }

  public List<TaskDTO> getTasks(int userId, boolean isCompleted) {
    String sql = "SELECT * FROM task WHERE user_id = :user_id AND checked = :checked";
    Map<String, Object> map = new HashMap<>();
    map.put("user_id", userId);
    map.put("checked", isCompleted);
    List<TaskDTO> taskDTOS = new LinkedList<>();
    namedParameterJdbcOperations.query(sql, map, resultSet -> {
      TaskDTO taskDTO = TaskDTO.builder()
        .checked(resultSet.getBoolean("checked"))
        .content(resultSet.getString("content"))
        .id(resultSet.getInt("id"))
        .userId(resultSet.getInt("user_id"))
        .build();

      taskDTOS.add(taskDTO);
    });
    return taskDTOS;
  }

  public void addTask(String content, int userId) {
    String sql = "INSERT INTO task(user_id, content, checked) VALUE (:user_id, :content, FALSE)";
    Map<String, Object> map = new HashMap<>();
    map.put("user_id", userId);
    map.put("content", content);
    namedParameterJdbcOperations.update(sql, map);
  }

  public void changeState(int taskId, boolean checked, int userId) {
    String sql = "UPDATE task SET checked = :state WHERE id = :task_id AND user_id = :user_id";
    Map<String, Object> map = new HashMap<>();
    map.put("state", checked);
    map.put("task_id", taskId);
    map.put("user_id", userId);
    namedParameterJdbcOperations.update(sql, map);
  }

  public void dropTask(int taskId, int userId) {
    String sql = "DELETE FROM task WHERE id = :task_id AND user_id = :user_id";
    Map<String, Object> map = new HashMap<>();
    map.put("task_id", taskId);
    map.put("user_id", userId);
    namedParameterJdbcOperations.update(sql, map);
  }

  public void updateTask(int taskId, String content, int userId) {
    String sql = "UPDATE task SET content = :content WHERE id = :task_id AND user_id = :user_id";
    Map<String, Object> map = new HashMap<>();
    map.put("content", content);
    map.put("task_id", taskId);
    map.put("user_id", userId);
    namedParameterJdbcOperations.update(sql, map);
  }
}
