package com.github.cln.customer.application.database;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.github.cln.customer.domain.model.Customer;
import com.github.cln.customer.domain.repository.CustomerRepository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@ApplicationScoped
@Named("inMemory")
public class CustomerInMemoryRepository implements CustomerRepository {

    private final List<Customer> customers = new CopyOnWriteArrayList<>();

    @Override
    public Customer insert(Customer customer) {
        customers.add(customer);
        customer.setId(customers.size() - 1L);
        return customer;
    }

    @Override
    public List<Customer> fetchAll() {
        return this.customers;
    }
}
