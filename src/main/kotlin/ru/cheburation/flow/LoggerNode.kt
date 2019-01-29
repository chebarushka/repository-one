package ru.cheburation.flow

import ru.cheburation.logging.LoggerDelegate

class LoggerNode(id: String) : Node(id) {

  private val log by LoggerDelegate()

  override fun receive(message: Message) = log.info("received: $message")

  override fun send(message: Message, address: String) = log.info("send: $message to [$address]")

  override fun process(message: Message) = log.info("process: $message")
}