package org.baopen753.bookingappbackend.mappers;

import org.baopen753.bookingappbackend.dtos.AddressDto;
import org.baopen753.bookingappbackend.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mappings({
            @Mapping(source = "city", target = "city"),
            @Mapping(source = "district", target = "district"),
            @Mapping(source = "ward", target = "ward"),
            @Mapping(source = "homeNumber", target = "homeNumber")
    })
    AddressDto convertEntityToDto(Address address);

    @Mappings({
            @Mapping(source = "city", target = "city"),
            @Mapping(source = "district", target = "district"),
            @Mapping(source = "ward", target = "ward"),
            @Mapping(source = "homeNumber", target = "homeNumber")
    })
    Address convertDtoToEntity(AddressDto address);
}
