package com.example.flixster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val movies: List<Movies>) : RecyclerView.Adapter<RecyclerViewAdapter.FlixsterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlixsterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie, parent, false)
        return FlixsterViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlixsterViewHolder, position: Int) {
        val movie = movies[position]
        val posterPathBaseUrl = "https://image.tmdb.org/t/p/w500"
        holder.mItem = movie
        holder.mMovieTitle.text = movie.title
        holder.mMovieOverview.text = movie.overview
        holder.mMovieReleaseDate.text = "Release Date: " + movie.releaseDate
        com.bumptech.glide.Glide.with(holder.mView)
            .load(posterPathBaseUrl+movie.posterPath)
            .placeholder(R.drawable.placeholder_image)
            .centerInside()
            .into(holder.mMoviePoster)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class FlixsterViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var mItem: Movies? = null
        val mMovieTitle: TextView = mView.findViewById<View>(R.id.titleTextView) as TextView
        val mMovieOverview: TextView = mView.findViewById<View>(R.id.overviewTextView) as TextView
        val mMovieReleaseDate: TextView = mView.findViewById<View>(R.id.releaseDateTextView) as TextView
        val mMoviePoster: ImageView = mView.findViewById<View>(R.id.posterImageView) as ImageView
    }
}