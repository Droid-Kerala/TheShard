package com.droidkerala.theshard.presentation.ui.home

import androidx.lifecycle.*
import com.droidkerala.theshard.data.MovieResponse
import com.droidkerala.theshard.domain.MovieRepository
import com.droidkerala.theshard.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val liveDataMovies: LiveData<Resource<MovieResponse>>
        get() = _liveDataMovies
    private val _liveDataMovies = MutableLiveData<Resource<MovieResponse>>()

    fun getMovies(apiKey: String, page: Int) =
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _liveDataMovies.postValue(Resource.loading(data = null))
                try {
                    _liveDataMovies.postValue(
                        Resource.success(
                            data = movieRepository.getMovies(
                                apiKey,
                                page
                            )
                        )
                    )
                } catch (exception: Exception) {
                    _liveDataMovies.postValue(
                        Resource.error(
                            data = null,
                            message = exception.message ?: "Error Occurred!"
                        )
                    )
                }
            }
        }
}