package fr.delcey.hiltuitest.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import fr.delcey.hiltuitest.data.SavingsRepository;

@HiltViewModel
public class MainViewModel extends ViewModel {

    private final LiveData<String> savingsSentenceLiveData;

    @Inject
    public MainViewModel(SavingsRepository savingsRepository) {
        savingsSentenceLiveData = Transformations.map(
            savingsRepository.getSavingsLiveData(),
            input -> "Your savings so far are : " + input
        );
    }

    public LiveData<String> getSavingsSentenceLiveData() {
        return savingsSentenceLiveData;
    }
}