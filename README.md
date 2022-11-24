![1](https://user-images.githubusercontent.com/103045206/203844301-0a36fbd4-490c-4048-abba-8c2b716ef0fd.PNG)


 ## Problem Statement :
Given an application and its implementation to demonstrate the implementation of data structures for handling the "Favorite" contact list in mobiles.

## Theory :
* In this problem statement we have to implement a code for writing and reading favourite contact's from contact list in mobiles.

* Data Structure used is Priority Queue In Java.

* Logic of this code is that it will put a given contact in favourite contact list if its number of call are greater than 5 else it will be a normal contact.

* Default Priority Queue in java uses Min Heap i.e Minimum Element will be at the top of the heap tree and lower will in its child nodes of tree. This way Priority queue has default Min Heap implementation.

* But in our problem statement we want to implement Max Heap so to do this we will implement Iterator which will sort in descending order and pass it to a Priority Queue as a priority setter. This will make our default Priority Queue from Min Heap To Max Heap. 

## Logic : 
* Step 1:
Create a class Contact which will have three attributes name , number and number of calls.Create another class which implements comparotor to convert min heap to max heap. 

* Step 2:
In main method make a priority queue which will take parameter as comparator class which we implement already.Write a method to print contacts which will iterate over queue and print all contacts.Again create a new method to print favourite contact which will print the favourite contact.Favourite contact will be those which have number of calls greater than 5.

* Step 3:
In main method use switch case which will make a input and output user friendly and it will have three option Add contact , Print all contacts , Print Favourite contacts.

## Source Code :
```
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

```

## Output :

This is to Add New Contact's

```
------------------------------------------------------------------
		CONTACT APPLICATION
------------------------------------------------------------------
_A_ : ADD CONTACT
_B_ : DISPLAY CONTACT LIST
_C_ : DISPLAY FAVOURITE CONTACT's
_D_ : DELETE CONTACT
ENTER YOUR CHOICE
1
Enter Name
Gunjan
Enter Number
9322053686

		CONTACT LIST UPDATED
------------------------------------------------------------------
Name			Number 			Number Of Calls
------------------------------------------------------------------
Gunjan			9322053686			15



------------------------------------------------------------------
		CONTACT APPLICATION
------------------------------------------------------------------
_A_ : ADD CONTACT
_B_ : DISPLAY CONTACT LIST
_C_ : DISPLAY FAVOURITE CONTACT's
_D_ : DELETE CONTACT
ENTER YOUR CHOICE
1
Enter Name
Yash
Enter Number
9420253010

		CONTACT LIST UPDATED
------------------------------------------------------------------
Name			Number 			Number Of Calls
------------------------------------------------------------------
Gunjan			9322053686			15
Yash			9420253010			9



------------------------------------------------------------------
		CONTACT APPLICATION
------------------------------------------------------------------
_A_ : ADD CONTACT
_B_ : DISPLAY CONTACT LIST
_C_ : DISPLAY FAVOURITE CONTACT's
_D_ : DELETE CONTACT
ENTER YOUR CHOICE
1
Enter Name
Viraj
Enter Number
9623756838

		CONTACT LIST UPDATED
------------------------------------------------------------------
Name			Number 			Number Of Calls
------------------------------------------------------------------
Gunjan			9322053686			15
Yash			9420253010			9
Viraj			9623756838			9
```

Like this i have inserted 20 more contacts, here is the output of Contact List and Favourite Contact List.

```
------------------------------------------------------------------
		CONTACT APPLICATION
------------------------------------------------------------------
_A_ : ADD CONTACT
_B_ : DISPLAY CONTACT LIST
_C_ : DISPLAY FAVOURITE CONTACT's
_D_ : DELETE CONTACT
ENTER YOUR CHOICE
2



		Contacts List
------------------------------------------------------------------
Name			Number 			Number Of Calls
------------------------------------------------------------------
Mihir			9123895978			20
Rohan			9823456789			15
Sahil			6754981234			19
Kunwar			9856657843			14
Mrunal			7659925478			7
Gunjan			9322053686			15
Gauri			7898598149			17
Yash			9420253010			9
Lakhe			5698678945			14
Manish			9978348971			5
Gaurav			9812345489			1
Divesh			8976569898			4
Mohan			6754987812			5
Viraj			9623756838			9
Piyush			7867983429			16
Ajjay			9356476754			1
Mrugal			8769125947			1
Dilip			7898567213			5
Tejas			7809345289			10
Kshama			9456239876			1






------------------------------------------------------------------
		CONTACT APPLICATION
------------------------------------------------------------------
_A_ : ADD CONTACT
_B_ : DISPLAY CONTACT LIST
_C_ : DISPLAY FAVOURITE CONTACT's
_D_ : DELETE CONTACT
ENTER YOUR CHOICE
3



		Favourite Contacts
------------------------------------------------------------------
Name			Number			Number Of Calls
------------------------------------------------------------------
Mihir			9123895978			20
Rohan			9823456789			15
Sahil			6754981234			19
Kunwar			9856657843			14
Mrunal			7659925478			7
Gunjan			9322053686			15
Gauri			7898598149			17
Yash			9420253010			9
Lakhe			5698678945			14
Viraj			9623756838			9
Piyush			7867983429			16
Tejas			7809345289			10
```


## 💼 Language Used
 
![](https://img.shields.io/badge/Code-Java-informational?style=flat&logo=react&color=61DAFB)

## 💼 IDE Used

![](https://img.shields.io/badge/IDE-Eclipse-informational?style=flat&logo=react&color=61DAFB)

![2](https://user-images.githubusercontent.com/103045206/203844905-dd5f78a8-fe90-4190-ad4c-408de715ea74.PNG)

