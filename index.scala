//> using platform js
//> using scala 3.7

import scala.scalajs.js.annotation.*

object Index {
  @JSExportTopLevel(name = "handler", moduleID = "index")
  def handler(): Unit = {
    println("Hello world!")
  }
}

// https://github.com/VirtusLab/scala-cli/issues/3964
object Hello {
  def main(args: Array[String]): Unit = 42
}
