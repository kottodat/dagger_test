package com.kottodat.dagger2.di

import com.kottodat.dagger2.model.ChocoIscream
import com.kottodat.dagger2.model.Iscream
import dagger.Module
import dagger.Provides

@Module
class HaagendazsModule {
    @Provides
    internal fun provideIscream(): Iscream {
        return ChocoIscream()
    }
}