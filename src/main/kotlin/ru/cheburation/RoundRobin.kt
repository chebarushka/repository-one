package ru.cheburation

class RoundRobin(private var next: Long = 0) : Chatterbox() {

  override fun addressee(count: Long): Long {
    if (++next > count) {
      next = 1
    }
    return next
  }
}