package com.example.natifetesttask.domain.viewmodel.base

import androidx.lifecycle.ViewModel
import kotlin.reflect.KClass

@dagger.MapKey
@Target(
    AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER
)
annotation class ViewModelKey(val value: KClass<out ViewModel>)