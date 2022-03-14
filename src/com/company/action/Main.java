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
        Main main = new Main();
        main.run();


    }
    private  void run(){
        Writer writer = new WriterImpl();
        Reader reader = new ReaderImpl();
        AddressService addressService = new AddressServiceImpl();
        CityService cityService = new CityServiceImpl();
        AuthorService authorService = new AuthorServiceImpl();
        UserAction userAction = new UserActionImpl(writer,reader,new UserServiceImpl(),new UserValidator());
        AddressAction addressAction = new AddressActionImpl(writer,reader,addressService,new AddressValidator(),cityService);
        AuthorAction authorAction = new AuthorActionImpl(writer,reader,authorService,new AuthorValidator());
        BookAction bookAction = new BookActionImpl(new BookServiceImpl(),authorService,writer,reader);
        CityAction cityAction = new CityActionImpl(writer,reader,new CityValidator(),cityService);
        StoreAction storeAction = new StoreActionImpl(writer,reader,new StoreServiceImpl(),cityService,addressService);
        ConsoleApplication consoleApplication = new ConsoleApplicationImpl(writer,reader,userAction,addressAction,authorAction,bookAction,cityAction,storeAction);
        consoleApplication.run();
    }
}
