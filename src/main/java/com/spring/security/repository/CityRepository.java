package com.spring.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.model.Students;

@Repository
public interface CityRepository extends CrudRepository<Students, Long>{
    @Query(value="select * from students  where LAST_NAME='Indher'",nativeQuery=true)
    List<Students> findByLastNameh(String lastName);

}
