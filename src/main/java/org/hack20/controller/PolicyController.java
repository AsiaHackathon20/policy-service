package org.hack20.controller;

import lombok.extern.slf4j.Slf4j;
import org.hack20.app.PolicyApp;
import org.hack20.domain.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class PolicyController {

    @Autowired
    private PolicyApp policyApp;

    @GetMapping(value = "/ping")
    public String ping() {
        log.info("Is application alive?");
        return "pong";
    }

    @GetMapping(value = "/policy-mapping/{sid}")
    public Policy getPolicyMapping(@PathVariable(value = "sid") String sid) throws Exception {
        Policy policy = policyApp.getPolicy(sid);
        log.info("Retrieving policy for {}, {}", sid, policy);
        return policy;
    }

    @GetMapping(value = "/policy-mapping/all")
    public List<Policy> getAllPolicies() throws Exception {
        List<Policy> policy = policyApp.getAllPolicies();
        log.info("Retrieving all policies for {}", policy);
        return policy;
    }
}
