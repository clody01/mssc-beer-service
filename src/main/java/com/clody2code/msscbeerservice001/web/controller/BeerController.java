package com.clody2code.msscbeerservice001.web.controller;


import com.clody2code.msscbeerservice001.services.IBeerService;
import com.clody2code.msscbeerservice001.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final IBeerService beerService;

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {

        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveBeer(@Valid @RequestBody BeerDto beerDto) {
       // HttpHeaders headers = new HttpHeaders();
        //headers.add("Location", "/api/v1/beer/" + UUID.randomUUID());

        return new ResponseEntity(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto) {

        return new ResponseEntity(beerService.updateBeer(beerId, beerDto),HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    public ResponseEntity deleteBeer(@PathVariable("beerId") UUID beerId) {
        //todo impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
