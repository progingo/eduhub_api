package org.progingo.domain.user;

public interface UserRepository {
    boolean saveUser(User user);

    void updateUser(User user);
}
