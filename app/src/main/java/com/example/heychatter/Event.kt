package com.example.heychatter

open class Event<out T>(val content: T) {

    var hasbeenhandled = false
    fun getContentorNull(): T? {
        return if (hasbeenhandled) null
        else {
            hasbeenhandled = true
            return content
        }
    }
}