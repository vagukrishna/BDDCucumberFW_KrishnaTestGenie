package OOPS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SampleTest {


    public static void main(String args[]) {

        ChildTest ct = new ChildTest();
        ArrayList<String> list = new ArrayList<String>();
        list.add("abc");
        list.add("xyz");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("sA", "Sa");
        map.put("sa", "Sa");

        for (Map.Entry<String, String> entry : map.entrySet()) {

            System.out.println(entry.getValue());

        }

//        PrimeNumOrNot(6);
//        displayPrimeNums(20);
//        displayFibonacci(7);
//        reverseNum(782);
        reverseString("probook");
        IsArmStrongNum(456);
    }

    public static void PrimeNumOrNot(int n) {

        int counter = 0;

        for (int i = 1; i <= n & n >= 2; i++) {
            if (n % i == 0) {
                counter = counter + 1;
            }
        }
        if (counter == 2) {
            System.out.println(n + " is prime num");
        } else
            System.out.println(n + " is not prime num");
    }

    public static void displayPrimeNums(int n) {
        String primenumbers = "";

        for (int j = 2; j <= n; j++) {
            int counter = 0;
            for (int i = 1; i <= j; i++) {
                if (j % i == 0) {
                    counter = counter + 1;
                }
            }
            if (counter == 2) {
                primenumbers = primenumbers + j + " ";


            }

        }
        System.out.println(primenumbers);

    }

    public static void displayFibonacci(int x)
    {
        int m=0,n=1,num=0;

        for(int i=0;i<x;i++) {
            num = m + n;
            n = m;
            m = num;

            System.out.print(num+" ");



        }


        }

      public static void reverseNum(int num)
      {

          int temp=0,rev=0;
          while(num>0) {
              temp = num % 10;
              rev = temp + rev * 10;
              num = num / 10;
          }
          System.out.println(rev);


      }

    public static void reverseString(String S)
    {
        String str="";

        for(int i=S.length()-1;i>=0;i--)
        {

            str=str+ S.charAt(i);

        }
        System.out.println(str);



    }

    public static void IsArmStrongNum(int num)
    {
        int rem=0,temp=0,n=num;

        while(num>0)
        {

            rem=num%10;
            temp=temp+(rem*rem*rem);
            num=num/10;

        }

        if(n==temp)
            System.out.println(n+" is Armstrong num");
        else
            System.out.println(n+" is not a Armstrong num");



    }



    }



