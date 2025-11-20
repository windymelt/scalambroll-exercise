//> using platform js
//> using scala 3.7

import scala.scalajs.js
import scala.scalajs.js.annotation.*

@js.native
trait Event extends js.Object {
  val name: String = js.native
}

@js.native
trait Context extends js.Object

trait Response extends js.Object {
  val statusCode: Int
  val body: String
}

object Index {
  @JSExportTopLevel(name = "handler", moduleID = "index")
  def handler(
      event: Event,
      context: Context,
      callback: js.Function2[Null, Response, Unit]
  ): Unit = {
    println(s"Hello, ${event.name}!")
    val resp = new Response {
      val statusCode: Int = 200
      val body: String = s"Hello, ${event.name}!"
    }
    callback(null, resp)
  }
}

// This object is just a dummy to package module
// https://github.com/VirtusLab/scala-cli/issues/3964
object Hello {
  def main(args: Array[String]): Unit = 42
}
