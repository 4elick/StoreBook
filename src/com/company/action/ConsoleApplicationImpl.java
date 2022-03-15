package com.company.action;

import com.company.model.Book;
import com.company.model.Session;
import com.company.util.Reader;
import com.company.util.Writer;

import java.util.List;

public class ConsoleApplicationImpl implements ConsoleApplication {
    Writer writer;
    Reader reader;
    UserAction userAction;
    AddressAction addressAction;
    AuthorAction authorAction;
    BookAction bookAction;
    CityAction cityAction;
    StoreAction storeAction;
    static Session activateSession;


    public ConsoleApplicationImpl(Writer writer, Reader reader, UserAction userAction, AddressAction addressAction, AuthorAction authorAction, BookAction bookAction, CityAction cityAction, StoreAction storeAction) {
        this.writer = writer;
        this.reader = reader;
        this.userAction = userAction;
        this.addressAction = addressAction;
        this.authorAction = authorAction;
        this.bookAction = bookAction;
        this.cityAction = cityAction;
        this.storeAction = storeAction;
    }

    @Override
    public void run() {
        createStore();
        chose();
    }

    private void createStore() {
        addressAction.add();
        cityAction.add();
        storeAction.add();
        authorAction.add();
        bookAction.add();
    }

    private void chose() {
        userAction.registration();
        userAction.authorization();

        while (true) {
            showMenu();
            int key = reader.readInt();
            if (activateSession == null) {
                switch (key){
                    case 0:
                        return;
                    case 1:
                        userAction.registration();
                        break;
                    case 2:
                        userAction.authorization();
                        break;
                }
            } else {
                switch (key) {

                    case 0:
                        return;
                    case 1:
                        authorAction.findByName();
                        break;
                    case 2:
                        authorAction.findAll();

                        break;
                    case 3:
                        bookAction.findByTitle();
                        break;
                    case 4:
                        bookAction.findByAuthor();
                        break;
                    case 5:
                        bookAction.addBookInBasket();
                        break;
                    case 6:
                        basketMenu();
                        break;
                    case 7:
                        activateSession = null;
                        break;
                    default:
                        writer.write("Unknown command");
                }
            }
        }

    }

    private void showMenu() {
        if (activateSession == null) {
            writer.write("0 - Exit");
            writer.write("1 - Registration.");
            writer.write("2 - Authorization.");
        } else {
            writer.write("0 - Exit");
            writer.write("1 - Find a author by name.");
            writer.write("2 - Show authors.");
            writer.write("3 - Find book by name.");
            writer.write("4 - Find book by author.");
            writer.write("5 - Add a book in basket.");
            writer.write("6 - View my basket");
            writer.write("7 - Exit from account");
        }
    }

    private void basketMenu(){
        List<Book> books = activateSession.getBasket().getBooks();
        for (Book book : books) {
            writer.write("Your books");
            writer.write(book.getId() + " " + book.getAuthor().getName() + " " + book.getTitle());
        }
    }
}
