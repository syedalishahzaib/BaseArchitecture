package com.asrstudios.islamtoolkit.netwrok.dispatcher

import com.asrstudios.islamtoolkit.base.BaseRequestDispatcher
import com.asrstudios.islamtoolkit.netwrok.repository.HomeRemoteRepository
import javax.inject.Inject

class HomeDispatcher @Inject constructor(remoteRepo: HomeRemoteRepository) : BaseRequestDispatcher(remoteRepo) {
}