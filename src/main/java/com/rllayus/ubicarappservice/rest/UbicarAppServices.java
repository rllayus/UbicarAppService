package com.rllayus.ubicarappservice.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ricardo Laredo on 13/05/2017.
 */
@ApplicationPath("/")
public class UbicarAppServices extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(UserService.class);
        h.add(TrackingService.class);
        return h;
    }
}
