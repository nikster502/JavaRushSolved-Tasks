package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * Created by nik on 30.11.2017.
 */
public class Controller {

    private static Model model = new Model();

    public List<String> onDataListShow() {
        return model.getStringDataList();
    }

}
