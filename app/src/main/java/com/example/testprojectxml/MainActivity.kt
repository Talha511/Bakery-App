package com.example.testprojectxml

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val ll = findViewById<Button>(R.id.LL)
        val rl = findViewById<Button>(R.id.RL)
        val cl = findViewById<Button>(R.id.CL)
        val hs = findViewById<Button>(R.id.HS)
        val pd = findViewById<Button>(R.id.PD)
        val cd = findViewById<Button>(R.id.CD)


        ll.setOnClickListener {
            val i= Intent(this@MainActivity, LinearLayoutActivity::class.java)
            startActivity(i)
        }

        rl.setOnClickListener {
            val i= Intent(this@MainActivity, RelativeLayoutActivity::class.java)
            startActivity(i)
        }

        cl.setOnClickListener {
            val i= Intent(this@MainActivity, ConstraintLayoutActivity::class.java)
            startActivity(i)
        }
        hs.setOnClickListener {
            val i= Intent(this@MainActivity, HomescreenActivity::class.java)
            startActivity(i)
        }
        pd.setOnClickListener {
            val i= Intent(this@MainActivity, ProductdescriptionActivity::class.java)
            startActivity(i)
        }

        cd.setOnClickListener {
            val i= Intent(this@MainActivity, BakeryActivity::class.java)
            startActivity(i)
        }
    }
}