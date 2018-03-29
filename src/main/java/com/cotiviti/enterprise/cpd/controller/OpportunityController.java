package com.cotiviti.enterprise.cpd.controller;

import com.cotiviti.enterprise.cpd.dao.OpportunityRepository;
import com.cotiviti.enterprise.cpd.kafka.producer.Sender;
import com.cotiviti.enterprise.cpd.kafka.producer.UpdateDispositionProducer;
import com.cotiviti.enterprise.cpd.model.Opportunity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
/**
 * Created by 
 */
@Controller
public class OpportunityController {

    @Autowired
    private OpportunityRepository repository;

    @Autowired
    ConfigurableApplicationContext context;

    @RequestMapping(value = "/updateDisposition", method = RequestMethod.POST)
    public ModelAndView updateDispositionOpportunity(@ModelAttribute("id") String id, @ModelAttribute("disposition") String disposition){
        long retval = repository.updateDispositionOpportunity(id, disposition);
        Sender sender = context.getBean("sender",Sender.class);

        sender.send(disposition);

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "editDisposition/{id}", method = RequestMethod.GET)
    public String updateDispositionOpportunity(Model model, @PathVariable String id){
       Opportunity opportunity = repository.findById(id).get();

       
        model.addAttribute(opportunity);

        return "updateDisposition";
    }

    @RequestMapping(value = "editDispositionNote/{id}", method = RequestMethod.GET)
    public String updateDispositionNoteOpportunity(Model model, @PathVariable String id){
        Opportunity opportunity = repository.findById(id).get();

        model.addAttribute(opportunity);

        return "updateDispositionNote";
    }

    @RequestMapping(value = "/updateDispositionNote", method = RequestMethod.POST)
    public ModelAndView updateDispositionNoteOpportunity(@ModelAttribute("id") String id, @ModelAttribute("dispositionNote") String dispositionNote){
        UpdateDispositionProducer producer = context.getBean("kafkaUpdateDispositionProducer",UpdateDispositionProducer.class);

        producer.updateDataDispositionAndPublishToKafka(id, dispositionNote);

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView addOpportunity(@ModelAttribute("opportunity") Opportunity opportunity, Model model){
        repository.save(opportunity);

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView addOpportunity(HttpSession httpSession){
        return new ModelAndView("create");
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteOpportunity(@PathVariable String id){
        repository.deleteById(id);

        return new ModelAndView("redirect:/");
    }

    @RequestMapping("/")
    public ModelAndView getAll(HttpSession httpSession){
        List<Opportunity> result = repository.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("opportunities", result);

        return modelAndView;
    }
}
