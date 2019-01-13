package com.example.rathana.fragmentdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.rathana.fragmentdemo.fragment.HomeFragment;
import com.example.rathana.fragmentdemo.fragment.SearchFragment;
import com.example.rathana.fragmentdemo.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction t = fragmentManager.beginTransaction();

        HomeFragment fragment= HomeFragment.newInstance();
        fragment.setContacts(getContacts());

        t.add(R.id.fragmentContainer,fragment);
        t.commit();

    }

    public void onButtonSearchClicked(){

        FragmentTransaction t= getSupportFragmentManager().beginTransaction();
        SearchFragment fragment = SearchFragment.newInstance();
        t.replace(R.id.fragmentContainer,fragment);
        t.addToBackStack(null);
        t.commit();

        Toast.makeText(this, "search clicked", Toast.LENGTH_SHORT).show();
    }

    private List<Contact> getContacts() {
        List<Contact> contacts=new ArrayList<>();
        for(int i=0;i<100;i++){
            contacts.add(new Contact(
                    "099 56 56 66",
                    "admin",
                    "08:30 AM",
                    R.mipmap.ic_launcher
            ));
        }
        return contacts;
    }

    public void onItemClicked(Contact contact){

        FragmentTransaction t= getSupportFragmentManager().beginTransaction();
        SearchFragment fragment =SearchFragment.newInstance();
        fragment.setContact(contact);
        t.replace(R.id.fragmentContainer,fragment);
        t.addToBackStack(null);
        t.commit();

        Toast.makeText(this, "contact item clicked", Toast.LENGTH_SHORT).show();
    }


}
