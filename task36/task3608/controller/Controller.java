package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.UsersView;

/**
 * Created by nik on 31.03.2017.
 */
public class Controller {
   private Model model;
    private UsersView usersView;
    public void setModel(Model model) {
        this.model = model;
    }


   public void onShowAllUsers(){

       model.loadUsers();
       usersView.refresh(model.getModelData());
   }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }
}
