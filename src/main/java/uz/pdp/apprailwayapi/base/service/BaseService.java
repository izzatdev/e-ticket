package uz.pdp.apprailwayapi.base.service;

import uz.pdp.model.ApiResponse;

import java.util.List;

public interface BaseService<Dto,Response> {
    ApiResponse add(Dto dto);
    Response getById(Long id);
    List<Response> get();
    ApiResponse delete(Dto dto);
    ApiResponse edit(Long id,Dto dto);
}
