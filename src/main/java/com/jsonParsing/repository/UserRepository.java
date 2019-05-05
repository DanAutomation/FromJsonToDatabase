package com.jsonParsing.repository;

import com.jsonParsing.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
