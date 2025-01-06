import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyNotepadClone {
    private JTextArea textArea;
    private JFrame frame;

    public MyNotepadClone() {
        frame = new JFrame("My Notepad Clone");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem newItem = new JMenuItem("New");
        newItem.addActionListener(e -> newFile());
        fileMenu.add(newItem);

        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(e -> openFile());
        fileMenu.add(openItem);

        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(e -> saveFile());
        fileMenu.add(saveItem);

        JMenuItem saveAsItem = new JMenuItem("Save As");
        saveAsItem.addActionListener(e -> saveFileAs());
        fileMenu.add(saveAsItem);

        fileMenu.addSeparator();

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> exitApp());
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        JMenuItem cutItem = new JMenuItem("Cut");
        cutItem.addActionListener(e -> cutText());
        editMenu.add(cutItem);

        JMenuItem copyItem = new JMenuItem("Copy");
        copyItem.addActionListener(e -> copyText());
        editMenu.add(copyItem);

        JMenuItem pasteItem = new JMenuItem("Paste");
        pasteItem.addActionListener(e -> pasteText());
        editMenu.add(pasteItem);

        JMenuItem textColorItem = new JMenuItem("Text Color");
        textColorItem.addActionListener(e -> changeTextColor());
        editMenu.add(textColorItem);

        JMenuItem backgroundColorItem = new JMenuItem("Background Color");
        backgroundColorItem.addActionListener(e -> changeBackgroundColor());
        editMenu.add(backgroundColorItem);

        JMenuItem fontSizeItem = new JMenuItem("Font Size");
        fontSizeItem.addActionListener(e -> changeFontSize());
        editMenu.add(fontSizeItem);

        JMenuItem fontStyleItem = new JMenuItem("Font Style");
        fontStyleItem.addActionListener(e -> changeFontStyle());
        editMenu.add(fontStyleItem);

        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);


        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    private void newFile() {
        textArea.setText("");
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open File");
        int userSelection = fileChooser.showOpenDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToOpen = fileChooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(fileToOpen))) {
                textArea.setText("");
                String line;
                while ((line = br.readLine()) != null) {
                    textArea.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save File");
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileToSave))) {
                bw.write(textArea.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveFileAs() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save File As");
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileToSave))) {
                bw.write(textArea.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void exitApp() {
        int confirm = JOptionPane.showConfirmDialog(null, "Do you want to quit?", "Quit",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void cutText() {
        String selectedText = textArea.getSelectedText();
        if (selectedText != null) {
            textArea.cut();
        }
    }

    private void copyText() {
        String selectedText = textArea.getSelectedText();
        if (selectedText != null) {
            textArea.copy();
        }
    }

    private void pasteText() {
        textArea.paste();
    }
    private void changeTextColor() {
        Color selectedColor = JColorChooser.showDialog(frame, "Choose Text Color", textArea.getForeground());
        if (selectedColor != null) {
            textArea.setForeground(selectedColor);
        }
    }
    private void changeBackgroundColor() {
        Color selectedColor = JColorChooser.showDialog(frame, "Choose Background Color", textArea.getBackground());
        if (selectedColor != null) {
            textArea.setBackground(selectedColor);
        }
    }
    private void changeFontSize() {
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(12, 8, 72, 1));
        spinner.setValue(textArea.getFont().getSize());
    
        int result = JOptionPane.showConfirmDialog(frame, spinner, "Select Font Size", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int fontSize = (int) spinner.getValue();
            textArea.setFont(new Font(textArea.getFont().getName(), textArea.getFont().getStyle(), fontSize));
        }
    }
    private void changeFontStyle() {
        String[] fontStyles = {"Plain", "Bold", "Italic", "Bold Italic"};
        int result = JOptionPane.showOptionDialog(frame, "Select Font Style", "Font Style", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, fontStyles, fontStyles[0]);
        if (result != -1) {
            int fontStyle = 0;
            switch (result) {
                case 0:
                    fontStyle = Font.PLAIN;
                    break;
                case 1:
                    fontStyle = Font.BOLD;
                    break;
                case 2:
                    fontStyle = Font.ITALIC;
                    break;
                case 3:
                    fontStyle = Font.BOLD | Font.ITALIC;
                    break;
            }
            textArea.setFont(new Font(textArea.getFont().getName(), fontStyle, textArea.getFont().getSize()));
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyNotepadClone::new); // Updated to new class name
    }
}
