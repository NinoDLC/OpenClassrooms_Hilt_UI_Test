package fr.delcey.hiltuitest.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SavingsRepository {

    private final MutableLiveData<Integer> savingsMutableLiveData = new MutableLiveData<>(3);

    @Inject
    public SavingsRepository() {
    }

    /**
     * @return a LiveData containing the Integer 3. I'm not good at saving.
     */
    public LiveData<Integer> getSavingsLiveData() {
        return savingsMutableLiveData;
    }

    public void updateSavings(int savings) {
        savingsMutableLiveData.setValue(savings);
    }
}
