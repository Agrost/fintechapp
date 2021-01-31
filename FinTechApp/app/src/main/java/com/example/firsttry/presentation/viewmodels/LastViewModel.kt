package com.example.firsttry.presentation.viewmodels

import com.example.firsttry.data.remote.LatestRemoteSourceImpl
import com.example.firsttry.domain.BaseInteractor
import com.example.firsttry.domain.MainInteractor
import com.example.firsttry.DI

class LastViewModel : BaseViewModel() {
    override val interactor: BaseInteractor = MainInteractor(LatestRemoteSourceImpl(DI.getApi()), DI.getLatestCache())
}