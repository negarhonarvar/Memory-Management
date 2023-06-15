public class FIFO
{
    int pageFault=0;
    myQueue queue;
    public FIFO(int frameSize)
    {
        queue=new myQueue(frameSize);
    }
    public void FIFO(int frameSize, int number)
    {

        if(!queue.contains(number))
        {
            pageFault++;
            if (this.queue.getQueue().length >frameSize && frameSize != 0)
            {
                queue.replaceElement(number,0);
            }
            else
            {
              queue.add(number);
            }
        }
        // if it's currently in the queue then no action is needed
    }
   public void printList()
   {
       for (int i = 0; i < this.queue.getQueue().length; i++)
       {
           System.out.println("in FIFO, guest number:"+this.queue.get(i)+"seats at table:"+i);
       }
   }
}
