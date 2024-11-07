package org.baopen753.bookingappbackend.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.baopen753.bookingappbackend.controllers.ServiceController;
import org.baopen753.bookingappbackend.entities.Service;
import org.baopen753.bookingappbackend.services.serviceservice.ServiceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

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
    @WithMockUser(username = "cus_yen", password = "12345", authorities = "CUSTOMER")
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
        mockMvc.perform(get(ENDPOINT_PATH+"/"+service.getServiceId())
                .contentType(REQUEST_CONTENT_TYPE))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
