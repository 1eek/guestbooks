package com.leek.guestbooks.repositories;

import com.leek.guestbooks.pojo.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,Long> {

    User findByName(String name);

    User findByNameAndPassword(String name,String password);
}
