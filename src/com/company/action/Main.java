package com.company.action;

import com.company.model.Author;
import com.company.model.Book;
import com.company.model.City;
import com.company.repository.*;
import com.company.service.CityService;
import com.company.service.CityServiceImpl;
import com.company.util.Reader;
import com.company.util.ReaderImpl;
import com.company.util.Writer;
import com.company.util.WriterImpl;
import com.company.validator.CityValidator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Writer writer = new WriterImpl();
        Reader reader = new ReaderImpl();

        CityService cityService = new CityServiceImpl();
        CityValidator cityValidator = new CityValidator();
        CityAction cityAction = new CityActionImpl(writer,reader,cityValidator,cityService);
        cityAction.add();
        cityAction.add();
        cityAction.findAll();
        cityAction.getById();

        cityAction.add();
        cityAction.findAll();
    }
}
