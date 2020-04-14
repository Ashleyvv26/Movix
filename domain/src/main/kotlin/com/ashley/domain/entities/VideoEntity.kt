package com.ashley.domain.entities

<<<<<<< HEAD

=======
/**
 * Created by Yossi Segev on 11/01/2018.
 */
>>>>>>> git3/master
data class VideoEntity(
        var id: String,
        var name: String,
        var youtubeKey: String? = null) {

    companion object {
        const val SOURCE_YOUTUBE = "YouTube"
        const val TYPE_TRAILER = "Trailer"
    }
}