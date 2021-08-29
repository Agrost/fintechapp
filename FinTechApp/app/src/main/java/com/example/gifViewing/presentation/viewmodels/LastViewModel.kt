package com.example.gifViewing.presentation.viewmodels

import com.example.gifViewing.DI
import com.example.gifViewing.data.remote.LatestRemoteSourceImpl
import com.example.gifViewing.domain.BaseInteractor
import com.example.gifViewing.domain.MainInteractor

class LastViewModel : BaseViewModel() {
    override val interactor: BaseInteractor =
        MainInteractor(LatestRemoteSourceImpl(DI.getApi()), DI.getLatestCache())
}