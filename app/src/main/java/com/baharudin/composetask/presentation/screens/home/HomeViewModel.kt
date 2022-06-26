package com.baharudin.composetask.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.baharudin.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    movieUseCase: MovieUseCase
) : ViewModel() {
    val getMoviePopular = movieUseCase.getMoviePopularUseCase
}