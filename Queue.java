package queue;
import java.util.Scanner;

class Queue {
    private int [] storage;     //stirage for queue
    private int size;           //max size of the queue
    private int front;          //front index
    private int end;            //end index

    //create storage array and intialize fron and end indexes
    public Queue(int size) {
        this.size = size;
        storage = new int[size];
        front = -1;
        end = -1;
    }

    //check if queue is full
    public boolean isFull(){
        //if front is 0 and ens is the last index or end is right before front
        if (front == 0 && end == size - 1 || front == end + 1){
            return true;
        }

        return false;
    }

    //check if queue is empty
    public boolean isEmpty(){
        if (front == -1 && end == -1){
            return true;
        }

        return false;
    }

    //enque an item
    public boolean enq(int item){
        //if que is full return false
        if(isFull()) return false;
        //if queue is empty then add item as the first element of the array
        if (isEmpty()){
            storage[0] = item;
            front = 0;
            end = 0;
            return true;
        }

        //advance end index and add the item to the next position;
        //if needed wrap around the array
        end = (end+1) % size;
        storage[end] = item;

        return true;

    }

    //return the fron item
    public int front(){
        return storage[front];
    }

    //remove an item from the end of the queue
    public boolean deq() {
        //if queue is empty the just return false
        if (isEmpty()) return false;
        //if this is the last item that we are removing
        //set front and end to -1 to indicate that queue is empty.
        if (front == end){
            front = -1;
            end = -1;
            return true;
        }

        //advance front index to the next position;
        //if needed wrap around the array
        front = (front+1) % size;
        return true;
    }

    //purge the queue
    //set front and end to -1 to indicate that queue is empty.
    public void purge(){
        front = -1;
        end  = -1;
    }

    //display content of the queue
    public void display(){
        if (isEmpty()) {
            System.out.println("The Queue is empty");
            return;
        }

        int i = front;
        while (true){
            System.out.println(storage[i]);
            if (i == end) break;
            i = (i+1) %  size;
        }
    }

    public static void main(String[] args){
        Queue q = new Queue(5);
        Scanner scanAH = new Scanner(System.in);
        int value=0;
        while(true){
            System.out.println("Please choose from the following options");
            System.out.println("Press 1 to Enqueue");
            System.out.println("Press 2 to Dequeue");
            System.out.println("Press 3 to return the front element");
            System.out.println("Press 4 to see if the Queue is empty");
            System.out.println("Press 5 to see if the Queue is full");
            System.out.println("Press 6 to collapse the Queue");
            System.out.println("Press 7 to Quit");
            int menuchoice= scanAH.nextInt();    
            if(menuchoice==1){
            System.out.println("Enter your value now");
            value=scanAH.nextInt(); 
            q.enq(value); 
            System.out.println("Item entered into the queue");
            continue;
            } 
            else if(menuchoice==2){
                q.deq();
                System.out.println("Item removed");
                continue;
            }
            else if(menuchoice==3){
                System.out.println("At the front we have" + q.front());
                continue;
            }
            else if(menuchoice==4){
                System.out.println("It is" + q.isEmpty()+"that the queue is empty");
                continue;
            }
            else if(menuchoice==5){
                System.out.println("It is" + q.isFull()+"that the queue is full");
                continue;
            }
            else if(menuchoice==6){
                q.purge();
                System.out.println("The queue has been purged");
                continue;
            }
            else if(menuchoice==7){
                System.out.println("Exiting...");
                break;
            }
            else{
                System.out.println("Invalid choice, try again");
                continue;
            }
        }
    
    }
}
