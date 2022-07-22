package com.sabdio.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.sabdio.mycontacts.databinding.ActivityViewContactsBinding
import com.squareup.picasso.Picasso

class ViewContactsActivity : AppCompatActivity() {
    lateinit var binding:ActivityViewContactsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtra()
    }
    fun getExtra(){
        var name  = intent.extras?.getString("NAME")
        var location  = intent.extras?.getString("LOCATION")
        var email  = intent.extras?.getString("EMAIL")
        var phoneNumber  = intent.extras?.getString("NUMBER")
//        binding.imgPerson
        Toast.makeText(this, name,Toast.LENGTH_SHORT).show()
        Toast.makeText(this, location,Toast.LENGTH_SHORT).show()
        Toast.makeText(this, email,Toast.LENGTH_SHORT).show()
        Toast.makeText(this, phoneNumber,Toast.LENGTH_SHORT).show()

        binding.tvPersonName.text = name
        binding.tvPersonNum.text = phoneNumber
        binding.tvMailAddress.text = email
        binding.tvMap.text = location
        Picasso.get().load(intent.getStringExtra("IMAGE"))
            .resize(200, 200)
            .centerCrop().into(binding.imgPerson)

    }
}