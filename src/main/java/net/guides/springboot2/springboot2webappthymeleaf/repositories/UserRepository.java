package net.guides.springboot2.springboot2webappthymeleaf.repositories;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboot2webappthymeleaf.domain.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer>
{
	public List<User> findAll();
	public User findFirstByOrderByIdDesc();
}
