package com.aew.FinalTopic.Final_Proyect.repository;

import com.aew.FinalTopic.Final_Proyect.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Adrian
 */
public interface UserRepository extends CrudRepository<User, String> {

    User findByUsername(String username);

}
