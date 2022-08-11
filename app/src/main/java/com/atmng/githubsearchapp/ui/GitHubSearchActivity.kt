package com.atmng.githubsearchapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.atmng.githubsearchapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GitHubSearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_search)
    }
}