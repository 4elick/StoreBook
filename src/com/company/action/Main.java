package com.company.action;

import com.company.model.Author;
import com.company.model.Book;
import com.company.model.City;
import com.company.repository.*;
import com.company.service.*;
import com.company.util.Reader;
import com.company.util.ReaderImpl;
import com.company.util.Writer;
import com.company.util.WriterImpl;
import com.company.validator.AddressValidator;
import com.company.validator.AuthorValidator;
import com.company.validator.CityValidator;
import com.company.validator.UserValidator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Writer writer = new WriterImpl();
        Reader reader = new ReaderImpl();
        UserValidator userValidator = new UserValidator();
        UserService userService = new UserServiceImpl();
        UserAction userAction = new UserActionImpl(writer,reader,userService,userValidator);
        userAction.add();
      /*  CityService cityService = new CityServiceImpl();
        CityValidator cityValidator = new CityValidator();
        CityAction cityAction = new CityActionImpl(writer,reader,cityValidator,cityService);
        cityAction.add();
        cityAction.add();
        cityAction.findAll();
        AuthorService authorService = new AuthorServiceImpl();
        AuthorValidator authorValidator = new AuthorValidator();
        AuthorAction authorAction = new AuthorActionImpl(writer,reader,authorValidator,authorService);
        AddressValidator addressValidator = new AddressValidator();
        AddressService addressService = new AddressServiceImpl();
        AddressAction addressAction = new AddressActionImpl(writer,reader,addressService,addressValidator,cityService);
        addressAction.add();
        addressAction.add();
        addressAction.findAll();
        System.out.println();
        addressAction.findByStreet();
        System.out.println();
        addressAction.getById();

        addressAction.add();
        addressAction.findAll();
        addressAction.add();
        addressAction.findByStreet();
        addressAction.getById();*/


    }
}
