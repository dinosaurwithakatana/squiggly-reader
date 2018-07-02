package io.dwak.squiggly.fetcher

interface Fetcher {
  fun fetch(fetchRequest: FetchRequest)
}