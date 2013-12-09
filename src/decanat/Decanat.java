package decanat;

import java.io.IOException;

public class Decanat {

    public Decanat() {
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserChoiceMenu menu = new UserChoiceMenu();
        menu.MenuSelect();
    }
}
