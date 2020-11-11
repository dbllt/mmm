package mmm.mmm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedInfoVM extends ViewModel {
    private final MutableLiveData<User> data = new MutableLiveData<User>();

    public void setdata(User newdata) {
        data.setValue(newdata);
    }

    public LiveData<User> getData() {
        return data;
    }
}