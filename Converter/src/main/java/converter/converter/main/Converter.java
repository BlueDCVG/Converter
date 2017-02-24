package converter.converter.main;

import converter.converter.userinterface.UserInterface;

import javax.swing.*;

/**
 * This will communicate between the reader, writer and UI.
 */

public class Converter {

    public static void main() {
        UserInterface kayttoliittyma = new UserInterface();
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
