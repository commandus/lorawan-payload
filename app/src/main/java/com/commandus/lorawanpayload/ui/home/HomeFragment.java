package com.commandus.lorawanpayload.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.commandus.lorawanpayload.PayloadAdapter;
import com.commandus.lorawanpayload.PayloadSelection;
import com.commandus.lorawanpayload.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView recyclerViewPayload;
    private PayloadSelection payloadSelection;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerViewPayload = binding.recyclerViewPayload;
        payloadSelection = new PayloadSelection() {
            @Override
            public void onSelect(long id) {
                //
            }
        };
        recyclerViewPayload.setAdapter(new PayloadAdapter(recyclerViewPayload, payloadSelection));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void pushMessage(String msg) {
        // recyclerViewPayload.smoothScrollToPosition(Pay.logData.size() - 1);
    }

}