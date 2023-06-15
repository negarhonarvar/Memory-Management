import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadLocalRandom;

public class Server {
    static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket socket = serverSocket.accept();

        DataOutputStream socketOut = null;
        try {
            socketOut = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Client connected");

        try {
            int memorySize = 4;
            socketOut.writeInt(memorySize);

            int memoryAccessCount = 20;
            int[] references = {1,2,3,4,2,1,5,6,2,1,2,3,7,6,3,2,1,2,3,6};
            for (int i = 0; i < memoryAccessCount; i++) {
                int memoryAddress = references[i];
                socketOut.writeInt(memoryAddress);
                System.out.println(memoryAddress);

                int delay = ThreadLocalRandom.current().nextInt(1, 2000 + 1);
                Thread.sleep(delay);
            }

            socketOut.writeInt(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}