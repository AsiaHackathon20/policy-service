package org.hack20.policyservice.provider;

import org.hack20.policyservice.domain.Policy;

import java.util.List;

public interface PolicyProvider {

    void init() throws Exception;

    Policy getPolicy(String sid) throws Exception;

    List<Policy> getAllPolicies() throws Exception;
}
