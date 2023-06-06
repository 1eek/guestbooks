package com.leek.guestbooks.Service;

import com.leek.guestbooks.pojo.ly;
import com.leek.guestbooks.repositories.lyReoisutiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class lyService {
    @Autowired
    lyReoisutiry lyReoisutiry;

    public Iterable<ly> getAll() {
        return lyReoisutiry.findAll();
    }
}
