package com.ardnn.mymanga

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comic(
    var title: String?,
    var author: String?,
    var publisher: String?,
    var summary: String?,
    var synopsis: String?,
    var image: Int,
    var wallpaper: Int
) : Parcelable


/**
* without parcelize
data class Comic(
var title: String? = "",
var author: String? = "",
var publisher: String? = "",
var summary: String? = "",
var synopsis: String? = "",
var image: Int? = 0,
var wallpaper: Int? = 0
) : Parcelable {
constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()) {
}

override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(title)
    parcel.writeString(author)
    parcel.writeString(publisher)
    parcel.writeString(summary)
    parcel.writeString(synopsis)
    parcel.writeInt(image)
    parcel.writeInt(wallpaper)
}

override fun describeContents(): Int {
    return 0
}

companion object CREATOR : Parcelable.Creator<Comic> {
    override fun createFromParcel(parcel: Parcel): Comic {
        return Comic(parcel)
    }

    override fun newArray(size: Int): Array<Comic?> {
        return arrayOfNulls(size)
    }
}
}

*/