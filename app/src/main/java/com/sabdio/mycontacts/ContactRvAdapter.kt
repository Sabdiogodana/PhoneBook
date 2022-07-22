package com.sabdio.mycontacts

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.sabdio.mycontacts.databinding.ContactListNameBinding
import com.squareup.picasso.Picasso

class ContactRvAdapter(var contactsList: List<Contact>):
    RecyclerView.Adapter<contactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): contactViewHolder {
        var binding = ContactListNameBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return contactViewHolder(binding)
    }
    override fun onBindViewHolder(holder: contactViewHolder, position: Int) {
     var currentContact = contactsList.get(position)
        holder.binding.tvName.text = currentContact.name
        holder.binding.tvNumber.text = currentContact.phoneNumber
        holder.binding.tvEmail.text = currentContact.email
        holder.binding.tvLocation.text = currentContact.location
        Picasso.get()
            .load(currentContact.image)
            .resize(200,200)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_person_24)
            .into(holder.binding.ivContact)
        val context =holder.itemView.context
        holder.binding.ivContact.setOnClickListener {
         Toast.makeText(context,"You have clicked the image", Toast.LENGTH_SHORT).show()
        }
        holder.binding.cvContacts.setOnClickListener {
            val intent = Intent(context, ViewContactsActivity::class.java)
            intent.putExtra("NAME", currentContact.name)
            intent.putExtra("LOCATION", currentContact.location)
            intent.putExtra("EMAIL", currentContact.email)
            intent.putExtra("NUMBER", currentContact.phoneNumber)
            intent.putExtra("IMAGE",currentContact.image)

            context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return contactsList.size
    }
}

class contactViewHolder(val binding: ContactListNameBinding):
    RecyclerView.ViewHolder(binding.root)




//    var tvName = itemView.findViewById<TextView>(R.id.tvName)
//    var tvNumber = itemView.findViewById<TextView>(R.id.tvNumber)
//    var tvEmail = itemView.findViewById<TextView>(R.id.tvEmail)
//    var tvLocation = itemView.findViewById<TextView>(R.id.tvLocation)
//    var ivContact = itemView.findViewById<ImageView>(R.id.ivContact)