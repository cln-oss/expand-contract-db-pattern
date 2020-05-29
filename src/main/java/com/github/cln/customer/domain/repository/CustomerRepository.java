package com.github.cln.customer.domain.repository;

import java.util.List;

import com.github.cln.customer.domain.model.Customer;

public interface CustomerRepository {

    Customer insert(Customer customer);

    List<Customer> fetchAll();
}
