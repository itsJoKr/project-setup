package com.example.jokr.propermock.dagger

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import javax.inject.Inject
import javax.inject.Qualifier
import kotlin.reflect.KClass

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION)
annotation class ViewModelInjection

typealias LazyInjection<T> = dagger.Lazy<T>

class InjectionViewModelProvider<VM : ViewModel> @Inject constructor(
    private val lazyViewModel: dagger.Lazy<VM>
) {

    @Suppress("UNCHECKED_CAST")
    private val viewModelFactory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>) = lazyViewModel.get() as T
    }

    fun <ACTIVITY : FragmentActivity> get(activity: ACTIVITY, viewModelClass: KClass<VM>): VM {
        return ViewModelProviders.of(activity, viewModelFactory).get(viewModelClass.java)
    }

    fun <FRAGMENT : Fragment> get(fragment: FRAGMENT, viewModelClass: KClass<VM>): VM {
        return ViewModelProviders.of(fragment, viewModelFactory).get(viewModelClass.java)
    }
}