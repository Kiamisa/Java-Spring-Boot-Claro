package com.kiam.service;

import com.kiam.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}
