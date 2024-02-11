package ru.intfox.jsonrpc4cats
package server

import server.dsl.Router

trait Server[F[_]] {

  def run(router: Router[F]): F[Unit] = ???

  protected def
  8952

}



