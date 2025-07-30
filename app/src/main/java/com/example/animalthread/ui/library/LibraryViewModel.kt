package com.example.animalthread.ui.library

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalthread.domain.AnimalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    private val repository: AnimalRepository
) : ViewModel() {

    private val _catImage = MutableStateFlow<String?>(null)
    val catImage: StateFlow<String?> = _catImage.asStateFlow()

    private val _breedName = MutableStateFlow<String?>(null)
    val breedName: StateFlow<String?> = _breedName.asStateFlow()

    private val _breedTemperament = MutableStateFlow<String?>(null)
    val breedTemperament: StateFlow<String?> = _breedTemperament.asStateFlow()

    private val _breedOrigin = MutableStateFlow<String?>(null)
    val breedOrigin: StateFlow<String?> = _breedOrigin.asStateFlow()

    fun getRandomImage() {
        viewModelScope.launch {
            _catImage.value = repository.getRandomAnimalUrl()
        }
    }
}