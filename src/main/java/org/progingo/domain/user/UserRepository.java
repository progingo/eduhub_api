package org.progingo.domain.user;

public interface UserRepository {
    boolean saveUser(User user);

    void updateUser(User user);

    UserBO findUserByUsername(String username);

    boolean haveUser(String username);
}
