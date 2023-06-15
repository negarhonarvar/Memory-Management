import java.util.Arrays;

public class myQueue
{
    int[] queue;
    int index;
    int size=0;//total size
    int currentsize=0;// current length

    public myQueue(int frameSize)
    {
        this.queue=new int[frameSize];
        this.index=0;
        this.size=frameSize;
    }
    public int[] getQueue() {
        return queue;
    }
    public boolean replaceElement(int number, int index)
    {
        if (index >= queue.length)
            return false;
        queue[index] = number;
        return true;
    }
    public boolean add(int number)
    {
        if(this.size==queue.length)
        {
            return false;
        }
        else
        {
            currentsize++;
            index++;
            this.queue[index]=number;
            return true;
        }
    }
    public int get(int number)
    {
        return this.queue[number];
    }
    public boolean contains(int number)
    {
        for (int item : this.getQueue())//iteration
        {
            if(number == item)
                return true;
        }
        return false;
    }
    public int getIndex(int number)
    {
        for (int i = 0; i < this.queue.length; i++)
        {
            if(this.queue[i]==number)
                return i;
        }
        return -1;
    }
    public String toString()
    {
        return Arrays.toString(this.queue);
    }
}
