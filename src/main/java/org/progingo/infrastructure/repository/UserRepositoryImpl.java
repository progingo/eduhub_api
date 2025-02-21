package org.progingo.infrastructure.repository;

import org.progingo.dao.UserDao;
import org.progingo.domain.user.User;
import org.progingo.domain.user.UserBO;
import org.progingo.domain.user.UserExample;
import org.progingo.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean saveUser(User user) {
        int r = userDao.insert(user);
        return r == 1;
    }

}
