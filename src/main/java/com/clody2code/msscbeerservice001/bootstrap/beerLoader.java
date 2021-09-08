package com.clody2code.msscbeerservice001.bootstrap;

import com.clody2code.msscbeerservice001.domain.Beer;
import com.clody2code.msscbeerservice001.repositories.IBeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class beerLoader implements CommandLineRunner {

    private  final IBeerRepository beerRepository;

    public beerLoader(IBeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {

        if (beerRepository.count() == 0) {
            Beer beer1 = Beer.builder().beerName("Mango Bobs").beerStyle("IPA").quantityToBrew(200).minOnHand(12).upc(33701000001L).price(new BigDecimal("12.95")).build();
            Beer beer2 = Beer.builder().beerName("Galaxy Cat").beerStyle("PALE_ALE").quantityToBrew(200).minOnHand(12).upc(33701000002L).price(new BigDecimal("11.95")).build();
            beerRepository.save(beer1);
            beerRepository.save(beer2);
        }
    }

}
