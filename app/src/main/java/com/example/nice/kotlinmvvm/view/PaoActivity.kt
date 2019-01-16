package com.example.nice.kotlinmvvm.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nice.kotlinmvvm.R
import com.example.nice.kotlinmvvm.databinding.ActivityPaoBinding
import com.example.nice.kotlinmvvm.model.remote.PaoService
import com.example.nice.kotlinmvvm.viewmodel.PaoViewModel
import retrofit2.Retrofit.*
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PaoActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityPaoBinding
    lateinit var mViewMode: PaoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_pao)

        //////model
        val remote= Builder()
                .baseUrl("http://api.jcodecraeer.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(PaoService::class.java)

        /////ViewModel
        mViewMode= PaoViewModel(remote)
        ////binding
        mBinding.vm=mViewMode
    }
}
