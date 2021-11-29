package com.Dose4U;

public class LinkedList {
    node head=null;
    void insert(String time,String med)
    {
        node new1=new node();
        /*
        new1.hour=hr;
        new1.minute=min;
        new1.second=sec;
         */
        new1.time=time;
        new1.medicine=med;
        new1.next=null;
        if(head==null)
        {
            head=new1;
        }
        else {
            node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new1;
        }
    }
    void show()
    {
        node temp=head;
        while (temp.next!=null){
            //System.out.println(temp.hour+":"+ temp.minute+":"+ temp.second);
            System.out.println(temp.time);
            temp=temp.next;
        }
        //System.out.println(temp.hour+":"+ temp.minute+":"+ temp.second);
        System.out.println(temp.time);
    }
}
