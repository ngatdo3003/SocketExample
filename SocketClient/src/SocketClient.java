import java.io.*;
import java.net.*;

public class SocketClient {

    public static void main(String[] args) {

        final String serverHost = "localhost";

        Socket socketOfClient = null;
        BufferedWriter outputStream = null;
        BufferedReader inputStream = null;

        try {
            socketOfClient = new Socket(serverHost, 8081);
            outputStream = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
            inputStream = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + serverHost);
            return;
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + serverHost);
            return;
        }

        try {
            outputStream.write("17020001");
            outputStream.newLine();
            outputStream.flush();
            outputStream.write("17020002");
            outputStream.newLine();
            outputStream.flush();
            outputStream.write("17020004");
            outputStream.newLine();
            outputStream.flush();
            outputStream.write("EXIT");
            outputStream.newLine();
            outputStream.flush();
            String serverResponse;
            while ((serverResponse = inputStream.readLine()) != null) {
                System.out.println("Server send: " + serverResponse);
                if (serverResponse.indexOf("EXIT SUCCESSFULLY") != -1) {
                    break;
                }
            }

            outputStream.close();
            inputStream.close();
            socketOfClient.close();
        } catch (UnknownHostException e) {
            System.err.println("Trying to connect to unknown host: " + e);
        } catch (IOException e) {
            System.err.println("IOException:  " + e);
        }
    }

}
