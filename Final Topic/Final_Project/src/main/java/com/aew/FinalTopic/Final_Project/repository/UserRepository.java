package com.aew.FinalTopic.Final_Project.repository;

import com.aew.FinalTopic.Final_Project.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Adrian
 */
public interface UserRepository extends CrudRepository<User, String> {

    User findByUsername(String username);

}
