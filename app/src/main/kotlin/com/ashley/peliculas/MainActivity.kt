package com.ashley.peliculas

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout

import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toolbar
import com.ashley.peliculas.favorites.FavoriteMoviesFragment
import com.ashley.peliculas.popularmovies.PopularMoviesFragment
import com.ashley.peliculas.search.SearchFragment
import com.ashley.peliculas.watchlist.WatchListMoviesFragment
import com.squareup.haha.perflib.Main.main
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var navigationBar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        //val navView: NavigationView = findViewById(R.id.nav_view)
        //val navController = findNavController(R.id.nav_host_fragment)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, PopularMoviesFragment(), "popular")
                    .commitNow()
            title = getString(R.string.popular)
        }

        navigationBar = bottomNavigationView
        navigationBar.setOnNavigationItemSelectedListener(this)
    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.itemId == navigationBar.selectedItemId) {
            return false
        }

        when (item.itemId) {

            R.id.action_popular -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.container, PopularMoviesFragment(), "popular")
                        .commitNow()
                title = getString(R.string.popular)
            }

            R.id.action_favorites -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.container, FavoriteMoviesFragment(), "favorites")
                        .commitNow()
                title = getString(R.string.my_favorites)
            }

            R.id.action_search -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SearchFragment(), "search")
                        .commitNow()
                title = getString(R.string.search)
            }

            R.id.action_watchlist -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.container, WatchListMoviesFragment(), "watchlist")
                        .commitNow()
                title = getString(R.string.ver_despues)
            }
        }

        return true
    }

}
