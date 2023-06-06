package com.example.VivaTech.Respository;

import com.example.VivaTech.Model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<user,Long> {
    user findByUserName(String userName);
}
