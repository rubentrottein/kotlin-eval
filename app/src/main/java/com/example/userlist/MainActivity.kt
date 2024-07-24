package com.example.userlist

import android.os.Bundle
import android.widget.Button

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

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

        // Initialiser RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UserAdapter(currentUserList)


        val button : FloatingActionButton = findViewById(R.id.floatingActionButton)
        button.setOnClickListener {
            addUser()
        }

    }

    private val currentUserList= mutableListOf(
        User(0, "Jeremy","Bismark","01987654321","jeremy.bismark@kotlinuserlist.com"),
        User(1, "Daisy","Ultiel","0111223344","daisy.ultiel@kotlinuserlist.com"),
        User(2, "Zeinab","Ashrak","01987654321","zeinab.ashrak@kotlinuserlist.com")
    )

    private fun addUser(){
        var user : User = User(3, "Mounir","Geraud","01987654321","mounir.geraud@kotlinuserlist.com")
        currentUserList.add(user)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UserAdapter(currentUserList)
    }

}