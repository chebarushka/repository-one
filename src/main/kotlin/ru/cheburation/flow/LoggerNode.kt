package ru.cheburation.flow

class LoggerNode(private val id: String) : Node {

  override fun receive(message: Message) {
    println("received: $message")
  }

  override fun send(message: Message, address: String) {
    println("send: $message to [$address]")
  }

  override fun process(message: Message) {
    println("process: $message")
  }

  override fun id() = id
}