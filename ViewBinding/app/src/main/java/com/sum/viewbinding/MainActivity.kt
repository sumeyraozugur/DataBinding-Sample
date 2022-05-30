package com.sum.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sum.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val izmir = City("İzmir",3000,"Boyoz")

        binding.textView.text = izmir.name
        binding.textView2.text =izmir.population.toString()
        binding.textView3.text = izmir.famousWith

        binding.btnClick.setOnClickListener {
            Toast.makeText(applicationContext, "Button Clicked", Toast.LENGTH_SHORT).show()
        }



    }

}