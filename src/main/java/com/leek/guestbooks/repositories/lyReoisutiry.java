package com.leek.guestbooks.repositories;

import com.leek.guestbooks.pojo.*;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface lyReoisutiry extends PagingAndSortingRepository<ly,Long> {
    Iterable<ly> findAll();
    ly save(ly ly);

}
