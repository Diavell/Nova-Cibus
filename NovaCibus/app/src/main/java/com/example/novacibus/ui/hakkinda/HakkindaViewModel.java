package com.example.novacibus.ui.hakkinda;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HakkindaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HakkindaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}