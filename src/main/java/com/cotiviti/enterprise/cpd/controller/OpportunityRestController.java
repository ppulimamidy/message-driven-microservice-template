package com.cotiviti.enterprise.cpd.controller;

import com.cotiviti.enterprise.cpd.dao.OpportunityRepository;
import com.cotiviti.enterprise.cpd.model.Opportunity;

import io.swagger.annotations.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 
 */
@RequestMapping(value = "opportunity")
@RestController
public class OpportunityRestController {

    @Autowired
    private OpportunityRepository repository;

    @ApiOperation(value = "GetOpportunityData", nickname = "getOpportunity")
    @RequestMapping(method = RequestMethod.GET, path = "/getOpportunityByCode", produces = "application/json")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "Opportunity Id",
            required = false, dataType = "string", paramType = "query", defaultValue = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Opportunity.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public Optional<Opportunity> getOpportunity(@RequestParam(value = "id", defaultValue = "1") String id) {
        return repository.findById(id);
    }
}
