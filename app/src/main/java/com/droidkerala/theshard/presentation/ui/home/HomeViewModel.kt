package com.droidkerala.theshard.presentation.ui.home

import androidx.lifecycle.*
import com.droidkerala.theshard.data.Movie
import com.droidkerala.theshard.domain.MovieRepository
import com.droidkerala.theshard.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val movieRepository : MovieRepository, private val savedStateHandle: SavedStateHandle): ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text


    fun getMovies(apiKey : String, page: Int) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = movieRepository.getMovies(apiKey,page)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun getMovieListById(id : String) : Movie? {
        return  movieRepository.getMovieListById(id)
    }
}