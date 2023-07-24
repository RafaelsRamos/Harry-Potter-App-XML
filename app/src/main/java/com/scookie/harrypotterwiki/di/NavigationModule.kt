package com.scookie.harrypotterwiki.di

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.scookie.harrypotterwiki.navigation.NavigatorImpl
import com.scookie.navigation.Navigator
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext


@Module
@InstallIn(ActivityComponent::class)
object NavigationModule {

    @Provides
    fun providesNavigator(@ActivityContext activity: Context): Navigator {
        return NavigatorImpl(activity as AppCompatActivity)
    }

}