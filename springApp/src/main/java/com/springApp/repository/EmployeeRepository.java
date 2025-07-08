package com.springApp.repository;

import com.springApp.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee , Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Employee p SET p.name =:name , p.email =:email , p.mobile =:mobile WHERE p.id = :id")
    int updateRegistrationById(@Param("id") Long id, @Param("name") String name , @Param("email") String email, @Param("mobile") String mobile);



}
