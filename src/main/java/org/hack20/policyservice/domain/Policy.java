package org.hack20.policyservice.domain;

import lombok.Data;

import java.util.List;

@Data
public class Policy {

    private String sid;
    private List<String> productScope;
    private List<SocialMediaPlatforms> socialMediaPlatforms;
    private String jpmEnterpriseAccount;
    private List<Contacts> contacts;
}
