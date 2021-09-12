package com.test.insurance.controller;

import com.test.insurance.InsuranceFacade;
import com.test.insurance.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private InsuranceController insuranceController;

    @Autowired
    private InsuranceFacade insuranceFacade;

    @RequestMapping(value = "/")
    public String showHome() {
        return "index";
    }

    @RequestMapping(value = "contracts", method = RequestMethod.GET)
    public String listContracts(Model model){
        List<Contract> list = insuranceFacade.getContractList();
        model.addAttribute("contract", new Contract());
        model.addAttribute("listContracts", list);

        return "contracts";
    }

    @RequestMapping(value = "addcontract/", method = RequestMethod.POST)
    public String addContractPage(Model model){
        model.addAttribute("contract", new Contract());
        return "addcontract";
    }

    @RequestMapping(value = "addcontract/add/", method = RequestMethod.POST)
    public String addContract(@ModelAttribute("contract") Contract contract){
        insuranceController.createContract(contract);
        return "index";
    }

    @RequestMapping("/remove/{id}")
    public String removeContract(@PathVariable("id") int id){
        insuranceFacade.removeContractById(id);

        return "contracts";
    }

    @RequestMapping("edit/{id}")
    public String editContract(@PathVariable("id") int id, Model model){
        model.addAttribute("book", insuranceFacade.getContractById(id));
        model.addAttribute("listBooks", insuranceFacade.getContractList());

        return "contracts";
    }

    @RequestMapping("contractdata/{id}")
    public String contractData(@PathVariable("id") int id, Model model){
        model.addAttribute("contract", insuranceFacade.getContractById(id));

        return "contractdata";
    }


    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null,  new CustomDateEditor(dateFormat, true));
    }
}
