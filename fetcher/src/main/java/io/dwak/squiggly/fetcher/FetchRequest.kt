package io.dwak.squiggly.fetcher

sealed class FetchRequest {
  data class Story(val id: String): FetchRequest()
  data class Comment(val id: String): FetchRequest()
  data class User(val id: String): FetchRequest()
}
