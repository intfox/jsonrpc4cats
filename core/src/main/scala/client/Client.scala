package ru.intfox.jsonrpc4cats
package client

import io.circe.{Decoder, Encoder}

trait Client[F[_]] {
  def run[Params: Encoder, Result: Decoder](method: String, a: Params): F[Result]
}
