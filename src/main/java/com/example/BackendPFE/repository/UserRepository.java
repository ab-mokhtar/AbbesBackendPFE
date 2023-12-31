package com.example.BackendPFE.repository;

import com.example.BackendPFE.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


public interface UserRepository extends JpaRepository<User,String> {

//    @Modifying
//    @Query("UPDATE User u SET u.userEmail = ?1 WHERE u.userEmail = ?2")
//    void updateUserEmail(String newEmail, String oldEmail);

    User findUserByUuid(String uuid);

    List<User> findAllByRolesRoleName(String roleName);
    Long countByRoles_roleName(String role);
}
