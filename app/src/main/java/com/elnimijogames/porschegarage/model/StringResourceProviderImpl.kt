package com.elnimijogames.porschegarage.model

import android.content.res.Resources

class StringResourceProviderImpl(private val resources: Resources) :
    StringResourceProvider {

    override fun getString(resourceId: Int, parameter: String): String =
        resources.getString(resourceId, parameter)
}