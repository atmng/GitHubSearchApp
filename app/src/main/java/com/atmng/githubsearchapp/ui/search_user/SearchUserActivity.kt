package com.atmng.githubsearchapp.ui.search_user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.atmng.githubsearchapp.R

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