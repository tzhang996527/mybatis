package com.example.demomybatis.controller;

import com.example.demomybatis.dao.CustomerMapper;
import com.example.demomybatis.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class CustomerController {

    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerController(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @GetMapping(path = "customer")
    public List<Customer> selectByPrimaryKey(@Param("custId") String custId,@Param("type") String type){
        return this.customerMapper.selectByPrimaryKey(custId,type);
    }

    @PostMapping(path = "customer")
    public List<Customer> createCustomer(@RequestBody Customer customer){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        customer.setCreatedBy(username);
        customer.setCreatedOn(new Date());
        this.customerMapper.insert(customer);
        //return all customer
        return this.customerMapper.selectByPrimaryKey(null,null);
    }

    @PutMapping(path = "customer")
    public List<Customer> updateCustomer(@RequestBody Customer customer){
        this.customerMapper.updateByPrimaryKeySelective(customer);
        return this.customerMapper.selectByPrimaryKey(null,null);
    }
    @DeleteMapping(path="Customer/{id}")
    public List<Customer> deleteCustomer(@PathVariable(name="id") String id){
        Customer customer = new Customer();
        customer.setCustId(id);
        this.customerMapper.deleteByPrimaryKey(customer);
        return this.customerMapper.selectByPrimaryKey(null,null);
    }
}
