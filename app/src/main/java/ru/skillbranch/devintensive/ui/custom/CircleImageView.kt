package ru.skillbranch.devintensive.ui.custom

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.ImageView

@SuppressLint("AppCompatCustomView")
class CircleImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {
    fun setInitials(init: String) {
        Log.d("A_AvatarImageView", init)
    }
}