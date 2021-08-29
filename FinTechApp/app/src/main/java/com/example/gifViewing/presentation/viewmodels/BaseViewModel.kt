package com.example.gifViewing.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gifViewing.data.Answer
import com.example.gifViewing.domain.BaseInteractor
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class BaseViewModel : ViewModel() {
    private val disposable: CompositeDisposable = CompositeDisposable()
    private val post: MutableLiveData<Answer> = MutableLiveData()
    private var isAvailable: MutableLiveData<Boolean> = MutableLiveData()
    protected abstract val interactor: BaseInteractor

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    fun getPost() = post

    fun getAccessStatus() = isAvailable

    fun getNextPost() {
        isAvailable.value = true
        postGetter(interactor.nextPost())
    }

    fun getCurrentPost() {
        postGetter(interactor.currentPost())
    }

    fun getPrevPost() {
        isAvailable.value = interactor.isPrevPostAvailable()
        postGetter(interactor.prevPost())
    }

     private fun postGetter(postAvailable: Single<Answer>) {
        disposable.add(postAvailable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorReturnItem(Answer.Failure)
            .subscribe { answer -> post.value = answer })
    }
}