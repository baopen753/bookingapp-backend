package org.baopen753.bookingappbackend.mappers;

import org.baopen753.bookingappbackend.entities.Service;
import org.baopen753.bookingappbackend.responses.service.ServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

    ServiceResponse convertToResponse(Service service) ;

}
