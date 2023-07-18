package com.example.proj.repo;

import com.example.proj.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepo extends CrudRepository<User, String> {
    @Query("select u from User u where c.nickName = :nickName")
    List<User> findByNickName();
}


// https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
// CrudRepository에 어떤 함수들이 구현되어 있는지 확인할 수 있습니다!
