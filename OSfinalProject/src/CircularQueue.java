import java.util.Arrays;

public class CircularQueue
{
    private final int[] queue;
    int index=0;
    int Size=0;
    public CircularQueue(int size)
    {
        this.queue=new int[size];
        this.index=0;
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
        this.Size++;
        if(this.index == this.getQueue().length)
        {
            this.index=0;
            this.Size--;
        }
        return this.replaceElement(number,this.index++);
    }
    public boolean contains(int number)
    {
        for (int item : this.getQueue())
        {
            if(number == item)
                return true;
        }
        return false;
    }
    public int get(int number)
    {
        return this.queue[number];
    }
    public String toString()
    {
        return Arrays.toString(this.queue);
    }
}
