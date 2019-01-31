package com.github.vangogh500.myuni.renderer

import scala.concurrent.{Future, ExecutionContext}
import scala.scalajs.js
import com.github.vangogh500.myuni.core.facades.nodejs.FS

trait Bundle extends js.Object {
  val name: String
  val imgs: js.Array[String]
}

trait Manifest extends js.Object {
  val bundles: js.Array[Bundle]
}

object Manifest {
  val directory = "./res/asset/"
  def load()(implicit ec: ExecutionContext): Future[Manifest] = {
    FS.readFile(s"$directory/manifest.json") map { data =>
      js.JSON.parse(data.toString).asInstanceOf[Manifest]
    }
  }
  def getBundle(name: String)(implicit ec: ExecutionContext): Future[Bundle] = {
    load() map { manifest =>
      manifest.bundles.find(_.name == name) match {
        case Some(bundle) => bundle
        case None => throw new Exception("Invalid asset bundle name")
      }
    }
  }
}
