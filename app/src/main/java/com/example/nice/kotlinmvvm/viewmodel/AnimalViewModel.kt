package com.example.nice.kotlinmvvm.viewmodel

import android.databinding.ObservableField
import com.example.nice.kotlinmvvm.model.Animal

class AnimalViewModel(val animal: Animal) {
    ////data/////
    val info = ObservableField<String>("${animal.name}叫了 ${animal.shoutCount}声....")


    /////binding////
    fun shout() {
        animal.shoutCount++
        info.set("${animal.name} 叫了 ${animal.shoutCount}声..")
    }
}