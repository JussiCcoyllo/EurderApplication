package com.switchfully.eurder.repository;

import com.switchfully.eurder.entity.Admin;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);

}
