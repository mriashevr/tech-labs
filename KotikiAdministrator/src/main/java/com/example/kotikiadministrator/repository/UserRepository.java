package com.example.kotikiadministrator.repository;

import com.example.kotikiadministrator.entities.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByLogin(String login);
}
