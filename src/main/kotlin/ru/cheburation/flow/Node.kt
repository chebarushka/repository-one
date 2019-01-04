package ru.cheburation.flow

interface Node {

  fun id(): String

  fun recieve(message: Message)

  fun send(message: Message, address: String)

  fun process(message: Message)
}