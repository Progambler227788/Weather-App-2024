package com.example.weatherapphere.adapter


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.weatherapphere.databinding.RvRecyclerviewBinding
import com.example.weatherapphere.models.Specs

class AdapterWeather(private var data : ArrayList<Specs>,private var context : Context) : RecyclerView.Adapter<AdapterWeather.MyViewHolder> () {
    inner class MyViewHolder(var binding : RvRecyclerviewBinding) : ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RvRecyclerviewBinding.inflate(LayoutInflater.from(context),parent,false)
        return  MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

       animateEntrance(holder.itemView,position)
       holder.binding.itemView.setBackgroundResource(data[position].back)

        Log.d("Inside, CDE", "In weather, Setting background resource: ${data[position].back}")

      holder.binding.apply {
          val currentPos = data[position]
          specImage.setImageResource(currentPos.imageResId)
          specValue.text = currentPos.value
          specDescription.text = currentPos.desc
      }
    }
    private fun animateEntrance(view: View, position: Int) {
        // Set the initial state of the view (completely transparent)
        view.alpha = 0f

        // Define the animation duration (you can adjust this value)
        val animationDuration = 500L

        // Calculate the delay for each item based on its position (makes the items stagger in)
        val delay = (position * 100).toLong()

        // Animate the view to its final state (fully visible) with a fade-in effect
        view.animate()
            .alpha(1f)
            .setDuration(animationDuration)
            .setStartDelay(delay)
            .start()
    }
}