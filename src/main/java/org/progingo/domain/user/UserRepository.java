package org.progingo.domain.user;

import java.util.List;

public interface UserRepository {
    boolean saveUser(User user);

    void updateUser(User user);

    UserBO findUserByUsername(String username);

    boolean haveUser(String username);

    List<UserBO> findUserByNickName(String nickName);
}
