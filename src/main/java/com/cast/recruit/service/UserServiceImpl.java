package com.cast.recruit.service;

import com.cast.recruit.repository.UserRepository;
import com.cast.recruit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created By GuuBohan.
 * On 2018/7/17
 */
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public void update(String studentID, String studentName, Long phoneNumber, String intention_1, String intention_2) {
//        User user1 = new User(studentID,studentName,phoneNumber,intention_1,intention_2);
        User user = userRepository.findUserByStudentID(studentID);
        user.setStudentName(studentName);
        user.setPhoneNumber(phoneNumber);
        user.setIntention_1(intention_1);
        user.setIntention_2(intention_2);
        userRepository.save(user);
    }

    @Override        //true则为不空，false则为空
    public Boolean userNotnull(String studentID){
        if (userRepository.findUserByStudentID(studentID)!=null)
            return true;
        return false;
    }

    @Override
    public Boolean equalsToPwd(String studentID, String pwd){
        return userRepository.findUserByStudentID(studentID).getPassword().equals(pwd);
    }

    @Override
    public User findUserByID(String studentID) {
        return userRepository.findUserByStudentID(studentID);
    }

//    @Override
//    public String findUserByiD(String studentID) {
//        return userRepository.findUserByStudentiD(studentID);
//    }
}
