package com.ashley.peliculas.common

import android.app.ActivityOptions
import android.support.v4.app.Fragment
import android.util.Pair
import android.view.View
import com.ashley.peliculas.R
import com.ashley.peliculas.details.MovieDetailsActivity
import com.ashley.peliculas.entities.Movie


open class BaseFragment: Fragment() {

    protected fun navigateToMovieDetailsScreen(movie: Movie, view: View) {
        var activityOptions: ActivityOptions? = null

        val imageForTransition: View? = view.findViewById(R.id.image)
        imageForTransition?.let {
            val posterSharedElement: Pair<View, String> = Pair.create(it, getString(R.string.transition_poster))
            activityOptions = ActivityOptions.makeSceneTransitionAnimation(activity, posterSharedElement)
        }
        startActivity(MovieDetailsActivity.newIntent(
                context!!,
                movie.id,
                movie.posterPath), activityOptions?.toBundle())

        activity?.overridePendingTransition(0, 0)
    }
}