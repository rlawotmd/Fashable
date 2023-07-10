package com.example.proj.repo;

import com.example.proj.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepo extends CrudRepository<User, String> {
}


// https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
// CrudRepository에 어떤 함수들이 구현되어 있는지 확인할 수 있습니다!
