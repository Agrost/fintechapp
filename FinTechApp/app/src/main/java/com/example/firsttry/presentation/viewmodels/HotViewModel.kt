package com.example.firsttry.presentation.viewmodels

import com.example.firsttry.data.remote.HotRemoteSourceImpl
import com.example.firsttry.domain.BaseInteractor
import com.example.firsttry.domain.MainInteractor
import com.example.firsttry.DI

class HotViewModel : BaseViewModel() {
    override val interactor: BaseInteractor = MainInteractor(HotRemoteSourceImpl(DI.getApi()), DI.getHotCache())
}