package com.wanyua.Log.in.Repository;

import com.wanyua.Log.in.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByIdAndPassword(String login,String password);
}
