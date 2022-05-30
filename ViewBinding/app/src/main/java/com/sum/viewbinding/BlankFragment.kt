package com.sum.viewbinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.sum.viewbinding.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {
    private var _binding: FragmentBlankBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
        
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val city =City("İzmir",3000,"Boyoz")
        binding.textView.text = city.name
        binding.textView2.text = city.population.toString()
        binding.textView3.text = city.famousWith

        binding.btnClick.setOnClickListener {
            Toast.makeText(activity, "Button cliked", Toast.LENGTH_SHORT).show()
        }





    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}