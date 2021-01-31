package com.example.firsttry.presentation.viewmodels

import com.example.firsttry.data.remote.BestRemoteSourceImpl
import com.example.firsttry.domain.BaseInteractor
import com.example.firsttry.domain.MainInteractor
import com.example.firsttry.DI

class BestViewModel: BaseViewModel() {
    override val interactor: BaseInteractor = MainInteractor(BestRemoteSourceImpl(DI.getApi()), DI.getBestCache())
}