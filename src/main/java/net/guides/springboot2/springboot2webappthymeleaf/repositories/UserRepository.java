package net.guides.springboot2.springboot2webappthymeleaf.repositories;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import net.guides.springboot2.springboot2webappthymeleaf.domain.User;

public interface UserRepository extends CrudRepository<User, Integer>
{

}
