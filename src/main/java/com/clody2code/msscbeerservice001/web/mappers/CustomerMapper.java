package com.clody2code.msscbeerservice001.web.mappers;

import com.clody2code.msscbeerservice001.domain.Customer;
import com.clody2code.msscbeerservice001.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(uses={DateMapper.class})
public interface CustomerMapper {
    CustomerDto  customerToCustomerDto(Customer customer);
    Customer  customerDtoToCustomer(CustomerDto customerDto);
}
