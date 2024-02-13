package OOPS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ParentTest {

    ParentTest()
    {
        System.out.println("Parent class constructor");
    }

    public void ParentMethod()
    {
        System.out.println("In Parent class method");
    }

    public void testdatasetup(){

        List<String> list=new ArrayList<>();
        list.add("cx");
        list.add("dd");

        List<String> list2=new ArrayList<>();
        list2.add("cx");
        list2.add("dd");


        //List<List<String>> ls= Arrays.asList(list,Arrays.asList("2cx","2dd"));
        HashMap<List<String>,List<String>> hashMap=new HashMap<>();
        hashMap.put(list,list2);
        






        }


    }



