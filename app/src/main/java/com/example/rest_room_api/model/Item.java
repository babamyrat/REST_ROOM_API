package com.example.rest_room_api.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item {

    List<String> list = new ArrayList<>();

    public Item (int a, String ... list){
        this.list.addAll(Arrays.asList(list));
    }

}
