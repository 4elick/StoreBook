package com.company.action;

import com.company.util.Reader;
import com.company.util.Writer;

public class ConsoleApplicationImpl implements ConsoleApplication {
    Writer writer;
    Reader reader;
    UserAction userAction;
    AddressAction addressAction;
    AuthorAction authorAction;
    BookAction bookAction;
    CityAction cityAction;
    StoreAction storeAction;

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
        writer.write("Please,registration to continue");
        userAction.add();
        boolean cycle = true;
        while (cycle) {
            showMenu();
            int key = reader.readInt();
            switch (key) {
                case 0:
                    cycle = false;
                    break;
                case 1:
                    authorAction.findByName();
                    break;
                case 2:
                    authorAction.findAll();;
                    break;
                case 3:
                    bookAction.findByTitle();
                    break;
                case 4:
                    bookAction.findByAuthor();
                    break;
                default:
                    writer.write("Unknown command");
            }
        }
    }

    private void showMenu() {

        writer.write("0 - Exit");
        writer.write("1 - Find a author by name.");
        writer.write("2 - Show authors.");
        writer.write("3 - Find book by name.");
        writer.write("4 - Find book by author.");

    }
}
