package com.github.vangogh500.myuni.renderer

import scala.concurrent.ExecutionContext.Implicits.global
import facades.three.{FontLoader}

object Main {
  def main(args: Array[String]): Unit = {
    new App().start()
  }
}
