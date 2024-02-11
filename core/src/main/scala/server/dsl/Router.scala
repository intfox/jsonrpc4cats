package ru.intfox.jsonrpc4cats
package server.dsl

import io.circe.{Decoder, Encoder, Json}
import cats.effect.kernel.Sync
import cats.syntax.all._

class Method[F[_]](name: String, f: Json => F[Json])

class Router[F[_]](methods: List[Method[F]])

/*

  Router(
    Method("hello", (request: String)  => IO("Hello ${request.name}"))
  )

*/
object Router {

  def apply[F[_]](methods: Method[F]*): Router[F] = new Router(methods.toList)
}

object Method {
  def apply[F[_]: Sync, Params: Decoder, Result: Encoder](methodName: String, f: Params => F[Result]): Method[F] =
    new Method(methodName, (json: Json) =>
      for {
        params <- Sync[F].fromEither(json.as[Params])
        res <- f(params)
      } yield Encoder[Result].apply(res)
    )

}
