package org.baopen753.bookingappbackend.mapper;

import org.baopen753.bookingappbackend.dto.ServiceDto;
import org.baopen753.bookingappbackend.entity.Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public ServiceMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /*
     * Convert Service entity to Service DTO
     * */
    public ServiceDto convertToServiceDTO(Service service) {
        return modelMapper.map(service, ServiceDto.class);
    }

    /*
     * Convert Service DTO to Service entity
     * */
    public Service convertToService(ServiceDto serviceDTO) {
        return modelMapper.map(serviceDTO, Service.class);
    }

    public List<Service> convertToListEntity(List<ServiceDto> serviceDtoList) {
        return serviceDtoList.stream().map(entity -> convertToService(entity)).toList();
    }

    public List<ServiceDto> convertToListDTO(List<Service> serviceList) {
        return serviceList.stream().map(entity -> convertToServiceDTO(entity)).toList();
    }
}
