package com.switchfully.eurder.service;

import com.switchfully.eurder.entity.*;
import com.switchfully.eurder.exception.*;
import com.switchfully.eurder.repository.AdminRepository;
import jakarta.transaction.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin checkIfIsAdmin(String email, String password) throws AdminEmailNotFoundException, PasswordIsNotValidException {
        return checkIfPasswordIsValid(adminRepository.findByEmail(email),password);
    }

    private Admin checkIfPasswordIsValid(Admin admin, String password)  throws PasswordIsNotValidException {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (!bCryptPasswordEncoder.matches(password, admin.getPassword())) {
            throw new PasswordIsNotValidException();
        }
        return admin;
    }

    private Admin findByEmail(String email) throws AdminEmailNotFoundException {
        return adminRepository.findByEmail(email);
    }
}
