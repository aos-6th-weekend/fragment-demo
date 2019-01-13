package com.example.rathana.fragmentdemo.adaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rathana.fragmentdemo.R;
import com.example.rathana.fragmentdemo.callback.AdapterCallback;
import com.example.rathana.fragmentdemo.model.Contact;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactAdapter  extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {


    AdapterCallback <Contact> callback;
    List<Contact> contacts;
    Context context;

    public ContactAdapter(List<Contact> contacts, Context context,AdapterCallback<Contact> callback) {
        this.contacts = contacts;
        this.context = context;
        this.callback=callback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(
                R.layout.contact_item_layout,viewGroup,false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Contact contact= contacts.get(i);

        viewHolder.name.setText(contact.getName());
        viewHolder.phone.setText(contact.getPhone());
        viewHolder.date.setText(contact.getDate());
        viewHolder.profile.setImageResource(contact.getProfile());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onSendData(contact);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.contacts.size();
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts.addAll(contacts);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView profile;
        TextView phone, name,  date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.profile);
            phone = itemView.findViewById(R.id.phone);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);


        }
    }

}
