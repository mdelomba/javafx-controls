package example

import javafx.application.Application

object Main {
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[Main], args: _*)
    println("Hello, world!")
  }
}

/** Testing this should be simple enough, I already manually typed in the import
  * for Application. This allows us to use the code actions for Main. This will
  * ask us to implement all methods which we will accept. Notice that Stage will
  * be imported. This is the functionality we expect. Now remove the import for
  * Stage and save the file, this should add an error for Stage. Perform a code
  * action import on Stage, notice that it can't find the import.
  */
class Main extends Application {}
