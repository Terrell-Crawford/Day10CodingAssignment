package com.infy.Day10Assignment.beans.service;

import com.infy.Day10Assignment.Entity.Customer;
import com.infy.Day10Assignment.beans.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService{
    private final CustomerRepository cRepo;
    @Autowired
    public CustomerService(CustomerRepository cRepo){
        this.cRepo=cRepo;
    }

    public Customer createOrUpdateCustomer(Customer customer){
        return cRepo.save(customer);
    }

    public void deleteCustomer(Customer customer){
        cRepo.delete(customer);
    }
    public Customer getCustomerById(Integer id){
        return cRepo.getReferenceById(id);
    }
    public List<Customer> getAllCustomers(){
        return cRepo.findAll();
    }
    public Customer getByAccountNumber(Long accNum){
        return cRepo.getCustomerByAccNum(accNum);
    }

}
