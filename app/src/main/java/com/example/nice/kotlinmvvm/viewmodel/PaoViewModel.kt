package com.example.nice.kotlinmvvm.viewmodel

import android.databinding.ObservableField
import com.example.nice.kotlinmvvm.model.data.Article
import com.example.nice.kotlinmvvm.model.remote.PaoService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.*

class PaoViewModel(val remote: PaoService) {
    ////data
    val articleDetail = ObservableField<String>()


    ///bind
    fun loadArticle() {
        //为了简单起见这里先写个默认的id
        remote.getArticleDetail(8773)
                .subscribeOn(io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t: Article? ->
                    articleDetail.set(t?.toString())
                }, { t: Throwable? ->
                    articleDetail.set(t?.message ?: "error")
                })
    }
}