package com.webatrio.project.webapp.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import com.webatrio.project.webapp.entity.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {

}
