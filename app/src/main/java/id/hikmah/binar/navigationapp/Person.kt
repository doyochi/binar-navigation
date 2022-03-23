package id.hikmah.binar.navigationapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val nama: String,
    val usia: Int,
): Parcelable