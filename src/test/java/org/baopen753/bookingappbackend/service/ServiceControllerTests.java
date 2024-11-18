package org.baopen753.bookingappbackend.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.baopen753.bookingappbackend.controllers.ServiceController;
import org.baopen753.bookingappbackend.entities.Service;
import org.baopen753.bookingappbackend.exception.DataNotFoundException;
import org.baopen753.bookingappbackend.services.serviceservice.ServiceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

@WebMvcTest(ServiceController.class)
public class ServiceControllerTests {

    private static final String ENDPOINT_PATH = "/api/v1/services";
    private static final String REQUEST_CONTENT_TYPE = "application/json";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ServiceService serviceService;

    @Test
    @WithMockUser
    public void testGetServiceByIdShouldReturn200OK() throws Exception {

        // create real service instance in happy case
        Service service = new Service();
        service.setServiceId(1);
        service.setServiceName("Tư Vấn Online");
        service.setDescription("Tư vấn online qua google meet.");
        service.setServicePrice(BigDecimal.valueOf(299.0));

        // use Mockito to mock Service object to call desired method --> creat test environment
        Mockito.when(serviceService.getServiceById(Mockito.anyInt())).thenReturn(service);

        // use mockMvc to perform HTTP request
        mockMvc.perform(get(ENDPOINT_PATH + "/" + service.getServiceId())
                        .contentType(REQUEST_CONTENT_TYPE))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    @WithMockUser
    public void testGetServiceByIdShouldReturn404NotFound() throws Exception {

        Integer serviceId = 10;

        // use Mockito to mock Service object to call desired method --> create test environment
        Mockito.when(serviceService.getServiceById(serviceId)).thenThrow(DataNotFoundException.class);

        // use mockMvc to perform HTTP request
        mockMvc.perform(get(ENDPOINT_PATH + "/" + serviceId))
                .andExpect(status().isNotFound())
                .andDo(print());
    }


    @Test
    @WithMockUser
    public void testGetAllServicesShouldReturn200OK() throws Exception {

        Service service1 = new Service();
        service1.setServiceId(1);
        service1.setServiceName("Tư Vấn Online");
        service1.setDescription("Tư vấn online qua google meet.");
        service1.setServicePrice(BigDecimal.valueOf(299.0));

        Service service2 = new Service();
        service2.setServiceId(2);
        service2.setServiceName("Đánh Giá & Tư Vấn Hồ Cá");
        service2.setDescription("Đến địa chỉ của khách hàng đánh giá và tư vấn cải thiện hồ cá.");
        service2.setServicePrice(BigDecimal.valueOf(599000.0));

        Mockito.when(serviceService.getAllServices()).thenReturn(List.of(service1, service2));

        mockMvc.perform(get(ENDPOINT_PATH + "/all")
                        .contentType(REQUEST_CONTENT_TYPE))
                .andExpect(status().isOk())
                .andDo(print());
    }

}