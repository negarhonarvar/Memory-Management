import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class LRU
{
    Stack<Integer> recentlyUsed = new Stack<>();
    int pageFaults=0;
    myQueue queue ;
    int currentSize=0;
    public LRU(int frameSize)
    {
        queue=new myQueue(frameSize);
    }
    public void LRU(int number,int frameSize)
    {

        if(queue.contains(number))
        {
            int tindex=recentlyUsed.search(number);
            recentlyUsed.pop();
            recentlyUsed.push(number);
            // adds the recently used integer to the head of dequeue
            return;
        }
        else
        {
            pageFaults++;
            if(this.queue.getQueue().length > frameSize  && frameSize != 0)
            {
                int temp=recentlyUsed.remove(frameSize-1);
                System.out.println(temp);
                int tempindex = queue.getIndex(temp);
                System.out.println(tempindex);
                queue.replaceElement(number,tempindex);
            }
            else
            {
                queue.add(number);
                recentlyUsed.push(number);
                currentSize++;
            }
        }
    }
    public void printList()
    {
        for (int i = 0; i < this.queue.getQueue().length; i++)
        {
            System.out.println("in LRU, guest number:"+this.queue.get(i)+"seats at table:"+i);
        }
    }

}
