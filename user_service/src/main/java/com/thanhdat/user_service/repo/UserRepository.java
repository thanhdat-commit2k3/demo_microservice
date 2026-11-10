package com.thanhdat.user_service.repo;

import com.thanhdat.user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
