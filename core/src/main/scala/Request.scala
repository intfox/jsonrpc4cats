package ru.intfox.jsonrpc4cats

import io.circe.Json

case class Request(jsonrpc: String, method: String, params: Option[Json], id: Option[Long])
