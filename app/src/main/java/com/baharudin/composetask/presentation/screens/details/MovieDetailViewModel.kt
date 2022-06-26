package com.baharudin.composetask.presentation.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baharudin.domain.model.Movie
import com.baharudin.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase
) : ViewModel() {
    private val _selectMovie : MutableStateFlow<Movie?> = MutableStateFlow(null)
    val selectMovie : StateFlow<Movie?> = _selectMovie

    fun getDetailMovie(movieId : Int) {
        viewModelScope.launch {
            movieUseCase.getMovieFromLocalUseCase.invoke(movieId = movieId).collect {
                _selectMovie.value = it
            }
        }
    }
}