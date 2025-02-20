package com.example.examen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examen.data.Student


class GrupAdapter(private val mList: List<Student>) :
    RecyclerView.Adapter<GrupAdapter.ViewHolder>() {
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardiview_student, parent, false)


        return ViewHolder(view)
    }


    // binds the list items to a view
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val alumne = mList[position]

        holder.textViewNombre.text = alumne.name + "\t"
        holder.textViewGrup.text = alumne.group + "\t"
        holder.textViewNota.text = alumne.score.toString()

    }


    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }


    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textViewNombre: TextView = itemView.findViewById(R.id.textView)
        val textViewGrup: TextView = itemView.findViewById(R.id.textView2)
        val textViewNota: TextView = itemView.findViewById(R.id.textView3)
    }
}
