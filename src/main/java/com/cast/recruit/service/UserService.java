package com.cast.recruit.service;

import com.cast.recruit.model.User;

/**
 * Created By GuuBohan.
 * On 2018/7/17
 * Description:注册(接受表单)，更新用户
 */
public interface UserService {
    User register(User user);

    void update(String studentID, String studentName, Long phoneNumber, String intention_1, String intention_2);

//    List<User> userList();

    Boolean userNotnull(String studentID);

    Boolean equalsToPwd(String studentID, String pwd);

    User findUserByID(String studentID);

//    String findUserByiD(String studentID);
}
