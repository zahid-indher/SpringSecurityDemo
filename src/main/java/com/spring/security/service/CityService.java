package com.spring.security.service;

import com.spring.security.model.Students;
import com.spring.security.repository.CityRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService  {

	@Autowired
    private CityRepository repository;

    public List<Students> findByNameEndsWith(String name) {

        List<Students> cities = (List<Students>) repository.findByLastNameh(name);
        return cities;
    }
}