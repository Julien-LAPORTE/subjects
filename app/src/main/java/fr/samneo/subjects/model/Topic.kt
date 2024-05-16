package fr.samneo.subjects.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val category: Int,
    val numberOfcourses: Int,
    @DrawableRes val picture: Int,
)
