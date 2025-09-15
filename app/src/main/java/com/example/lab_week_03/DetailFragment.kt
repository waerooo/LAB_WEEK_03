package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    // View references
    private val coffeeTitle: TextView?
        get() = view?.findViewById(R.id.coffee_title)
    private val coffeeDesc: TextView?
        get() = view?.findViewById(R.id.coffee_desc)

    // Argument key
    companion object {
        private const val COFFEE_ID = "COFFEE_ID"

        fun newInstance(coffeeId: Int) = DetailFragment().apply {
            arguments = Bundle().apply {
                putInt(COFFEE_ID, coffeeId)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    // Called after the fragment's view has been created
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve the coffee ID argument and update UI
        val coffeeId = arguments?.getInt(COFFEE_ID, 0) ?: 0
        setCoffeeData(coffeeId)
    }

    // Set the coffee title and description based on the selected ID
    private fun setCoffeeData(id: Int) {
        when (id) {
            R.id.affogato -> {
                coffeeTitle?.text = getString(R.string.affogato_title)
                coffeeDesc?.text = getString(R.string.affogato_desc)
            }
            R.id.americano -> {
                coffeeTitle?.text = getString(R.string.americano_title)
                coffeeDesc?.text = getString(R.string.americano_desc)
            }
            R.id.latte -> {
                coffeeTitle?.text = getString(R.string.latte_title)
                coffeeDesc?.text = getString(R.string.latte_desc)
            }
        }
    }
}