/**
 * Facade for FS
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.core
package facades
package nodejs

import scala.concurrent.{Future, Promise}
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
 * Native FS
 */
@js.native
@JSImport("fs", JSImport.Namespace)
object NativeFS extends js.Object {
  def readFile(path: String, callback: js.Function2[Error, Buffer, Unit]): Unit = js.native
  def existsSync(path: String): Boolean = js.native
  def writeFile(path: String, data: String, callback: js.Function1[Error, Unit]): Unit = js.native
  def writeFileSync(path: String, data: String): Unit = js.native
}

/**
 * FS
 */
object FS {
  /**
   * Asynchronously reads the entire contents of a file
   * @param path file path
   * @param callback callback
   */
  def readFile(path: String): Future[Buffer] = {
    val p = Promise[Buffer]()
    NativeFS.readFile(path, (e, data) => Option(e) match {
      case Some(e) => p failure e
      case None => p success data
    })
    p.future
  }
  /**
   * Asynchronously writes file
   * @param path file path
   * @param data data to write to file
   * @param callback callback
   */
  def writeFile(path: String, data: String): Future[Unit] = {
    val p = Promise[Unit]()
    NativeFS.writeFile(path, data, (e) => Option(e) match {
      case Some(e) => p failure e
      case None => p success ()
    })
    p.future
  }
  /**
   * Returns true if the path exists, false otherwise
   * @param path path to test
   */
  def existsSync(path: String): Boolean = NativeFS.existsSync(path)
  /**
   * Writes file
   * @param path file path
   * @param data data to write to file
   */
  def writeFileSync(path: String, data: String): Unit = NativeFS.writeFileSync(path, data)
}
