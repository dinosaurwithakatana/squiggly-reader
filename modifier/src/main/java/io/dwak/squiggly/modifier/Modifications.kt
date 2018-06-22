package io.dwak.squiggly.modifier

sealed class Modifications {
  data class submitStory(uiStory: UiStory)
}