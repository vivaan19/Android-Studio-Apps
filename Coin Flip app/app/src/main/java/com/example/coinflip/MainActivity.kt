package com.example.coinflip

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flipButton: Button =findViewById(R.id.button)
        flipButton.setOnClickListener {
            coinFlip()
        }
    }

    private fun coinFlip() {
        val myCoin=Coin(2)
        val myFlip=myCoin.flip()
        val coinImage: ImageView = findViewById(R.id.imageView)
        val coinTextView: TextView = findViewById(R.id.textView)

        if(myFlip == 1) {
            coinImage.setImageResource(R.drawable.heads)
            coinTextView.text="You Flipped Heads !!"
        }
        else {
            coinImage.setImageResource(R.drawable.tails)
            coinTextView.text="You Flipped Tails !!!"
        }
        coinImage.contentDescription=myFlip.toString()
    }

}

class Coin(private val numSides:Int)
{
    fun flip():Int
    {
        return (1..numSides).random()
    }
}