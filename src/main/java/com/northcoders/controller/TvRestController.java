package com.northcoders.controller;

import com.northcoders.model.Tv;
import com.northcoders.repository.TvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TvRestController {

    @Autowired
    protected TvRepository tvRepository;

    @CrossOrigin("*")
    @RequestMapping(value="/tvs", method = RequestMethod.GET)
    public List<Tv> getAllTvs() {
        return (List<Tv>)tvRepository.findAll();
    }

    @CrossOrigin("*")
    @RequestMapping(value="/tvs/{tvId}", method = RequestMethod.GET)
    public Tv getIndividualTv(@PathVariable Long tvId) {
        Tv tv = tvRepository.findOne(tvId);

        return tv;
    }

    @CrossOrigin("*")
    @RequestMapping(value="/tvs/{tvId}", method = RequestMethod.POST)
    public void saveTv(@RequestBody Tv tv) {
        tvRepository.save(tv);
    }
}
