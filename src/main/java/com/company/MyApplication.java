package com.company;

import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("v1")
public class MyApplication extends ResourceConfig {

    public MyApplication() {
        packages("com.company.api");
    }
}

