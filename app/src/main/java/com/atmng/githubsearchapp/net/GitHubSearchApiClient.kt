package com.atmng.githubsearchapp.net

import javax.inject.Inject

interface GitHubSearchApiClient {
    // TODO implement
}

class GitHubSearchApiClientImpl @Inject constructor(
    private val gitHubSearchService: GitHubSearchService
) : GitHubSearchApiClient {
    // TODO implement
}