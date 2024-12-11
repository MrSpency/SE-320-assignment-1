import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Server_question_one extends JFrame {
    // Text area for displaying contents
    private JTextArea jta = new JTextArea();

    public static void main(String[] args) {
        new Server_question_one();
    }

    public Server_question_one() {
        // Place text area on the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);

        setTitle("Server");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); // It is necessary to show the frame here!

        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);
            jta.append("Server started at " + new Date() + '\n');

            // Listen for a connection request
            Socket socket = serverSocket.accept();

            // Create data input and output streams
            DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

            while (true) {
                // Receive radius from the client
                //double radius = inputFromClient.readDouble();
                double person_weight = inputFromClient.readDouble();
                double person_height = inputFromClient.readDouble();

                // Compute BMI
                double bmi = person_weight / (person_height * person_height);

                // Send BMI back to the client
                outputToClient.writeDouble(bmi);

                jta.append("person wieght received from client: " + person_weight + '\n');
                jta.append("person wieght received from client: " + person_height + '\n');
                jta.append("Body Max Index found: " + bmi + '\n');
            }
        } catch (IOException ex) {
            jta.append("Error: " + ex.getMessage() + '\n');
        }
    }
}


   
