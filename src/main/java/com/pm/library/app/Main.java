package com.pm.library.app;

import com.pm.library.services.LibraryService;
import com.pm.library.services.dto.BookCreateRequest;
 
import com.pm.library.ui.ConsoleIO;
import com.pm.library.ui.ConsoleMenu;

public class Main {
    public static void main(String[] args) {
        LibraryService svc = AppConfig.libraryService();
        ConsoleIO io = new ConsoleIO();
        ConsoleMenu menu = new ConsoleMenu();

        while (true) {
            menu.showMain();
            String choice = io.readLine("Select: ");
            if (choice == null) break;

            switch (choice.trim()) {
                case "1" -> {
                    String title = io.readLine("Title: ");
                    String author = io.readLine("Author: ");
                    var res = svc.add(new BookCreateRequest(title, author));
                    if (res.isOk()) io.println("Added: " + res.getValue().title());
                    else io.println("Error: " + res.errorCode() + " - " + res.message());
                }
                case "2" -> {
                    String title = io.readLine("Title to borrow: ");
                    var r = svc.borrow(title);
                    if (r.isOk()) io.println("Borrowed: " + r.getValue().title());
                    else io.println("Error: " + r.errorCode());
                }
                case "3" -> {
                    String title = io.readLine("Title to return: ");
                    var r = svc.returnBook(title);
                    if (r.isOk()) io.println("Returned: " + r.getValue().title());
                    else io.println("Error: " + r.errorCode());
                }
                case "0" -> {
                    io.println("Bye");
                    return;
                }
                default -> io.println("Not implemented in demo");
            }
        }
    }
}
