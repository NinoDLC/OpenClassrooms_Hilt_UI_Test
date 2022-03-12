package fr.delcey.hiltuitest.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import fr.delcey.hiltuitest.R;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainFragment extends Fragment {

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    public MainFragment() {
        super(R.layout.main_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        TextView messageTextView = view.findViewById(R.id.main_tv_message);

        viewModel.getSavingsSentenceLiveData().observe(getViewLifecycleOwner(), savingsSentence -> {
            //noinspection Convert2MethodRef
            messageTextView.setText(savingsSentence);
        });
    }
}