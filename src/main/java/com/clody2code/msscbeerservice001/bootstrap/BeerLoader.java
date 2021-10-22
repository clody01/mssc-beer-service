package com.clody2code.msscbeerservice001.bootstrap;

import com.clody2code.msscbeerservice001.domain.Beer;
import com.clody2code.msscbeerservice001.repositories.IBeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class BeerLoader implements CommandLineRunner {

    public final String BEER_1_UPC = "0631234200036";
    public final String BEER_2_UPC = "0631234300019";
    public final String BEER_3_UPC = "0083783375213";

    private final IBeerRepository beerRepository;

    public BeerLoader(IBeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {

        if (beerRepository.count() == 0) {
            Beer beer1 = Beer.builder().beerName("Mango Bobs").beerStyle("IPA").quantityToBrew(200).minOnHand(12).upc(BEER_1_UPC).price(new BigDecimal("12.95")).build();
            Beer beer2 = Beer.builder().beerName("Galaxy Cat").beerStyle("PALE_ALE").quantityToBrew(200).minOnHand(12).upc(BEER_2_UPC).price(new BigDecimal("11.95")).build();
            Beer beer3 = Beer.builder().beerName("No Hammers on the bar").beerStyle("PALE_ALE").quantityToBrew(200).minOnHand(12).upc(BEER_3_UPC).price(new BigDecimal("11.95")).build();
            beerRepository.save(beer1);
            beerRepository.save(beer2);
        }
    }

}
