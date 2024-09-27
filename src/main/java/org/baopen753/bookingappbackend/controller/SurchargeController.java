package org.baopen753.bookingappbackend.controller;

import org.baopen753.bookingappbackend.dto.MovingSurchargeDto;
import org.baopen753.bookingappbackend.entity.MovingSurcharge;
import org.baopen753.bookingappbackend.exception.MovingSurchargeNotFoundException;
import org.baopen753.bookingappbackend.mapper.MovingSurchargeMapper;
import org.baopen753.bookingappbackend.service.surchargeservice.SurchargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/Surcharges")
public class SurchargeController {

    private final SurchargeService surchargeService;
    private final MovingSurchargeMapper movingSurchargeMapper;

    @Autowired
    public SurchargeController(final SurchargeService surchargeService, MovingSurchargeMapper movingSurchargeMapper) {
        this.surchargeService = surchargeService;
        this.movingSurchargeMapper = movingSurchargeMapper;
    }

    /*
     * Get all MovingSurcharge from database
     * */
    @GetMapping()
    public ResponseEntity<List<MovingSurchargeDto>> getAllMovingSurcharges() {
        List<MovingSurcharge> movingSurcharges = surchargeService.getAllMovingSurcharges();
        if (movingSurcharges.isEmpty()) { // There are no data of moving surcharges
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else { // Data existed
            List<MovingSurchargeDto> movingSurchargeDtos = movingSurcharges.stream()
                    .map(movingSurchargeMapper::convertToMovingSurchargeDTO)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(movingSurchargeDtos, HttpStatus.OK);
        }
    }

    /*
     * Get Moving Surcharge by ID
     * */
    @GetMapping("/{surchargeID}")
    public ResponseEntity<?> getMovingSurcharge(
            @PathVariable("surchargeID") Integer surchargeID) {
        try {
            MovingSurcharge movingSurcharge = surchargeService.getMovingSurchargeById(surchargeID);
            MovingSurchargeDto movingSurchargeDTO = movingSurchargeMapper.convertToMovingSurchargeDTO(movingSurcharge);
            return new ResponseEntity<>(movingSurchargeDTO, HttpStatus.OK);
        } catch (MovingSurchargeNotFoundException e) { // Moving surcharge not existed
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /*
    * Update price of a moving surcharge
    * */
    @PutMapping("/{surchargeID}")
    public ResponseEntity<?> updateMovingSurcharge(
            @PathVariable("surchargeID") Integer surchargeID,
            @RequestBody MovingSurchargeDto movingSurchargeFromRequest) {
        try {
            MovingSurcharge movingSurcharge = movingSurchargeMapper.convertToMovingSurcharge(movingSurchargeFromRequest);
            surchargeService.updateMovingSurcharge(surchargeID, movingSurcharge);
            return new ResponseEntity<>(movingSurchargeFromRequest, HttpStatus.OK);
        } catch (MovingSurchargeNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Moving Surcharge Update Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
