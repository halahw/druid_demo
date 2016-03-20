package dao;

import entity.User;

import java.util.List;

/**
 * Created by Just on 2016/3/20.
 */
public interface UserDao {
    public List<User> findAll();

}
