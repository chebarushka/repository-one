package ru.cheburation

import java.util.concurrent.ThreadLocalRandom

class Random : Chatterbox() {

  override fun addressee(count: Long) = ThreadLocalRandom.current().nextLong(0, count)
}