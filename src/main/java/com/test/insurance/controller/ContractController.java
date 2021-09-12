package com.test.insurance.controller;

import com.test.insurance.calculator.InsuranceCalculator;
import com.test.insurance.model.Contract;
import com.test.insurance.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class ContractController {
    private ContractService contractService;

    @Autowired(required = true)
    @Qualifier(value = "contractService")
    public void setContractService(ContractService contractService) {
        this.contractService = contractService;
    }

    @RequestMapping(value = "/")
    public String showHome() {
        return "index";
    }

    @RequestMapping(value = "contracts", method = RequestMethod.GET)
    public String listBooks(Model model){
        List<Contract> list = contractService.listContracts();
        model.addAttribute("contract", new Contract());
        model.addAttribute("listContracts", list);

        return "contracts";
    }

    @RequestMapping(value = "addcontract/", method = RequestMethod.POST)
    public String addBook(Model model){
        model.addAttribute("contract", new Contract());
        return "addcontract"; //"redirect:/books";
    }

    @RequestMapping(value = "addcontract/add/", method = RequestMethod.POST)
    public String addContract(@ModelAttribute("contract") Contract contract){
        /*if(book.getId() == 0){
            this.bookService.addBook(book);
        }else {
            this.bookService.updateBook(book);
        }*/
        System.out.println(contract);

        return "index"; //"redirect:/books";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int id){
        this.contractService.removeContract(id);

        return "contracts";
    }

    @RequestMapping("edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.contractService.getContractById(id));
        model.addAttribute("listBooks", this.contractService.listContracts());

        return "contracts";
    }

    @RequestMapping("contractdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        model.addAttribute("contract", this.contractService.getContractById(id));

        return "contractdata";
    }

/*    @RequestMapping(value = "search/", method = RequestMethod.POST)
    public String searchBookByAuthor(Model model){
       // bookAuthor = request.getParameter("bookAuthor");
       // model.addAttribute ("book", new Book());
        *//*for(int i=0;i<2;i++)
            System.out.println(book +"В классе Controller");*//*
        List<Book> list = new ArrayList<Book>();
        Book book = new Book(1, "1", "1",1,"1");
        list.add(book);
        model.addAttribute("listBooks", list);

        return "search";
    }*/


    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null,  new CustomDateEditor(dateFormat, true));
    }
}
