package com.example.gifViewing.presentation.viewmodels

import com.example.gifViewing.DI
import com.example.gifViewing.data.remote.HotRemoteSourceImpl
import com.example.gifViewing.domain.BaseInteractor
import com.example.gifViewing.domain.MainInteractor

class HotViewModel : BaseViewModel() {
    override val interactor: BaseInteractor =
        MainInteractor(HotRemoteSourceImpl(DI.getApi()), DI.getHotCache())
}