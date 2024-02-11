package ru.intfox.jsonrpc4cats

import io.circe.Json

case class Response(jsonrpc: String, result: Option[Json], error: Option[Response.Error])

object Response {
  case class Error(code: Int, message: String, data: Option[Json])
}