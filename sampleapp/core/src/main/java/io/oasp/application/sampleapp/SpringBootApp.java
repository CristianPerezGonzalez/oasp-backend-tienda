package io.oasp.application.sampleapp;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.EndpointAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import io.oasp.module.jpa.dataaccess.api.AdvancedRevisionEntity;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, SecurityFilterAutoConfiguration.class })
@SpringBootApplication(exclude = { EndpointAutoConfiguration.class })
@EntityScan(basePackages = { "io.oasp.application.sampleapp" }, basePackageClasses = { AdvancedRevisionEntity.class })
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class SpringBootApp {

  private static Server h2WebServer = null;

  /**
   * Entry point for spring-boot based app
   *
   * @param args - arguments
   */
  public static void main(String[] args) {

    try {
      h2WebServer = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8520");
      h2WebServer.start();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    SpringApplication.run(SpringBootApp.class, args);
  }
}
