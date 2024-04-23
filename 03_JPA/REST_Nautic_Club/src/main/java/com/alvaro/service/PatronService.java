package com.alvaro.service;

import com.alvaro.model.Patron;

import java.util.List;

public interface PatronService {
    List<Patron> getAllPatrones();
    Patron getPatronById(Long id);
    Patron createPatron(Patron patron);
    Patron updatePatron(Long id, Patron patron);
    void deletePatron(Long id);
}
