package com.p1.gallery;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
public class PageViewModel extends ViewModel {
    private MutableLiveData<String> mTitle = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mTitle, new Function<String, String>() {
        @Override
        public String apply(String input) {
            return "Tab 2 \n\n\nRupesh Kumar\nReg. No.-11712081\n Roll No. 43\n Course CSE225\n\n\nSubmitted to : \nProf. Sawal Tandon\nLovely Professional University, Phagwara" ;
        }
    });

    public void setIndex(String index) {
        mTitle.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }
}
