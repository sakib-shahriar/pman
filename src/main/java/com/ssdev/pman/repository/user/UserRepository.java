package com.ssdev.pman.repository.user;

import com.ssdev.pman.dto.response.UserResponse;
import com.ssdev.pman.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserName(String userName);


    @Query("select new com.ssdev.pman.dto.response.UserResponse(u.userName, u.role, u.email) from User u")
    List<UserResponse> findALlResponse();

    @Query("select new com.ssdev.pman.dto.response.UserResponse(u.userName, u.role, u.email) from User u where u.userName = ?1")
    UserResponse findUserByUserNameResponse(String userName);


}
