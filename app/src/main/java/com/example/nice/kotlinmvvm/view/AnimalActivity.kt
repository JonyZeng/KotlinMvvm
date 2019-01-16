package com.example.nice.kotlinmvvm.view

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.nice.kotlinmvvm.R
import com.example.nice.kotlinmvvm.databinding.ActivityAnimalBinding
import com.example.nice.kotlinmvvm.model.Animal
import com.example.nice.kotlinmvvm.viewmodel.AnimalViewModel

import kotlinx.android.synthetic.main.activity_animal.*

class AnimalActivity : AppCompatActivity() {

    lateinit var mViewMode: AnimalViewModel
    lateinit var mBinding: ActivityAnimalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_animal)
        //model
        val animal = Animal("dog", 0)
        //ViewModel
        mViewMode = AnimalViewModel(animal)
        //binding
        mBinding.vm = mViewMode
    }

}
