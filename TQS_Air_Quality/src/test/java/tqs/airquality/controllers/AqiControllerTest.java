package tqs.airquality.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import tqs.airquality.entities.Aqi;
import tqs.airquality.entities.Data_JSON;
import tqs.airquality.services.AqiService;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AqiController.class)
public class AqiControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private AqiService service;

    @Test
    public void givenCity_whenSearching() throws Exception {
        Aqi portoAqi = new Aqi("ok", new Data_JSON(28, 8373));

        ResponseEntity<Aqi> returnObj = new ResponseEntity<>(portoAqi, HttpStatus.OK);

        given(service.search("newyork")).willReturn(returnObj);
        mvc.perform(get("/aqi/newyork").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.data.aqi", is(portoAqi.getData().getAqi()))).andExpect(jsonPath("$.data.idx", is(portoAqi.getData().getIdx())));
        verify(service, VerificationModeFactory.times(1)).search("newyork");
        reset(service);
    }

    @Test
    public void givenInvalidCity_whenSearching() throws Exception {
        given(service.search("123456789")).willReturn(null);
        mvc.perform(get("/aqi/123456789").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
        verify(service, VerificationModeFactory.times(1)).search("123456789");
        reset(service);
    }
}
