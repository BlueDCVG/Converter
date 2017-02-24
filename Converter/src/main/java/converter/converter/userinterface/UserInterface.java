package converter.converter.userinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class UserInterface implements Runnable {

    private JFrame frame;
    private JFileChooser fileChoser;
    private File[] selectedFiles;

    public UserInterface() {
    }

    @Override
    public void run() {
        frame = new JFrame("Converter");
        fileChoser = new JFileChooser();

        frame.setPreferredSize(new Dimension(500, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        fileChoser.setMultiSelectionEnabled(true);
        fileChoser.setCurrentDirectory(new File("C:\\tmp"));

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(4, 2);
        container.setLayout(layout);

        String[] actions = {"Concentrations", "Responses"};

        JLabel nameText = new JLabel("CSV file name: ");
        JTextField nameField = new JTextField("CSV file name");
        JLabel actionText = new JLabel("Select type of data printed: ");
        JComboBox actionSelector = new JComboBox(actions);
        JLabel filesSelected = new JLabel(" files selected");

        JButton addFilesButton = new JButton("Select files");
        JButton startButton = new JButton("Start conversion");
        addFilesButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int retVal = fileChoser.showOpenDialog(frame);
                selectedFiles = fileChoser.getSelectedFiles();
            }

        });


        container.add(nameText);
        container.add(nameField);
        container.add(actionText);
        container.add(actionSelector);
        container.add(addFilesButton);
        container.add(filesSelected);
        container.add(new JLabel(""));
        container.add(startButton);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void actionPerformed(ActionEvent e) {
        int retVal = fileChoser.showOpenDialog(frame);
        if (retVal == JFileChooser.APPROVE_OPTION) {
            File[] selectedfiles = fileChoser.getSelectedFiles();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < selectedfiles.length; i++) {
                sb.append(selectedfiles[i].getName() + "\n");
            }
            JOptionPane.showMessageDialog(frame, sb.toString());
        }

    }
}
