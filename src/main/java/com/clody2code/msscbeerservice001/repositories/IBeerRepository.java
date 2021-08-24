package com.clody2code.msscbeerservice001.repositories;

import com.clody2code.msscbeerservice001.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface IBeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
