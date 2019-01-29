package ru.cheburation.flow

abstract class Node(internal val id: String) {

  abstract fun receive(message: Message)

  abstract fun send(message: Message, address: String)

  abstract fun process(message: Message)
}