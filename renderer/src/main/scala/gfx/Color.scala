/**
 * Color
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.renderer
package gfx

/**
 * Color
 */
case class Color(r: Int, g: Int, b: Int, a: Int) {
  /**
   * Get RGBA value
   */
  def toRGBA: (Int, Int, Int, Int) = (r, g, b, a)
  /**
   * Get RGB value
   */
  def toRGB: (Int, Int, Int) = (r, g, b)
  /**
   * Get Hexstring with Alpha
   */
  def toAlphaHexString: String = a.toHexString + r.toHexString + g.toHexString + b.toHexString
  /**
   * Get Hexstring
   */
  def toHexString: String = r.toHexString + g.toHexString + b.toHexString
}

/**
 * Color
 */
object Color {
  /**
   * Regex for hexstring with alpha
   */
  private val alphahexstring = """^([0-9a-fA-F]{8})$""".r
  /**
   * Regex for hash prefixed hexstring with alpha
   */
  private val hashalphahexstring = """^#([0-9a-fA-F]{8})$""".r
  /**
   * Regex for hexstring
   */
  private val hexstring = """^([0-9a-fA-F]{6})$""".r
  /**
   * Regex for hash prefixed hexstring
   */
  private val hashhexstring = """^#([0-9a-fA-F]{6})$""".r
  /**
   * Create a color from hexstring
   */
  private def fromHexString(hex: String): Color = Color(
    Integer.parseInt(hex.slice(0,2), 16),
    Integer.parseInt(hex.slice(2,4), 16),
    Integer.parseInt(hex.slice(4,6), 16),
    1
  )
  /**
   * Create a color from hexstring with alpha
   */
  private def fromAlphaHexString(hex: String): Color = Color(
    Integer.parseInt(hex.slice(2,4), 16),
    Integer.parseInt(hex.slice(4,6), 16),
    Integer.parseInt(hex.slice(6,8), 16),
    Integer.parseInt(hex.slice(0,2), 16)
  )
  /**
   * Create a color from a string (either hex or hash prefixed hex)
   */
  def apply(str: String): Color = str match {
    case hexstring(hex) => fromHexString(hex)
    case hashhexstring(hex) => fromHexString(hex)
    case alphahexstring(alphahex) => fromAlphaHexString(alphahex)
    case hashalphahexstring(alphahex) => fromAlphaHexString(alphahex)
  }
  /**
   * Create a color from rgb
   */
  def apply(r: Int, g: Int, b: Int): Color = Color(r, g, b, 1)
  /**
   * Create a color from rgba
   */
  def apply(r: Int, g: Int, b: Int, a: Int): Color = Color(r, g, b, a)
  /**
   * Black color
   */
  val Black = Color(0,0,0)
}
