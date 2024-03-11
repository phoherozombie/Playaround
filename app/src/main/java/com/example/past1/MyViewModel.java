package com.example.past1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.net.Inet4Address;
import java.util.List;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> number;
    LiveData<Integer> getNumbers(){
        if(number==null){
            number=new MutableLiveData<Integer>();
            number.setValue(0);

        }
        return  number;
    }
    public void increaseNumber(){
        number.setValue(number.getValue()+1);
    }


}
