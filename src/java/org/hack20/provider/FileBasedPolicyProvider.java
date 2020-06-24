package org.hack20.provider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.hack20.domain.Policy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class FileBasedPolicyProvider implements PolicyProvider {

    @Value("classpath:defaultPolicy.json")
    private Resource resource;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private List<Policy> policies = new ArrayList<>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() throws Exception {
        String policy = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);
        policies = objectMapper.readValue(policy, new TypeReference<List<Policy>>() {
        });
        log.info("Completed populating cache from file {}", resource.getURI());
    }

    @Override
    @Cacheable(value = "policyCache")
    public Policy getPolicy(String sid) throws Exception {
        log.info("Retrieving policy for {}", sid);
        return policies.stream().filter(p -> StringUtils.equalsIgnoreCase(sid, p.getSid())).findFirst().orElse(new Policy());
    }

    @Override
    public List<Policy> getAllPolicies() throws Exception {
        return policies;
    }
}
