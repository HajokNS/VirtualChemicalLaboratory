package com.chornopyskyi.chemicallaboratory.chemicallaboratory;


import com.chornopyskyi.chemicallaboratory.model.User;
import com.chornopyskyi.chemicallaboratory.view.Menu;


public class Application {

    public static User[] users;

    public static User currentUser = new User( "Den32131", "Denis123@gmail.com", "Denis123qwert",  "");

    public static void runner() throws IllegalAccessException {
        Menu.show();
    }

    public static void main(String[] args) throws IllegalAccessException {

        runner();
    }

}
