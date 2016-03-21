package dao;

import entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Just on 2016/3/20.
 */
public interface UserDao {

    public void deleteByBatch(int[] list);

    int countAll();

    List<User> findAll(Map<String, Object> map);

}
