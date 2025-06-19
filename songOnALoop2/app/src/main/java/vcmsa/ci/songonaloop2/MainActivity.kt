package za.ac.iie.songonaloop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import vcmsa.ci.songonaloop2.R
import vcmsa.ci.songonaloop2.ViewDetails

class MainActivity : AppCompatActivity() {



    val songTitle = arrayOf("Ibhaynoi","Wish you were here","lomusa Ongaka","Somandla","Vuka")
    val artistName = arrayOf("Blaq Diamond","Black Coffe","Spirit Of Praise","Mandisi","Osar")
    val rating = intArrayOf(3,4,2,3,1)
    val comments = arrayOf("Pop","House","Gospel","Jazz","Amapiano")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Sending the array information to second screen
        val btnNextScreen = findViewById<Button>(R.id.btnNextScreen)

        btnNextScreen.setOnClickListener {
            val intent = Intent(this, ViewDetails::class.java)
            intent.putExtra("songTitle",songTitle)
            intent.putExtra("artistName",artistName)
            intent.putExtra("rating",rating)
            intent.putExtra("comments",comments)

            startActivity(intent)
            finish() }

        val btnAdd = findViewById<Button>(R.id.btnAddToPlayList)
        val btnExitApp = findViewById<Button>(R.id.btnExitApp)
        val txtEnterDetails = findViewById<TextView>(R.id.txtEnterDetails)

        fun enterDetails() {
            println("Enter Details of your playlist")
        }

        btnAdd.setOnClickListener {

            txtEnterDetails.text = enterDetails().toString()
        }

        btnExitApp.setOnClickListener {
            finishAffinity()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}