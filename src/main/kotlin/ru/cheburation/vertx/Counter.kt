package ru.cheburation.vertx

import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.Vertx
import io.vertx.core.shareddata.Counter
import io.vertx.kotlin.coroutines.awaitResult

class Counter private constructor(private val counter: Counter) {

  companion object {
    suspend operator fun invoke(vertx: Vertx, name: String) = Counter(awaitResult { vertx.sharedData().getCounter(name, it) })
  }

  fun get(handler: (Long) -> Unit) = counter.get {
    if (it.succeeded()) {
      handler(it.result())
    }
  }

  suspend fun get(): Long = await { get(it) }

  suspend fun inc(): Long = await { incrementAndGet(it) }

  suspend fun dec(): Long = await { decrementAndGet(it) }

  suspend fun inc(value: Long): Long = await { addAndGet(value, it) }

  suspend fun dec(value: Long): Long = await { addAndGet(-value, it) }

  suspend fun set(expected: Long, value: Long): Boolean = awaitResult { counter.compareAndSet(expected, value, it) }

  private suspend fun await(call: Counter.(Handler<AsyncResult<Long>>) -> Unit): Long = awaitResult { counter.call(it) }
}
