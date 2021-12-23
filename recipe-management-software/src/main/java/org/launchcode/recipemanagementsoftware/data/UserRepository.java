package org.launchcode.recipemanagementsoftware.data;

import org.launchcode.recipemanagementsoftware.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
