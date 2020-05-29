package com.github.cln.customer.application.facade;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.github.cln.customer.application.dto.CustomerMapper;
import com.github.cln.customer.application.dto.CustomerResponse;
import com.github.cln.customer.application.dto.NewCustomerRequest;
import com.github.cln.customer.domain.repository.CustomerRepository;

import java.util.List;

@ApplicationScoped
public class CustomerFacade {

    @Inject
    CustomerMapper mapper;

    @Inject
    @Named("postgres")
    CustomerRepository repository;

    @Transactional
    public CustomerResponse addCustomer(NewCustomerRequest req) {
        var customer = this.mapper.toCustomer(req);
        customer = this.repository.insert(customer);
        return this.mapper.toResponse(customer);
    }

    public List<CustomerResponse> getAllCustomers() {
        var customers = this.repository.fetchAll();
        return this.mapper.toResponses(customers);
    }
}
