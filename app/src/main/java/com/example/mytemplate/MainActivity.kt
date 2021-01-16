package com.example.mytemplate

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.mytemplate.databinding.ActivityMainBinding
import java.util.RandomAccess
import kotlin.random.Random

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    fun buClick(view: View) {
        val seletedBtn = view as Button;
        var cellId = 0;
        // binding.bt2.text = seletedBtn.id.toString()
        print("called " + seletedBtn.id)
        when (seletedBtn.id) {

            R.id.bt1 -> cellId = 1
            R.id.bt2 -> cellId = 2
            R.id.bt3 -> cellId = 3
            R.id.bt4 -> cellId = 4
            R.id.bt5 -> cellId = 5
            R.id.bt6 -> cellId = 6
            R.id.bt7 -> cellId = 7
            R.id.bt8 -> cellId = 8
            R.id.bt9 -> cellId = 9
        }
        //Toast.makeText(this, "ID: " + cellId, Toast.LENGTH_LONG).show()

        playGame(cellId, seletedBtn)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1;


    fun playGame(cellId: Int, btSelected: Button) {

        if (activePlayer == 1) {
            btSelected.text = "X"
            btSelected.setBackgroundResource(R.color.teal_200)
            player1.add(cellId)
            activePlayer = 2
            autoPlay()
        } else {
            btSelected.text = "0"
            btSelected.setBackgroundResource(R.color.purple_700)
            player1.add(cellId)
            activePlayer = 1

        }
        btSelected.isEnabled = false;
       checkWinner()
    }

    fun checkWinner() {
        var winner = -1

        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        //row 2
        if (player1.contains(3) && player1.contains(4) && player1.contains(5)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(4) && player2.contains(5)) {
            winner = 2
        }

        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        //col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        // col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        // col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        //diag
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }







        if(winner !== -1 ){
            if(winner ==1){
                Toast.makeText(this, "Player one wins!! ",  Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Player TWO wins!! ",  Toast.LENGTH_LONG).show()
            }
        }

    }
    fun autoPlay(){
       var emptyCell = ArrayList<Int>();

        for( cellId in 1..9){
            if(!player1.contains(cellId) || !player2.contains(cellId)){
                emptyCell.add(cellId)
            }
        }
        var r= java.util.Random()
        var randomIndex = r.nextInt(emptyCell.size-0)+0
        var cellId = emptyCell.get(randomIndex);
        var buSelected: Button?

        when(cellId){
            1-> buSelected= binding.bt1
            2-> buSelected=binding.bt2
            3-> buSelected=binding.bt3
            4-> buSelected=binding.bt4
            5-> buSelected=binding.bt5
            6-> buSelected=binding.bt6
            7-> buSelected=binding.bt7
            8-> buSelected=binding.bt8
            9-> buSelected=binding.bt9
            else->{
                buSelected = binding.bt1
            }

        }

        playGame(cellId, buSelected)

    }



}