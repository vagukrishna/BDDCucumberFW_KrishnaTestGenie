package Utilities;

import POJO.AddPlace;
import POJO.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuilderAPI {

    public AddPlace addPlacePayLoad()
    {
    //added comments
        AddPlace ap=new AddPlace();
        ap.setAccuracy(60);
        ap.setAddress("7335 murgan ct");
        ap.setLanguage("English");
        ap.setName("House");
        ap.setWebsite("https://rahulshettyacademy.com");
        ap.setPhone_number("378490338");
        List<String> list=new ArrayList<String>();
        list.add("showpark");
        list.add("shop");
        ap.setTypes(list);
        Location lc=new Location();
        lc.setLat(-38.7282);
        lc.setLng(62.2729);
        ap.setLocation(lc);

        return ap;
    }

    public String deletePlacePayload()
    {
        return null;

    }
}
