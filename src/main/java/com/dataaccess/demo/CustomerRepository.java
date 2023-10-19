package com.dataaccess.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastname(String lastname);

    Customer findById(long id);
}
