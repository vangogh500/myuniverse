/**
 * Store
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni_client
package data

import scala.concurrent.{Future, ExecutionContext}

/**
 * Store
 */
case class Store(config: Preferences)

/**
 * Store
 */
object Store {
  /**
   * Load store
   */
  def load()(implicit ec: ExecutionContext): Future[Store] = Preferences.load map { config => Store(config) }
}
