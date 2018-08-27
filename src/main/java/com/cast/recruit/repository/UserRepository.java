package com.cast.recruit.repository;

import com.cast.recruit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By GuuBohan.
 * On 2018/7/26
 */

public interface UserRepository extends JpaRepository<User,String> {
    User findUserByStudentID(String studentID);
    User findUserByPhoneNumber(Long phoneNumber);
//    String findUserByStudentiD(String studentID);
}
