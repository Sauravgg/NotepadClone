# NotepadClone
# Project Setup:

The provided code is a simple Java Swing application that mimics the functionality of a basic text editor, similar to Notepad. Here's a breakdown of the code:

Class Declaration
java
Insert Code
Edit
Copy code
public class MyNotepadClone {
The class MyNotepadClone is declared as public, meaning it can be accessed from other classes.

Instance Variables
java
Insert Code
Edit
Copy code
private JTextArea textArea;
A JTextArea named textArea is declared, which will be used to display and edit text.

Constructor
java
Insert Code
Edit
Copy code
public MyNotepadClone() {
This is the constructor for the MyNotepadClone class. It sets up the GUI components of the application.

JFrame Setup:

java
Insert Code
Edit
Copy code
JFrame frame = new JFrame("My Notepad Clone");
frame.setSize(600, 400);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
A JFrame is created with the title "My Notepad Clone". The size is set to 600x400 pixels, and the default close operation is set to exit the application when the window is closed.

Text Area:

java
Insert Code
Edit
Copy code
textArea = new JTextArea();
textArea.setLineWrap(true);
textArea.setWrapStyleWord(true);
frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
A JTextArea is instantiated, and line wrapping is enabled. The text area is added to the center of the frame within a JScrollPane, allowing for scrolling if the text exceeds the visible area.

Menu Bar:

java
Insert Code
Edit
Copy code
JMenuBar menuBar = new JMenuBar();
JMenu fileMenu = new JMenu("File");
menuBar.add(fileMenu);
A JMenuBar is created, with a single menu labeled "File".

Menu Items: Several JMenuItem objects are created for various functionalities:

New: Clears the text area.
Open: Opens a file chooser to select a file to open and read its contents into the text area.
Save: Opens a file chooser to save the contents of the text area to a file.
Exit: Prompts the user to confirm if they want to exit the application.
java
Insert Code
Edit
Copy code
JMenuItem newItem = new JMenuItem("New");
newItem.addActionListener(e -> newFile());
fileMenu.add(newItem);
// Similar code for openItem, saveItem, and exitItem
Setting the Menu Bar:

java
Insert Code
Edit
Copy code
frame.setJMenuBar(menuBar);
frame.setVisible(true);
The menu bar is added to the frame, and the frame is made visible.

Method Definitions
newFile(): Clears the text area.
openFile(): Opens a file chooser dialog, reads the selected file, and populates the text area with its content.
saveFile(): Opens a file chooser dialog, saves the current text area content to the selected file.
exitApp(): Prompts the user to confirm quitting the application. If confirmed, the application exits.
Main Method
java
Insert Code
Edit
Copy code
public static void main(String[] args) {
    SwingUtilities.invokeLater(MyNotepadClone::new);
}
The main method is the entry point of the application. It uses SwingUtilities.invokeLater to ensure that the GUI is created on the Event Dispatch Thread (EDT), which is the standard practice for Swing applications.

Summary
Overall, this code creates a simple text editor with basic functionalities: creating a new document, opening existing files, saving documents, and exiting the application. The use of Swing components provides a graphical user interface for these operations.

# REQUIREMENTS:

1.  windows 
2.  Vscode 
3.  Java extension pack
4.  Java development kit

# How to run:

1.  Open the the code in vscode
2.  Go to run button and click the down arrow
3.  Press the run java button
4.  The code will run

