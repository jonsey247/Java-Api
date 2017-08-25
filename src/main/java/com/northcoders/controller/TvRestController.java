package com.northcoders.controller;

import com.northcoders.model.Tv;
import com.northcoders.repository.TvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TvRestController {

    private final Logger logger = LoggerFactory.getLogger(TvRestController.class);

    @Autowired
    protected TvRepository tvRepository;

    @CrossOrigin("*")
    @RequestMapping(value="/tvs", method = RequestMethod.GET)
    public List<Tv> getAllTvs() {

         List<Tv> tvs = (List<Tv>)tvRepository.findAll();

        logger.debug("get all properties {}", tvs);

         return tvs;
    }

    @CrossOrigin("*")
    @RequestMapping(value="/tvs/{tvId}", method = RequestMethod.GET)
    public Tv getIndividualTv(@PathVariable Long tvId) {

        logger.debug("get individual TV STARTED");

        Tv tv = tvRepository.findOne(tvId);

        if(tv == null) {
            logger.warn("Tv {} does not exist", tvId);
        }

        logger.debug("get individual Tv ENDED");

        return tv;
    }

    @CrossOrigin("*")
    @RequestMapping(value="/tvs/{tvId}", method = RequestMethod.POST)
    public void saveTv(@Valid @RequestBody Tv tv, HttpServletResponse response) {

        logger.debug("Tv add has STARTED");

        tvRepository.save(tv);

        logger.debug("new Tv succesfully added");

        response.setStatus(HttpServletResponse.SC_ACCEPTED);
    }
}
