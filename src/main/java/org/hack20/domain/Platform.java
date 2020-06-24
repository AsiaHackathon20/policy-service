package org.hack20.domain;

import lombok.Data;

import java.util.List;

@Data
public class Platform {
    private PlatformIdentifierType identifier;
    private List<String> productScope;
    private List<String> enterpriseAccount;
    private List<String> personalAccount;
}
