package com.hcl.employee.controller;

import com.hcl.employee.model.EmployeeActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RequestMapping(value = "/api")
public class ConsumeWebService {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/call/another/endpoints", method = {RequestMethod.GET})
    public List<EmployeeActivity> getProductList() throws Exception {

        String URL="http://localhost:8080/api/get/employees";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<EmployeeActivity> entity = new HttpEntity<EmployeeActivity>(headers);

        final List<EmployeeActivity> response;

        try {

            response = (List<EmployeeActivity>) restTemplate.exchange(URL,
                    HttpMethod.GET, entity, EmployeeActivity.class).getBody();
            return response;

        }catch (Exception myException){
            throw new Exception("Downstream Endpoint is not responding " +myException);
        }

    }

}
