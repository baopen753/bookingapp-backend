package org.baopen753.bookingappbackend.mapper;

import org.baopen753.bookingappbackend.dto.AddressDto;
import org.baopen753.bookingappbackend.entity.Address;
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
