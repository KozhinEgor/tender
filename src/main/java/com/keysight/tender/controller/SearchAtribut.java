package com.keysight.tender.controller;

import com.keysight.tender.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Controller
public class SearchAtribut  {
    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer;
    private Typetender typetender;
    @Autowired
    private TypetenderRepository typetenderRepository;
    private Winner winner;
    @Autowired
    private WinnerRepository winnerRepository;

    public Customer findCustomer ( String INN, String Name) {
        if(INN.length() == 0){
            INN = "0";
        }
        List<Customer> FindCustomer = customerRepository.findTopByINNAndName(INN, Name);

        if(FindCustomer.isEmpty()){
            //добавление новой записи

            customer = customerRepository.save(new Customer(INN,Name));
        }
        else {
            customer = FindCustomer.get(0);
        }
        return customer;
    }

    public Typetender findTypetender(String type){
        List<Typetender> FindType= typetenderRepository.findByType(type);
        if(FindType.isEmpty()){
            //добавление новой записи
            typetender = typetenderRepository.save(new Typetender(type));
        }
        else {
            typetender = FindType.get(0);
        }

        return typetender;
    }
    public Winner findNoWinner(){
        List<Winner> FindWinner = winnerRepository.findByid(Long.valueOf(1));
        winner = FindWinner.get(0);
        return winner;
    }
}
