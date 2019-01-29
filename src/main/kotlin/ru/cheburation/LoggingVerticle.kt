package ru.cheburation

import io.vertx.core.AbstractVerticle
import ru.cheburation.logging.LoggerDelegate

class LoggingVerticle : AbstractVerticle() {
  private val log by LoggerDelegate()

  override fun start() {
    vertx.eventBus().consumer<String>("logging") { e -> log.info(e.body()) }
  }
}