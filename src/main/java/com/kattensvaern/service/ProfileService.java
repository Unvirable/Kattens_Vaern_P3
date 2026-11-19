
package com.kattensvaern.service;

import com.kattensvaern.database.DAO.UserDAO;
import com.kattensvaern.database.models.UserProfile;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final UserDAO userDAO;

    public ProfileService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserProfile getProfileByEmail(String email) {
        return userDAO.findProfileByEmail(email);
    }
}
