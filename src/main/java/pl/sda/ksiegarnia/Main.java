package pl.sda.ksiegarnia;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Author biblia = new Author("Bóg", "Jezus");
        Author olga = new Author("Olga", "Tokarczuk");
        Author mateusz = new Author("Mateusz", "Sarnowski");
        Cathegory religia = new Cathegory("Religia");
        Cathegory powiesc = new Cathegory("Powieść");
        Cathegory edukacja = new Cathegory("Edukacja");

        Book book = new Book("Biblia", biblia, religia);
        Book book1 = new Book("Brewiaż", biblia, religia);
        Book book2 = new Book("Księgi Jakubowe", olga, powiesc);
        Book book3 = new Book("Prawiek i inne czasy", olga, powiesc);
        Book book4 = new Book("Analiza Matematyczna według Mateusza", mateusz, edukacja);
        Book book5 = new Book("Fizyka Kwantowa według Mateusza", mateusz, edukacja);

        List<Book> listaKsiazek = new ArrayList<>();
        listaKsiazek.add(book);
        listaKsiazek.add(book1);
        listaKsiazek.add(book2);
        listaKsiazek.add(book3);
        listaKsiazek.add(book4);
        listaKsiazek.add(book5);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("lista.json"), listaKsiazek);
        } catch (IOException e){
            e.printStackTrace();
        }
        try {
            Book[] books = objectMapper.readValue (new File ("lista.json"),  Book[].class);
            for (Book booking: books) {
                System.out.println (booking.getAuthor().getName() + " " + booking.getAuthor().getLastname() + " " + booking.getCathegory().getName() + " " + booking.getName());
            }
        } catch (IOException e) {
            e.printStackTrace ( );
        }
   }
}
