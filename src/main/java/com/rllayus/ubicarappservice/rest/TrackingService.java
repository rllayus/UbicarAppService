package com.rllayus.ubicarappservice.rest;

import com.rllayus.ubicarappservice.bussiness.dto.CoreUbicarAppService;
import com.rllayus.ubicarappservice.bussiness.dto.LocationDto;
import com.rllayus.ubicarappservice.rest.request.ListRequest;
import com.rllayus.ubicarappservice.rest.responce.ObjectResponse;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Created by Ricardo Laredo on 13/05/2017.
 */
//@Path("/trackingService")
public class TrackingService {
    private static final Logger LOGGER = Logger.getLogger(TrackingService.class);
    @Inject
    private CoreUbicarAppService coreAppHomeService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/saveLocations")
    public ObjectResponse<Integer> saveLocations(@Context HttpServletRequest httpRequest, ListRequest<LocationDto> request){
        LOGGER.info("Lista de localizaciones recibidas con :"+request.getValues().size());
        return this.coreAppHomeService.saveLocations(httpRequest,request);
    }



}
