package org.progingo.infrastructure.repository;

import org.progingo.dao.UserDao;
import org.progingo.domain.user.User;
import org.progingo.domain.user.UserBO;
import org.progingo.domain.user.UserExample;
import org.progingo.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserAdapter userAdapter;

    @Override
    public boolean saveUser(User user) {
        int r = userDao.insert(user);
        return r == 1;
    }

    @Override
    public void updateUser(User user) {
        user.setGmtModify(new Date());
        userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public UserBO findUserByUsername(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        User user = userDao.selectByExample(userExample).stream().findFirst().orElse(null);
        return userAdapter.toBO(user);

    }


    @Override
    public boolean haveUser(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        return userDao.countByExample(userExample) > 0;
    }
}
