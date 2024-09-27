package org.baopen753.bookingappbackend.mapper;

import org.baopen753.bookingappbackend.dto.MovingSurchargeDto;
import org.baopen753.bookingappbackend.entity.MovingSurcharge;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovingSurchargeMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public MovingSurchargeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /*
    * Convert MovingSurcharge entity to MovingSurcharge DTO
    * */
    public MovingSurchargeDto convertToMovingSurchargeDTO(MovingSurcharge movingSurcharge) {
        return modelMapper.map(movingSurcharge, MovingSurchargeDto.class);
    }

    /*
     * Convert MovingSurcharge DTO to MovingSurcharge entity
     * */
    public MovingSurcharge convertToMovingSurcharge(MovingSurchargeDto movingSurchargeDTO) {
        return modelMapper.map(movingSurchargeDTO, MovingSurcharge.class);
    }
}
