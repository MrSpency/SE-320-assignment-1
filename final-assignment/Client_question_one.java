import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Client_question_one extends JFrame implements ActionListener {
    // Text field for receiving radius
    private JTextField jtf1 = new JTextField();
    private JTextField jtf2 = new JTextField();
    

    // Text area to display contents
    private JTextArea jta = new JTextArea();

    // IO streams
    private DataOutputStream outputToServer;
    private DataInputStream inputFromServer;

    public static void main(String[] args) {
        new Client_question_one();
    }

    public Client_question_one() {
        // Panel p to hold the label and text field
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,2));
        p.add(new JLabel("Enter person weight"));
        p.add(jtf1);
        p.add(new JLabel("Enter person height"));
        p.add(jtf2);


        jtf1.setHorizontalAlignment(JTextField.RIGHT);
        jtf2.setHorizontalAlignment(JTextField.RIGHT);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(p, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);

        jtf1.addActionListener(this); // Register listener
        jtf2.addActionListener(this);

        setTitle("Client");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); // It is necessary to show the frame here!

        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 8000);
            // Create an input stream to receive data from the server
            inputFromServer = new DataInputStream(socket.getInputStream());
            // Create an output stream to send data to the server
            outputToServer = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            jta.append(ex.toString() + '\n');
        }
    }
        
        public void actionPerformed(ActionEvent e) {
            String actionCommand = e.getActionCommand();
            if (e.getSource() instanceof JTextField) {
                try {
                    // Get the radius from the text field
                    double person_weight = Double.parseDouble(jtf1.getText().trim());
                    double person_height = Double.parseDouble(jtf2.getText().trim());
        
                    // Send the radius to the server
                    outputToServer.writeDouble(person_weight);
                    outputToServer.writeDouble(person_height);
                    outputToServer.flush();
        
                    // Get area from the server
                    double bmi = inputFromServer.readDouble();
        
                    // Display to the text area
                    //jta.append("Person weight is " + person_weight + "\n");
                    //jta.append("Person height is " + person_height + "\n");
                    jta.append("BMI received from the server is " + bmi + "\n");
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            }
        }
    }
        


