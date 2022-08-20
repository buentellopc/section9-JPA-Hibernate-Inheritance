package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Employee;
import com.in28minutes.jpa.hibernate.demo.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    //    insert an employee
    public void insert(Employee employee) {
        em.persist(employee);
    }

    //    retrieve all employees
    public List<Employee> retrieveAllEmployees() {
        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }


}
