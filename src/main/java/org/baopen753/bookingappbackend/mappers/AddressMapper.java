package org.baopen753.bookingappbackend.mappers;


import org.baopen753.bookingappbackend.entities.Address;
import org.baopen753.bookingappbackend.responses.service.AddressResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mappings({
            @Mapping(source = "addressId", target = "addressId"),
            @Mapping(source = "city", target = "city"),
            @Mapping(source = "district", target = "district"),
            @Mapping(source = "ward", target = "ward"),
            @Mapping(source = "homeNumber", target = "homeNumber")
    })
    AddressResponse convertToAddressResponse(Address address);

}
