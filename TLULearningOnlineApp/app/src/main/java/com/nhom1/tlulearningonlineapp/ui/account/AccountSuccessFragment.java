package com.nhom1.tlulearningonlineapp.ui.account;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.nhom1.tlulearningonlineapp.R;
import com.nhom1.tlulearningonlineapp.adapter.AccountAdapter;
import com.nhom1.tlulearningonlineapp.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountSuccessFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Account> accountList;
    private AccountAdapter accountAdapter;

    public AccountSuccessFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_success, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewAccounts);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Tạo dữ liệu mẫu
        accountList = new ArrayList<>();
        accountList.add(new Account("001", "Nguyễn Văn A", "SV", "64CNTT.NB"));
        accountList.add(new Account("002", "Trần Thị B", "GV", "Khoa CNTT"));
        accountList.add(new Account("003", "Phạm Văn C", "Admin", "Phòng Đào tạo"));

        // Truyền đúng tham số
        accountAdapter = new AccountAdapter(accountList, new AccountAdapter.OnAccountClickListener() {
            @Override
            public void onChiTietClick(Account account) {
                // Ví dụ: Hiển thị Toast
                Toast.makeText(getContext(), "Chi tiết: " + account.getFullName(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(accountAdapter);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Thêm các xử lý khác nếu cần

        MaterialButton btnBack = view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_accountSuccessFragment_to_accountFragment);
            Log.d("MyDebug", "Button clicked");
        });
    }

}

