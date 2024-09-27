package org.baopen753.bookingappbackend.service.surchargeservice;

import org.baopen753.bookingappbackend.entity.MovingSurcharge;

import java.util.List;

public interface SurchargeService {
    List<MovingSurcharge> getAllMovingSurcharges();
    MovingSurcharge getMovingSurchargeById(Integer id);
    MovingSurcharge updateMovingSurcharge(Integer movingSurchargeId, MovingSurcharge movingSurcharge);
}
