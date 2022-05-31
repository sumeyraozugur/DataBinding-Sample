package com.sum.findviewbyid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class BlankFragment : Fragment() {
    private lateinit var  buton: Button
    private lateinit var  textName: TextView
    private lateinit var  textPopulation: TextView
    private lateinit var  textFamous: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val city = City("İzmir",3000,"Boyoz")
        buton = view.findViewById(R.id.btnClick)
        textName = view.findViewById(R.id.textView)
        textPopulation = view.findViewById(R.id.textView3)
        textFamous = view.findViewById(R.id.textView2)


        textName.text = city.name
        textPopulation.text=city.population.toString()
        textFamous.text= city.famousWith

        buton.setOnClickListener {
            Toast.makeText(activity,"Button Cliked",Toast.LENGTH_SHORT).show()

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()

    }






}