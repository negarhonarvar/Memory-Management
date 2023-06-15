import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SecondChance
{
    CircularQueue queue;
    int currentSize=0;
    int pageFault=0;
    int rsindex=0;
    Map<Integer,Boolean> recentlySeen = new HashMap<>();
    public SecondChance(int frameSize)
    {
        this.queue = new CircularQueue(frameSize);
    }
    public void SecondChance(int number,int frameSize)
    {

        if (queue.contains(number))
        {
            recentlySeen.remove(number);
            recentlySeen.put(number,true);
            return;
        }
         pageFault++;
            if (this.queue.getQueue().length <= frameSize)
            {
                queue.add(number);
                currentSize++;
                recentlySeen.put(number, false);
                return;
            }

        while (queue.getQueue().length!=0 && recentlySeen.get(queue.get(rsindex))) //we are visiting continues true dirty bits
            // and set them to false
        {
            recentlySeen.remove(queue.get(rsindex));
            recentlySeen.put(queue.get(rsindex),false);
            //queue.replaceElement(number,rsindex);
            rsindex=(rsindex+1)%frameSize;
        }
        // first false dirty bit:
        recentlySeen.remove(queue.get(rsindex));
        recentlySeen.put(number,false);
        queue.replaceElement(number,rsindex);
        rsindex=(rsindex+1)%frameSize;

    }
    public void printList()
    {
        for (int i = 0; i < this.queue.getQueue().length; i++)
        {
            System.out.println("in SecondChance, guest number:"+this.queue.get(i)+"seats at table:"+i);
        }
    }

}
