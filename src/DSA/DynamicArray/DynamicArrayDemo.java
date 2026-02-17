package DSA.DynamicArray;
/* List Implementation using Array */

import java.util.*;
class DynamicArray<T> implements Iterable<T>{ // Variables -> Methods
    static final int initialCapacity=16;
    private T[] arr;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    DynamicArray(){
        size=0;
        arr = (T[]) new Object[initialCapacity];
        capacity=initialCapacity;
    }

    private void checkInsertPosition(int pos){
        if(pos < 0 || pos > size)
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
    }
    private void checkDeletePosition(int pos){
        if(pos < 0 || pos >= size)
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
    }

    // Inserting element at the end (Module 1)
    public void add(T val){
        if(size==capacity){
            expandArray();
        }
        arr[size++]=val;
    }

    // Increasing the size of the array
    private void expandArray(){
        capacity*=2; // double the size of the array
        arr=java.util.Arrays.copyOf(arr,capacity);
    }

    // Display the elements (Module 2)
    public void display(){
        System.out.println("Elements in the list: ");
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
    }

    // Inserting the element at the position (Module 3)
    public void insertAtPosition(int pos,T val){
        checkInsertPosition(pos);
        if(size==capacity){
            expandArray();
        }
        for(int i=size-1;i>=pos;i--){
            arr[i+1]=arr[i];
        }
        arr[pos]=val;
        size++;
    }
    // Deleting the element at the position (Module 4)
    public void deleteAtPosition(int pos){
        checkDeletePosition(pos);
        for(int i=pos+1;i<size;i++){
            arr[i-1]=arr[i];
        }
        arr[size-1] = null;
        size--;
        if(capacity>initialCapacity && size<=capacity/4){
            shrinkArray();
        }
    }

    // Decreasing the size of the array
    private void shrinkArray(){
        capacity/=2; // double the size of the array
        arr=java.util.Arrays.copyOf(arr,capacity);
    }

    // Implementing the iterator
    @Override
    public Iterator<T> iterator(){
        return new Iterator<T>(){
            int index=0;
            public boolean hasNext() {
                return index<size;
            }
            public T next() {
                if(!hasNext())
                    throw new NoSuchElementException();
                return arr[index++];
            }
        };
    }
}
public class DynamicArrayDemo {
    public static void main(String[] args) {
        int pos;String val;
        DynamicArray<String> list = new DynamicArray<>();
        Scanner sc = new Scanner(System.in);
        // Menu to display
        while(true){
            System.out.println("\n------- List Menu --------");
            System.out.println("\n 1. Insert at End");
            System.out.println("\n 2. Display the List");
            System.out.println("\n 3. Insert at specified position");
            System.out.println("\n 4. Delete at specified position");
            System.out.println("\n 5. Exit");
            System.out.println("\n-------------------------");
            System.out.println("Enter your choice:\t");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter the data : ");
                    val= sc.next();
                    list.add(val);
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    System.out.print("Enter the position (starts at 0) : ");
                    pos=sc.nextInt();
                    if(pos<0){
                        System.out.println("Invalid position");
                        break;
                    }
                    System.out.print("Enter the data : ");
                    val= sc.next();
                    list.insertAtPosition(pos,val);
                    break;
                case 4:
                    System.out.print("Enter the position (starts at 0) : ");
                    pos=sc.nextInt();
                    if(pos<0){
                        System.out.println("Invalid position");
                        break;
                    }
                    list.deleteAtPosition(pos);
                    break;
                case 5: System.exit(0);
                default:
                    System.out.println("Invalid Choice");
            }
        }

    }
}
