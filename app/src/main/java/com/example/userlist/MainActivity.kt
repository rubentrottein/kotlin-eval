package com.example.userlist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText

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

        fun recyclerViewUpdate(){
            val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = UserAdapter(currentUserList)
        }
        recyclerViewUpdate()

        val button : FloatingActionButton = findViewById(R.id.floatingActionButton)
        button.setOnClickListener {
            val editTextFirstName = findViewById<EditText>(R.id.editTextFirstName)
            val editTextLastName = findViewById<EditText>(R.id.editTextLastName)
            val editTextPhone = findViewById<EditText>(R.id.editTextPhone)
            val editTextEmail = findViewById<EditText>(R.id.editTextEmail)

            val firstName = editTextFirstName.text.toString().trim()
            val lastName = editTextLastName.text.toString().trim()
            val phone = editTextPhone.text.toString().trim()
            val email = editTextEmail.text.toString().trim()

            val user : User = User( currentUserList.size, firstName, lastName, phone, email)

            currentUserList.add(user)

            // Notifier l'adaptateur que la liste des données a changé
            recyclerViewUpdate()

            // Effacer le formulaire après ajout


            editTextFirstName.text.clear()
            editTextLastName.text.clear()
            editTextPhone.text.clear()
            editTextEmail.text.clear()

            recyclerViewUpdate()

        }

    }

    private val currentUserList= mutableListOf(
        User(0, "Jeremy","Bismark","01987654321","jeremy.bismark@kotlinuserlist.com"),
        User(1, "Daisy","Ultiel","0111223344","daisy.ultiel@kotlinuserlist.com"),
        User(2, "Zeinab","Ashrak","01987654321","zeinab.ashrak@kotlinuserlist.com")
    )

    private fun addUser(){
    }

}