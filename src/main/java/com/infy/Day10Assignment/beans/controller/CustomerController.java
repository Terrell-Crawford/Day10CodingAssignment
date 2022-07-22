package com.infy.Day10Assignment.beans.controller;

import com.infy.Day10Assignment.Entity.Customer;
import com.infy.Day10Assignment.beans.service.CustomerService;
import com.infy.Day10Assignment.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService cServ;
    @Autowired
    public CustomerController(CustomerService cServ){
        this.cServ=cServ;
    }
    @GetMapping("/details")
    private List<Long> getAllBalances(){
        List<Long> balances= new ArrayList<>();
        for(Customer c: cServ.getAllCustomers()){
            balances.add(c.getCustomerBalance());
        }
        return balances;
    }
    @PostMapping("/add")
    private Customer addCustomer(@RequestBody Customer customer){

        /*Customer customer=new Customer();
        customer.setCustomerName(cDTO.getCustomerName());
        customer.setCustomerNo(cDTO.getCustomerNo());
        customer.setCustomerAddress(cDTO.getCustomerAddress());
        customer.setCustomerAccNum(cDTO.getCustomerAccNum());
        customer.setCustomerBalance(cDTO.getCustomerBalance());*/
        return cServ.createOrUpdateCustomer(customer);
    }
    @PutMapping("/update")
    private Customer updateCustomer(@RequestBody Customer customer){
        /*Customer customer=cServ.getByAccountNumber(cDTO.getCustomerAccNum());
        customer.setCustomerBalance(cDTO.getCustomerBalance());*/
        return cServ.createOrUpdateCustomer(customer);
    }
    @DeleteMapping("/remove")
    private void deleteCustomer(@RequestBody Customer customer){
          cServ.deleteCustomer(customer);
    }
}
