package com.example.rathana.fragmentdemo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rathana.fragmentdemo.adaper.ContactAdapter;
import com.example.rathana.fragmentdemo.HomeActivity;
import com.example.rathana.fragmentdemo.R;
import com.example.rathana.fragmentdemo.callback.AdapterCallback;
import com.example.rathana.fragmentdemo.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements AdapterCallback<Contact> {



    RecyclerView rvContact;
    List<Contact> contacts=new ArrayList<>();
    ContactAdapter adapter;
    
    static HomeFragment homeFragment;
    public static HomeFragment newInstance(){
        if(homeFragment==null)
            homeFragment=new HomeFragment();
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home,
                container,false);

        setupUI(view);

        return view;
    }

    private void setupUI(View view) {
        rvContact=view.findViewById(R.id.rvContact);
        adapter=new ContactAdapter(contacts,getActivity(),this);
        rvContact.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvContact.setAdapter(adapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //bind data
        //getContacts();
        adapter.setContacts(contacts);
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts.addAll(contacts);
    }

    /*private void getContacts() {
        for(int i=0;i<100;i++){
            this.contacts.add(new Contact(
                    "099 56 56 66",
                    "admin",
                    "08:30 AM",
                    R.mipmap.ic_launcher
            ));
        }
        adapter.setContacts(this.contacts);
    }*/

    @Override
    public void onSendData(Contact contact) {
        ((HomeActivity) getActivity()).onItemClicked(contact);
    }
}
