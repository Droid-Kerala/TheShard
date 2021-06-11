package com.droidkerala.theshard.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.droidkerala.theshard.data.Movie
import com.droidkerala.theshard.databinding.PopularMovieItemBinding


//Recyclerview adapter for showing list of popular movies
class PopularMoviesAdapter(private val listener: OnPopularMovieListener?) :

    RecyclerView.Adapter<PopularMoviesAdapter.PopularMovieViewHolder>() {

    private var movies: List<Movie> = arrayListOf()

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: PopularMovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, listener)
    }

    //To set data to adapter
    fun setData(listItems: List<Movie>) {
        if (!listItems.isNullOrEmpty()) {
            this.movies = listItems
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        return PopularMovieViewHolder(PopularMovieItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    class PopularMovieViewHolder(private val binding: PopularMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        //this method handles all data mapping and event listeneres.
        fun bind(
            movie: Movie?,
            listener: OnPopularMovieListener?
        ) {
            movie?.let {
                binding.movie = movie
                binding.executePendingBindings()
                //Click listener for movie icon.
                binding.imageview.setOnClickListener {
                    listener?.onPopularMovieSelected(movie)
                }

            }
        }
    }


    interface OnPopularMovieListener {
        fun onPopularMovieSelected(movie: Movie)
    }
}