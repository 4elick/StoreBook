package com.company.action;

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
        StoreService storeService = new StoreServiceImpl();
        BookService bookService = new BookServiceImpl();
        AuthorService authorService = new AuthorServiceImpl();
        UserAction userAction = new UserActionImpl(writer,reader,new UserServiceImpl(),new UserValidator(),new SessionServiceImpl());
        AddressAction addressAction = new AddressActionImpl(writer,reader,addressService,new AddressValidator(),cityService);
        AuthorAction authorAction = new AuthorActionImpl(writer,reader,authorService,new AuthorValidator());
        BookAction bookAction = new BookActionImpl(bookService,authorService,writer,reader);
        CityAction cityAction = new CityActionImpl(writer,reader,new CityValidator(),cityService);
        StoreAction storeAction = new StoreActionImpl(writer,reader,storeService,cityService,addressService);
        OrderAction orderAction = new OrderActionImpl(writer,reader,new OrderServiceImpl(),storeService);
        BasketAction basketAction = new BasketActionImpl(bookService,writer,reader);
        ConsoleApplication consoleApplication = new ConsoleApplicationImpl(writer,reader,userAction,addressAction,authorAction,bookAction,cityAction,storeAction,orderAction,basketAction);
        consoleApplication.run();
    }
}
