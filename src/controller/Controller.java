package controller;

import com.google.gson.JsonObject;
import crypters.Digester;
import models.Curriculum;
import sdk.Connection;

import java.util.ArrayList;
import java.util.Scanner;
import models.Book;

public class Controller {

    Scanner input;

    public Controller() {
        input = new Scanner(System.in);
    }

    public void menu() {

        System.out.println("***** Velkommen til Book It! ***** " +
                "\nDu har nu følgende muligheder: \n[1] Login \n[2] Opret bruger \n[3] Afslut session");

        switch (input.nextInt()) {

            case 1:
                logIn();
                break;
            case 2:
                createUser();
                break;
            case 3:
                exitProgram();
                break;
            default:
                System.out.println("Indtast gyldig valgmulighed");
                menu();
        }
    }

    public void logIn () {

        String username;
        String password;

        System.out.println("Du har valgt login " +
                "\n\nIndtast brugernavn:");
        //username = input.nextLine();
        input.nextLine();
        username = input.nextLine();
        System.out.println("Indtast adgangskode:");
        password = input.nextLine();

        String token = Connection.authorizeLogin(username, password);
        if(token != null){
            System.out.println("\nVelkommen " + username +
                    "\nDu har nu følgende muligheder: \n[1] Vis alle bøger \n[2] Vis bestemt bog \n[3] Hvis mulige studier og semestre \n[4] Log ud");

            switch (input.nextInt()) {
                case 1:
                    printBooks();
                    userMenu();
                case 2:
                    printBook();
                    userMenu();
                case 3:
                    printCurriculums();
                    break;
                case 4:
                    menu();
                default:
                    System.out.println("Indtast gyldig valgmulighed! \n");
                    userMenu();
                }

            while(true);//Brug noget andet en true. CurrentUser != null
            }
                else {System.out.println("Inkorrekte oplysninger indtastet");
                logIn();}

        }

        public void userMenu(){

            System.out.println("\n \nDu har følgede valgmuligheder: \n[1] Vis alle bøger \n[2] Vis bestemt bog \n[3] Hvis mulige studier og semestre \n[4] Log ud");

            switch (input.nextInt()) {
                case 1:
                    printBooks();
                    userMenu();
                case 2:
                    printBook();
                    userMenu();
                case 3:
                    printCurriculums();
                case 4:
                    menu();
                default:
                    System.out.println("Indtast gyldig valgmulighed! \n");
                    userMenu();


            while(true);//Brug noget andet en true. CurrentUser != null
        }}


    public void printBooks() {
        ArrayList<Book> books = Connection.getBooks();
        System.out.println("Book It's bogregister: ");
        for (models.Book book : books) {
            System.out.println("ID: " + book.getBookID() + ", Titel: " + book.getTitle());
        }
    }
    public void printBook() {
        System.out.println("Indast ID på den ønskede bog");
        Book book = Connection.getBook(input.nextInt());
        System.out.println("\nTitel: " + book.getTitle() + "\nPriser: \nAB: " + book.getPriceAB() + "\nCDON: " + book.getPriceCDON() + "\nSAXO: " + book.getPriceSAXO());
        userMenu();
    }

    public void printCurriculums() {
        ArrayList<Curriculum> curriculums = Connection.getCurriculums();
        System.out.println("Book It's uddanelsesregister: ");
        for (models.Curriculum curriculum : curriculums) {
            System.out.println("ID: " + curriculum.getCurriculumID() + ", Uddanelse: " + curriculum.getEducation() + ", Semester: " + curriculum.getSemester());
        }


        //do-/while-metode for søgning af bestemt semester
        int chooseCurriculum;
        do {

            System.out.println("Indtast ID-nr. for detaljer");
            while (!input.hasNextInt()) {
                System.out.println("Tast gyldigt ID!");
                input.next();
            }

            chooseCurriculum = input.nextInt();
        }
        while (chooseCurriculum <= 0 || chooseCurriculum > curriculums.size());
        ArrayList<Book> curriculumBooks = Connection.getCurriculumBooks(chooseCurriculum);
        System.out.println("\nSemesterbøgerne:");

        for (Book book : curriculumBooks) {
            System.out.println("ID: " + book.getBookID() + ", Titel: " + book.getTitle() + " - ISBN: " + book.getISBN());
        }


        System.out.println("[1] Bogdetaljer [2] Tilbage til brugermenuen");
            switch (input.nextInt()) {
                case 1:
                    printBook();
                    break;
                case 2:
                    userMenu();
                    break;
                default:
                    System.out.println("Ugyldigt input - du er derfor videresendt til brugermenuen");
                    userMenu();
        }
    }

    public void createUser() {

        System.out.println("Du har valgt at oprette ny bruger på BookIt, indtast venligst de følgende oplysninger:");

        JsonObject info = new JsonObject();
        Scanner input = new Scanner(System.in);

        System.out.print("Fornavn: ");
        info.addProperty("firstName", input.nextLine());

        System.out.print("Efternavn: ");
        info.addProperty("lastName", input.nextLine());

        System.out.print("E-mail: ");
        info.addProperty("email", input.nextLine());

        System.out.print("Ønsket brugernavn: ");
        info.addProperty("username", input.nextLine());

        System.out.print("Ønsket password: ");
        info.addProperty("password", Digester.hashWithSalt(input.nextLine()));

        info.addProperty("userType", "0");

        Connection.createUser(info);

        System.out.println("Bruger oprettet. Log venligst ind");

        logIn();

    }

    public void editUser() {



    }

    public void deleteUser() {



    }




    public void exitProgram() {



    }

}