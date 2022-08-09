package com.atmng.githubsearchapp.ui.search_user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.atmng.githubsearchapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_user)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SearchUserFragment.newInstance())
                .commitNow()
        }
    }
}