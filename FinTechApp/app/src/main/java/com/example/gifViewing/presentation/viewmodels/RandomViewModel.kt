package com.example.gifViewing.presentation.viewmodels

import com.example.gifViewing.domain.BaseInteractor
import com.example.gifViewing.domain.RandomInteractorImpl

class RandomViewModel : BaseViewModel() {
    override val interactor: BaseInteractor = RandomInteractorImpl()
}