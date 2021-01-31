package com.example.firsttry.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firsttry.data.Answer
import com.example.firsttry.domain.BaseInteractor
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class BaseViewModel : ViewModel() {
    private val disposable: CompositeDisposable = CompositeDisposable()
    val post: MutableLiveData<Answer> = MutableLiveData()
    var isAvailable: MutableLiveData<Boolean> = MutableLiveData()
    protected abstract val interactor: BaseInteractor

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    fun getNextPost() {
        isAvailable.value = true
        disposable.add(interactor.nextPost().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorReturnItem(Answer.Failure)
            .subscribe { answer -> post.value = answer })
    }

    fun getCurrentPost() {
        disposable.add(interactor.currentPost().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorReturnItem(Answer.Failure)
            .subscribe { answer -> post.value = answer })
    }

    fun getPrevPost() {
        isAvailable.value = interactor.isPrevPostAvailable()
        disposable.add(interactor.prevPost().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorReturnItem(Answer.Failure)
            .subscribe { answer -> post.value = answer })
    }
}