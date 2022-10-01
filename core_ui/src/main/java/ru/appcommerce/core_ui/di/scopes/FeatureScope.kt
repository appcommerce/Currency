package ru.appcommerce.core_ui.di.scopes

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class FeatureScope
