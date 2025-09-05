package org.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesComponent {
    @Value("${employeedata.file}")
    private String employeedatafilename;
    @Value("${database.url}")
    private String databaseUrl;
    @Value("${db.user}")
    private String databaseUser;
    @Value("${db.password}")
    private String databasePsw;

    @Value("${name}")
    private String name123;

    public String getFileName() {
        return employeedatafilename;
    }
    public String getDatabaseUrl() {return databaseUrl;}
    public String getDatabaseUser() {return databaseUser;}
    public String getDatabasePsw() {return databasePsw;}
}
