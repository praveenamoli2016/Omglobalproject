package com.omglobal.omglobal.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.omglobal.omglobal.model.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostResponse {

    List<Customer> content;
    private int pageNumber;
    private int pageSize;
    private int totalElements;
    private int totalPages;
    private boolean lastPage;

}
