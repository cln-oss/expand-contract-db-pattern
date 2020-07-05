package com.github.cln.customer.repo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity(name = "CustomerEntity")
@Table(name = "customer")
public class CustomerEntity extends PanacheEntityBase {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Long id;

   @Column(name = "first_name")
   public String firstName;

   @Column(name = "last_name")
   public String lastName;
}
