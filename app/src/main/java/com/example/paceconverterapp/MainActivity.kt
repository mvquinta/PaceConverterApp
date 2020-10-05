package com.example.paceconverterapp

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.paceconverterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

     private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.btnCalculatePace.setOnClickListener { (findPace()) }
        binding.btnCalculatePace.setOnClickListener {
            if (binding.editTxtDistance.text.toString().trim().isEmpty() || binding.editTxtDistance.text.toString().trim().isBlank()) {
                Toast.makeText(this, "Please insert distance", Toast.LENGTH_SHORT).show()
            } else if (binding.editTxtHours.text.toString().trim().isEmpty() || binding.editTxtHours.text.toString().trim().isBlank()) {
                Toast.makeText(this, "Please insert Hours", Toast.LENGTH_SHORT).show()
            } else if (binding.editTxtMinutes.text.toString().trim().isEmpty() || binding.editTxtMinutes.text.toString().trim().isBlank()) {
                Toast.makeText(this, "Please insert Minutes", Toast.LENGTH_SHORT).show()
            } else if (binding.editTxtSeconds.text.toString().trim().isEmpty() || binding.editTxtSeconds.text.toString().trim().isBlank()) {
                Toast.makeText(this, "Please insert Seconds", Toast.LENGTH_SHORT).show()
            } else {
                findPace()
            }
        }
    }

    //Function that calculates and finds pace
    fun findPace() {
        //get user input information into variables
        val fieldKmDist = binding.editTxtDistance.text.toString()
        val kmDist: Double = fieldKmDist.toDouble()
        val fieldTimeHr = binding.editTxtHours.text.toString()
        val timeHr: Double = fieldTimeHr.toDouble()
        val fieldTimeMin = binding.editTxtMinutes.text.toString()
        val timeMin: Double = fieldTimeMin.toDouble()
        val fieldTimeScnd = binding.editTxtSeconds.text.toString()
        val timeScnd: Double = fieldTimeScnd.toDouble()
        //Start to calculate Pace
        val totalTimeMin: Double = (timeHr * 60.0) + timeMin + (timeScnd/60.0)
        //calculates pace. But this result must be converted to time format, that's why it's a temp variable
        val tempPace: Double = totalTimeMin / kmDist
        //I find and separate the decimal part of my pace. I must convert the decimal part into seconds
        val restTempPace =  ((tempPace - (tempPace.toInt().toDouble())))
        //here I convert decimal part into seconds and than turn it into a String to be able to print it
        //I convert tempPace to int to "clean" my decimal part. I than convert it again to double to be able to add the restTempPace converted to seconds
        //finally I convert the result into string to final print
        val finalPace = (tempPace.toInt().toDouble() + (restTempPace*0.6)).toString()
        //since I was having difficulty in printing my result because decimals were being round up. I went for a string solution. Not so elegant....
        binding.txtPaceResult.text = ("Your Pace: ${finalPace[0]}${finalPace[1]}${finalPace[2]}${finalPace[3]} min/km")
        closeKeyBoard()
    }

    //Function to close keyboard once it's used. This function can be used in every other function just by declaring it
    private fun closeKeyBoard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

}