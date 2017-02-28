package converter.converter.userinterface;

import converter.converter.corelogic.Reader;
import converter.converter.corelogic.WriterOma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserInterface implements Runnable {

    private JFrame frame;
    private JFileChooser fileChoser;
    private File[] selectedFiles;
    private JLabel filesSelected;
    private JTextField nameField;
    private JComboBox actionSelector;

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
        fileChoser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(4, 2);
        container.setLayout(layout);

        String[] actions = {"Concentrations", "Responses"};

        JLabel nameText = new JLabel("CSV file name");
        nameField = new JTextField("");
        JLabel actionText = new JLabel("Select type of data printed: ");
        actionSelector = new JComboBox(actions);
        filesSelected = new JLabel("0 directories selected");

        JButton addFilesButton = new JButton("Select files");
        addFilesButton.addActionListener((ActionEvent e) -> {
                int retVal = fileChoser.showOpenDialog(frame);
                if (retVal == JFileChooser.APPROVE_OPTION) {
                    selectedFiles = fileChoser.getSelectedFiles();
                    //Arrays.stream(selectedFiles).map(File::getName).collect(Collectors.joining(", "))
                    updateFilesSelectedText(selectedFiles.length);
                }
        });

        JButton startButton = new JButton("Start conversion");
        startButton.addActionListener((ActionEvent e) -> {
            if(selectedFiles != null && selectedFiles.length > 0) {
                if(!nameField.getText().isEmpty()) {
                    Reader reader = new Reader();

                    Stream<File> fileStream = Stream.of(selectedFiles);
                    ArrayList<File> resultFiles = new ArrayList<>(fileStream.filter(dir -> new File(dir, "results.txt").exists()).map(dir -> new File(dir, "results.txt")).collect(Collectors.toList()));


                    if (resultFiles.size() > 0) {
                        reader.setFiles(resultFiles);
                        WriterOma writer = new WriterOma(selectedFiles[0].getParentFile(), nameField.getText());

                        writer.newSheet(reader.dataList());

                        if (1 == actionSelector.getSelectedIndex()) {
                            writer.printResponseAll();
                        } else {
                            writer.printConcAll();
                        }
                        writer.jobDone();
                        JOptionPane.showMessageDialog(frame, "Job done!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "There where no result.txt files found in the directories selected!", "Error no results found!", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(frame, "There has to be a name set to the file!", "Error no file name set!", JOptionPane.ERROR_MESSAGE);
                }
            }else {
                JOptionPane.showMessageDialog(frame, "There where no directories selected!", "Error no results found!", JOptionPane.ERROR_MESSAGE);

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

    public void updateFilesSelectedText(int numberOfDirs) {
        filesSelected.setText(numberOfDirs + (numberOfDirs == 1 ? " directory selected." : " directories selected."));
    }
}
