package sdk;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import crypters.Crypter;
import models.Curriculum;
import models.Login;

import models.Book;
import java.util.ArrayList;

public class Connection {

    public static String authorizeLogin(String username, String password) {

        Login login = new Login(username, password);


        ClientResponse clientResponse = HTTPrequests.post("/user/login", new Gson().toJson(login));
        String token = null;

        if (clientResponse == null) {
            System.out.println("Forbindelse til server ikke fundet");
        } else {
            String json = clientResponse.getEntity(String.class);
            if (clientResponse.getStatus() == 200) {
                token = json;
            } else {
                System.out.println("");
            }
        }
        clientResponse.close();
        return token;
    }

    public static ArrayList<models.Book> getBooks() {
        ClientResponse clientResponse = HTTPrequests.get("book/");
        ArrayList<Book> books = null;

        if (clientResponse == null) {
            System.out.println("SDK not found");
        } else {
            String encryptedJson = clientResponse.getEntity(String.class);
            if (clientResponse.getStatus() == 200) {
                String decryptedJson = Crypter.encryptDecryptXOR(encryptedJson);
                books = new Gson().fromJson(decryptedJson, new TypeToken<ArrayList<Book>>() {
                }.getType());
            } else {
                System.out.println("Server error! :-(");
            }
        }
        clientResponse.close();
        return books;
    }

    public static models.Book getBook(int id) {
        ClientResponse clientResponse = HTTPrequests.get("book/" + id);
        Book book = null;

        if (clientResponse == null) {
            System.out.println("SDK not found");
        } else {
            String encryptedJson = clientResponse.getEntity((String.class));
            if (clientResponse.getStatus() == 200) {
                String decryptedJson = Crypter.encryptDecryptXOR(encryptedJson);
                book = new Gson().fromJson(decryptedJson, Book.class);
            } else {
                System.out.println("Server error! :-(");
            }
        }
        clientResponse.close();
        return book;

    }

    public static ArrayList<models.Curriculum> getCurriculums() {
        ClientResponse clientResponse = HTTPrequests.get("curriculum/");
        ArrayList<Curriculum> curriculums = null;

        if (clientResponse == null) {
            System.out.println("SDK not found");
        } else {
            String encryptedJson = clientResponse.getEntity(String.class);
            if (clientResponse.getStatus() == 200) {
                String decryptedJson = Crypter.encryptDecryptXOR(encryptedJson);
                curriculums = new Gson().fromJson(decryptedJson, new TypeToken<ArrayList<Curriculum>>() {
                }.getType());
            } else {
                System.out.println("Server error! :-(");
            }
        }
        clientResponse.close();
        return curriculums;

    }

    public static ArrayList<Book> getCurriculumBooks(int curriculumId) {
        ClientResponse clientResponse = HTTPrequests.get("/curriculum/" + curriculumId + "/books");
        ArrayList<Book> books = null;

        if (clientResponse == null) {
            System.out.println("SDK not found");
        } else {
            String encryptedJson = clientResponse.getEntity(String.class);
            if (clientResponse.getStatus() == 200) {
                String decryptedJson = Crypter.encryptDecryptXOR(encryptedJson);
                books = new Gson().fromJson(decryptedJson, new TypeToken<ArrayList<Book>>() {
                }.getType());
            } else {
                System.out.println("Server error! :-(");
            }
        }
        clientResponse.close();
        return books;

    }
    //HTTP POST
    public static String createUser(JsonObject info) {
        ClientResponse clientResponse = HTTPrequests.post("/user/", Crypter.encryptDecryptXOR(new Gson().toJson(info)));
        String response = null;

        if (clientResponse == null) {
            System.out.println("SDK not found");
        } else {
            response = clientResponse.getEntity(String.class);
            if (clientResponse.getStatus() == 200) {
                System.out.println(response);
            } else {
                System.out.println("Server error! :-(");
            }
        }
        clientResponse.close();
        return response;

    }
     //HTTP PUT
    //public static String editUser (JsonObject info) {
   // }

      //public static String deleteUser (JsonObject info) {
     //   System.out.println("hej");
    // }

}


