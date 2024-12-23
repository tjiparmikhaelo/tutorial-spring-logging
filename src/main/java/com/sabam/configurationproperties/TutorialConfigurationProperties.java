package com.sabam.configurationproperties;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties("application")
public class TutorialConfigurationProperties {

  private String name;

  private Integer version;

  private boolean productionMode;

  private DatabaseProperties database;

  private List<Role> defaultRoles;

  private Map<String, Role> roles;

  private Duration defaultTimeout;

  private Date expireDate;

  @Getter
  @Setter
  public static class DatabaseProperties {

    private String username;

    private String password;

    private String url;

    private String database;

    private List<String> whitelistTables;

    private Map<String, Integer> maxTablesSize;
  }

  @Getter
  @Setter
  public static class Role {

    private String id;

    private String name;
  }
}
