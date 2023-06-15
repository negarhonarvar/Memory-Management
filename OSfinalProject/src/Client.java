import java.io.*;
import java.net.Socket;
import java.net.ConnectException;
import java.net.UnknownHostException;

public class Client
{
    static private Socket socket;
    static private DataInputStream dataInputStream;
    static private DataOutputStream dataOutputStream;
    static final int PORT = 8080;
    public static void Connection()
    {
       try
       {
           socket=new Socket("localhost", PORT);
           if (socket==null)
           {
               dataOutputStream=null;
               dataInputStream=null;
               System.out.println("Streams are Unavailable");
           }
           else
           {
               dataInputStream=new DataInputStream(socket.getInputStream());
               dataOutputStream=new DataOutputStream(socket.getOutputStream());
           }

       }catch (IOException e)
       {
           e.printStackTrace();
           System.out.println("Connection Refused");
           System.exit(-1);
       }
    }

    public static void main(String[] args) throws IOException {
        Connection();
        int frameSize=0;
        try
        {
            frameSize=dataInputStream.readInt();
            System.out.println(frameSize);
        }catch (IOException i)
        {
            i.printStackTrace();
            System.out.println("Invalid Input");
            System.exit(-1);
        }
        int number=dataInputStream.readInt();
        FIFO fifo=new FIFO(frameSize);
        fifo.FIFO(frameSize,number);
        LRU lru=new LRU(frameSize);
        lru.LRU(number,frameSize);
        SecondChance secondChance=new SecondChance(frameSize);
        secondChance.SecondChance(number,frameSize);
        while ((number=dataInputStream.readInt())!=0)
        {
            fifo.FIFO(frameSize,number);
            lru.LRU(number, frameSize);
            secondChance.SecondChance(number,frameSize);
        }
        System.out.println("LRU:<"+lru.pageFaults+">,FIFO:<"+fifo.pageFault+">,Second-chance:<"+secondChance.pageFault+">");
        fifo.printList();
        lru.printList();
        secondChance.printList();
    }
}
