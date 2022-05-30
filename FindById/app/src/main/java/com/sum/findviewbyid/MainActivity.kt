package com.sum.findviewbyid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textName:TextView = findViewById(R.id.textView)
        val textPopulation:TextView = findViewById(R.id.textView2)
        val textFamous:TextView = findViewById(R.id.textView3)
        val buttonClick: Button = findViewById(R.id.btnClick)

        val izmir = City("İzmir",3000,"Boyoz")

        textName.text = izmir.name
        textPopulation.text = "Nüfusu: ${izmir.population}"
        textFamous.text =izmir.famousWith

        buttonClick.setOnClickListener {
            Toast.makeText(applicationContext,"Button Cliked",Toast.LENGTH_SHORT).show()
        }



    }
}