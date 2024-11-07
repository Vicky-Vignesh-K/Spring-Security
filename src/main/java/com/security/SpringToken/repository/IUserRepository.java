package com.security.SpringToken.repository;

import com.security.SpringToken.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    User findByUserName(String userName);

}
