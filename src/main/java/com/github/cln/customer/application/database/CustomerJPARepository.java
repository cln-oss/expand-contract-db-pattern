package com.github.cln.customer.application.database;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.github.cln.customer.domain.model.Customer;
import com.github.cln.customer.domain.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Named("postgres")
public class CustomerJPARepository implements CustomerRepository {

   @Override
   public Customer insert(Customer customer) {
       var entity = new CustomerEntity();
       entity.name = customer.getName();
       entity.persist();
       return new Customer(entity.id, entity.name);
   }

   @Override
   public List<Customer> fetchAll() {
       List<CustomerEntity> entities = CustomerEntity.listAll();
       return entities.stream()
               .map(entity -> new Customer(entity.id, entity.name))
               .collect(Collectors.toList());
   }
}
