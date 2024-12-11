import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Server_question_two extends JFrame {
    // Text area for displaying contents
    private JTextArea jta = new JTextArea();

    public static void main(String[] args) {
        new Server_question_two();
    }

    public Server_question_two() {
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
            //Socket socket = serverSocket.accept();

            // Create data input and output streams
            //DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
            //DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

            while (true) {
                Socket socket = serverSocket.accept();
                jta.append("Client connected at " + new Date() + '\n');
                Thread thread = new ThreadClass(socket);
                thread.start();

            }
        } catch (IOException ex) {
            jta.append("Error: " + ex.getMessage() + '\n');
        }
    }

    class ThreadClass extends Thread {
        private Socket socket;

        public ThreadClass(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Create data input and output streams
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                while (true) {
                    // Receive weight and height from the client
                    double personWeight = inputFromClient.readDouble();
                    double personHeight = inputFromClient.readDouble();

                    // Compute BMI
                    double bmi = personWeight / (personHeight * personHeight);

                    // Send BMI back to the client
                    outputToClient.writeDouble(bmi);

                    synchronized (jta) {
                        jta.append("Person weight received from client: " + personWeight + '\n');
                        jta.append("Person height received from client: " + personHeight + '\n');
                        jta.append("Body Mass Index calculated: " + bmi + '\n');
                    }
                }
            } catch (IOException ex) {
                synchronized (jta) {
                    jta.append("Client disconnected: " + ex.getMessage() + '\n');
                }
            }
        }
    }
}
