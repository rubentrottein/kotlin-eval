package com.example.userlist
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val userListToDisplay: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewEmail: TextView = itemView.findViewById(R.id.textViewEmail)
        val textViewPhone: TextView = itemView.findViewById(R.id.textViewPhone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_cards, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userListToDisplay[position]
        holder.textViewName.text = "${currentUser.firstName} ${currentUser.lastName}"
        holder.textViewEmail.text = currentUser.email
        holder.textViewPhone.text = currentUser.tel


        // Log pour debug
        Log.d("UserAdapter", "Binding user at position $position: $currentUser")
    }

    override fun getItemCount() = userListToDisplay.size
}