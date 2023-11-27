package com.galataapplab.boruto_application.domain.use_cases.read_onboarding

import com.galataapplab.boruto_application.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Boolean> {
        return repository.readOnBoardingState()
    }
}