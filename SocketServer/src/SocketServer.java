import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SocketServer {

    public static ArrayList studentList = new ArrayList();

    public static void main(String args[]) {
        studentList.add(new Student("17020001","Do Thi Hong Ngat", "K62-CA-CLC1", "0123456787","dthn@gmail.com","address test"));
        studentList.add(new Student("17020002","Hoang Son Tung", "K62-CA-CLC1", "0123456788","hst@gmail.com","address test"));
        studentList.add(new Student("17020003","Le Cao Tung Lam", "K62-CA-CLC1", "0123456789","lctl@gmail.com","address test"));

        ServerSocket listener = null;
        Socket socketOfServer = null;

        try {
            listener = new ServerSocket(8081);
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }

        try {
            socketOfServer = listener.accept();
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
            BufferedWriter outputStream = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));

            while (true) {
                String clientResponse = inputStream.readLine();
                if (clientResponse.equals("EXIT")) {
                    outputStream.write("EXIT SUCCESSFULLY");
                    outputStream.newLine();
                    outputStream.flush();
                    break;
                }
                else {
                    String mssv = clientResponse;
                    String serverResponse;
                    int index = studentList.indexOf(new Student(mssv));
                    if (index!=-1) {
                        Student student = (Student) studentList.get(index);
                        serverResponse = student.toString();

                    }
                    else {
                        serverResponse = "This student doesn't exist!!!";
                    }
                    outputStream.write(">> " + serverResponse);
                    outputStream.newLine();
                    outputStream.flush();

                }
            }

        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        System.out.println("Sever stopped!");
    }
}