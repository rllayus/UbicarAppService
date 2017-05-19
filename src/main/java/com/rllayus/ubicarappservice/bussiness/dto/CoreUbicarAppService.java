package com.rllayus.ubicarappservice.bussiness.dto;

import com.rllayus.ubicarappservice.rest.request.ListRequest;
import com.rllayus.ubicarappservice.rest.request.ObjectRequest;
import com.rllayus.ubicarappservice.rest.responce.ObjectResponse;

import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * Created by Ricardo Laredo on 18/05/2017.
 */
@Named
public class CoreUbicarAppService implements Serializable {

    public ObjectResponse<UserDto> login(HttpServletRequest request, ObjectRequest<LoginDto> requestLogin) {
        ObjectResponse<UserDto> response=new ObjectResponse<UserDto>();
        response.setError(0);
        response.setMessage("OK");
        return response;
    }

    public ObjectResponse<Integer> saveLocations(HttpServletRequest httpRequest, ListRequest<LocationDto> request) {
        ObjectResponse<Integer> response=new ObjectResponse<Integer>();
        response.setError(0);
        response.setMessage("OK");
        return response;
    }
}
