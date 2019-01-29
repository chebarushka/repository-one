package ru.cheburation.flow

class PlainMessage(
  private val id: String,
  private val type: String
) : Message {

  override fun id() = id

  override fun type() = type

  override fun toString() = "PlainMessage('$type')['$id']"
}