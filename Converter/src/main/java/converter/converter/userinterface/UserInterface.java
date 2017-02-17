package converter.converter.userinterface;

import converter.converter.corelogic.Converter;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable {

    private JFrame frame;
    private JFileChooser fileChoser;

    public UserInterface() {
    }

    @Override
    public void run() {
        frame = new JFrame("Converter");
        frame.setPreferredSize(new Dimension(500, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 2);
        container.setLayout(layout);

        String[] actions = {"Concentrations", "Responses"};

        JLabel nameText = new JLabel("CSV file name: ");
        JTextField nameField = new JTextField();
        JLabel actionText = new JLabel("Select type of data printed: ");
        JComboBox actionSelector = new JComboBox(actions);

        JButton addButton = new JButton("Select files");
        JButton startButton = new JButton("Start conversion");



        container.add(nameText);
        container.add(nameField);
        container.add(actionText);
        container.add(actionSelector);
        container.add(addButton);
        container.add(startButton);
    }

    public JFrame getFrame() {
        return frame;
    }

}
