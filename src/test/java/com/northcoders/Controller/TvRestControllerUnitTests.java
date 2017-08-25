package com.northcoders.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.controller.TvRestController;
import org.junit.Assert;
import java.util.List;
import java.util.ArrayList;
import com.northcoders.model.Tv;
import com.northcoders.repository.TvRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TvRestController.class)
public class TvRestControllerUnitTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TvRepository tvRepository;

    @Test
    public void showIndividualCar() throws Exception {

        Tv tv = new Tv();

        tv.setTvId(1L);
        tv.setTvModel("Sony");
        tv.setWattage(600);

        Mockito.when(tvRepository.findOne(Mockito.anyLong())).thenReturn(tv);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/tvs/1").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{tvId:1,tvModel:Sony,wattage:600}";

        System.out.println(result.getResponse().getContentAsString());

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void multipleTvs() throws Exception {

        Tv tv1 = new Tv();
        Tv tv2 = new Tv();

        tv1.setTvId(1L);
        tv1.setTvModel("Sony");
        tv1.setWattage(600);

        tv2.setTvId(2L);
        tv2.setTvModel("Sony");
        tv2.setWattage(600);


        List<Tv> tvs = new ArrayList<Tv>();

        tvs.add(tv1);
        tvs.add(tv2);

        Mockito.when(tvRepository.findAll()).thenReturn(tvs);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/tvs").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "[{tvId:1,tvModel:Sony,wattage:600}, {tvId:2,tvModel:Sony,wattage:600}]";

        System.out.println(result.getResponse().getContentAsString());

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void saveTv() throws Exception {

        Tv tv = new Tv();

        tv.setTvModel("Samsung");
        tv.setWattage(600);

        String carJson = new ObjectMapper().writeValueAsString(tv);

        Mockito.when(tvRepository.save(tv)).thenReturn(tv);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/tvs/-1").contentType(MediaType.APPLICATION_JSON).content(carJson);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        Mockito.verify(tvRepository, Mockito.times(1)).save(Mockito.any(Tv.class));
        Assert.assertEquals(202, result.getResponse().getStatus());
    }
}
