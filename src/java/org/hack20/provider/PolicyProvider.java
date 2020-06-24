package org.hack20.provider;

import org.hack20.domain.Policy;

public interface PolicyProvider {

    void init() throws Exception;

    Policy getPolicy(String sid) throws Exception;

    String getAllPolicies() throws Exception;
}
