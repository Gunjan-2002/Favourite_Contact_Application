package Favourite_Contact;

import java.util.Comparator;
import java.util.*;
import java.lang.Math;

class Contact {

    String name;
    String number;
    Integer number_of_calls;

    public Contact(String name, String number, int number_of_calls) {
        if (name == null) {
            throw new IllegalArgumentException("Must provide valid name");
        }
        this.name = name;

        if (number == null || number.length() > 10 && number.length() < 10) {
            throw new IllegalArgumentException("Must provide valid number");
        }
        this.number = number;

        this.number_of_calls = number_of_calls;
    }

    @Override
    public String toString() 
    {
        return this.name + "\t\t\t" + this.number + "\t\t\t" + this.number_of_calls;
    }

}

class contactFavourite implements Comparator<Contact> {

    public int compare(Contact s1, Contact s2) {
        if (s1.number_of_calls > s2.number_of_calls)
            return -1;
        if (s1.number_of_calls < s2.number_of_calls)
            return 1;
        return 0;
    }
}

public class Favourite_Contact 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int min = 1;
        int max = 21;

     
        PriorityQueue<Contact> pq = new PriorityQueue<Contact>(new contactFavourite());

        do
        {
            System.out.println("\n\n");
            System.out.println("------------------------------------------------------------------");
            System.out.println("\t\tCONTACT APPLICATION");
            System.out.println("------------------------------------------------------------------");
            System.out.println("_A_ : ADD CONTACT");
            System.out.println("_B_ : DISPLAY CONTACT LIST");
            System.out.println("_C_ : DISPLAY FAVOURITE CONTACT's");
            System.out.println("_D_ : DELETE CONTACT");
            System.out.println("ENTER YOUR CHOICE");
            int ch = sc.nextInt();

            if(ch == 4)
            {
                System.out.println("\nCONTACT APPLICATION CLOSED");
                break;
            }

            switch(ch)
            {
                case 1 :
                {

                    int a = (int)(Math.random()*(max - min +1) + min);

                    System.out.println("Enter Name");
                    String name = sc.next();
                    System.out.println("Enter Number");
                    String number = sc.next();

                    Contact c = new Contact(name, number, a);

                    pq.add(c);

                    System.out.println("\n\t\tCONTACT LIST UPDATED");

                    printList(pq);

                    break;
                }

                case 2 :
                {
                    System.out.println("\n\n");
                    System.out.println("\t\tContacts List");
                    printList(pq);
                    System.out.println("\n\n");
                    break;
                }

                case 3 :
                {
                    System.out.println("\n\n");
                    printFav(pq);
                    System.out.println("\n\n");
                    break;
                }

            }
        }
        while(true);
        



    }

    public static void printList(PriorityQueue pq)
    {
        Iterator i = pq.iterator();

        System.out.println("------------------------------------------------------------------");
        System.out.println("Name\t\t\tNumber \t\t\tNumber Of Calls");
        System.out.println("------------------------------------------------------------------");
        while(i.hasNext())
        {
            System.out.println(i.next().toString() );
        }
    }

    public static void printFav(PriorityQueue pq)
    {
        System.out.println("\t\tFavourite Contacts");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Name\t\t\tNumber\t\t\tNumber Of Calls");
        System.out.println("------------------------------------------------------------------");
      
        ArrayList<Contact> ar = new ArrayList<Contact>(pq);

        for(Contact x : ar)
        {
            if(x.number_of_calls > 5)
            {
                System.out.println(x.toString() );
            }
        }
    }

}
