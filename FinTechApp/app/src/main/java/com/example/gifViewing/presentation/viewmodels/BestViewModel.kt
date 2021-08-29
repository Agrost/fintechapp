package com.example.gifViewing.presentation.viewmodels

import com.example.gifViewing.DI
import com.example.gifViewing.data.remote.BestRemoteSourceImpl
import com.example.gifViewing.domain.BaseInteractor
import com.example.gifViewing.domain.MainInteractor

class BestViewModel : BaseViewModel() {
    override val interactor: BaseInteractor =
        MainInteractor(BestRemoteSourceImpl(DI.getApi()), DI.getBestCache())
}