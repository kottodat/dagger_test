package com.kottodat.dagger2.di

import com.kottodat.dagger2.model.Iscream
import com.kottodat.dagger2.model.VanillaIscream
import dagger.Module
import dagger.Provides


@Module
class HaagendazsModule {
    @Provides
    internal fun provideIscream(): Iscream {
        return VanillaIscream()
    }
}

