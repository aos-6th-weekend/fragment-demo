package com.example.rathana.fragmentdemo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.rathana.fragmentdemo.R;
import com.example.rathana.fragmentdemo.model.Contact;

import org.w3c.dom.Text;

public class SearchFragment extends Fragment {

    Contact contact;
    TextView textView;

    static SearchFragment searchFragment;
    public  static  SearchFragment newInstance(){
        if(searchFragment==null)
            searchFragment=new SearchFragment();
        return searchFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_search,
                container,false);

        //create view object
        textView=view.findViewById(R.id.textView);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //bind data
        textView.setText(contact==null? "": contact.toString());

    }

    public void setContact(Contact contact) {
        this.contact=contact;
    }
}
