package ru.cheburation

import io.vertx.core.Future
import io.vertx.kotlin.coroutines.CoroutineVerticle
import kotlinx.coroutines.launch
import ru.cheburation.vertx.Counter
import java.util.concurrent.atomic.AtomicLong

abstract class Chatterbox() : CoroutineVerticle() {

  companion object {
    val address = "verticle#"
  }

  override fun start(startFuture: Future<Void>?) {
    val sent: AtomicLong = AtomicLong()
    val recieved: AtomicLong = AtomicLong()

    launch {
      val verticles = Counter(vertx, "verticles")

      vertx.eventBus().consumer<String>("$address${verticles.inc()}") {
        println("recieved: ${recieved.incrementAndGet()}")
      }

      vertx.setPeriodic(500) {
        verticles.get {
          vertx.eventBus().send("$address${addressee(it).limit(it)}", "message")
          println("sent: ${sent.incrementAndGet()}")
        }
      }

      startFuture?.complete()
    }
  }

  abstract fun addressee(count: Long): Long
}

private fun Long.limit(cap: Long) = if (this > cap) cap else this
