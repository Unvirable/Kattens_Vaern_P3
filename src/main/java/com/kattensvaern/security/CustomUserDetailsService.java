
package com.kattensvaern.security;

import com.kattensvaern.database.DAO.UserDAO;
import com.kattensvaern.database.DAO.UserDAO.UserCredentials;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserDAO userDAO;

    public CustomUserDetailsService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        UserCredentials account = userDAO.findByEmail(email);

        if (account == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return User.withUsername(account.email())
                .password(account.passwordHash())
                .roles(account.role().toUpperCase())
                .disabled(!account.enabled())
                .build();
    }
}
