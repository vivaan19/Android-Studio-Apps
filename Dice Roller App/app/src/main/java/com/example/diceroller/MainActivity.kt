package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // this saves the reference of button to rollButton variable
        val rollButton: Button = findViewById(R.id.button)

        /**
         * when we click our button this is the code where it  does some activity
         */
        rollButton.setOnClickListener {
            rollDice()
            rollDice2()
        }
    }

    private fun rollDice2() {
        val dice2 = Dice(6)  // Defining the dice object
        val diceRoll2 = dice2.roll() // calling the roll() method from Dice class.
        val diceImage2:ImageView=findViewById(R.id.imageView3) // stores the reference of imageView id to diceImage variable
        val drawableImage= when(diceRoll2)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage2.setImageResource(drawableImage)
        diceImage2.contentDescription = diceRoll2.toString() // this sets the content descp.

    }

    /**
     * rollDice() function to roll a dice of numSides=6
     */
    private fun rollDice() {
        val dice = Dice(6)  // Defining the dice object
        val diceRoll = dice.roll() // calling the roll() method from Dice class.
        val diceImage:ImageView=findViewById(R.id.imageView) // stores the reference of imageView id to diceImage variable
        val drawableImage= when(diceRoll)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableImage)
        diceImage.contentDescription = diceRoll.toString() // this sets the content descp.

    }
}

/**
 * This is the dice class which is the main logic of the code.
 */
class Dice(private val numSides: Int) {

    // This is the roll function which creates a ramdom number between 1 and the numSides.
    fun roll(): Int {
        return (1..numSides).random()
    }
}