package ru.cheburation.flow

interface Message {

  fun id(): String

  fun type(): String
}
