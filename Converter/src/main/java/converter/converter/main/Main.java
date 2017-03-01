package converter.converter.main;


import converter.converter.userinterface.UserInterface;

import javax.swing.*;

public class Main {

    /**
     * @param args no idea
     */

    public static void main(String[] args) {
        UserInterface kayttoliittyma = new UserInterface();
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
