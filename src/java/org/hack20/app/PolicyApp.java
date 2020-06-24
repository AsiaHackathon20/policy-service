package org.hack20.app;

import org.hack20.domain.Policy;
import org.hack20.provider.PolicyProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PolicyApp {

    @Autowired
    private PolicyProvider provider;

    public Policy getPolicy(String sid) throws Exception {
        return provider.getPolicy(sid);
    }

    public List<Policy> getAllPolicies() throws Exception {
        return provider.getAllPolicies();
    }
}
