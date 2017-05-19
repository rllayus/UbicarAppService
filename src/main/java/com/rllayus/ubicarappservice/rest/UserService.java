package com.rllayus.ubicarappservice.rest;

import com.rllayus.ubicarappservice.bussiness.dto.CoreUbicarAppService;
import com.rllayus.ubicarappservice.bussiness.dto.LoginDto;
import com.rllayus.ubicarappservice.bussiness.dto.UserDto;
import com.rllayus.ubicarappservice.rest.request.ObjectRequest;
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
 * Created by Ricardo Laredo on 18/05/2017.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/userService")
public class UserService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class);
    @Inject
    private CoreUbicarAppService coreUbicarAppService;
    @POST
    @Path("/version")
    public String version(){
        return "UbicarAppService 1.0";
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ObjectResponse<UserDto> login(@Context HttpServletRequest request, ObjectRequest<LoginDto> requestLogin){
        LOGGER.info("Peticion de login ");
        try {
            return this.coreUbicarAppService.login(request, requestLogin);
        }catch (Exception e){
            ObjectResponse<UserDto> response=new ObjectResponse<UserDto>();
            response.setError(10);
            response.setMessage("ERROR de CDI");
            return response;
        }
    }
}
