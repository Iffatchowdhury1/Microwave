package microwave.model

class Microwave() {
  var state: State = new Start(this)
  var cooktime = "0"
  var powerLevel = "100"


  // Accessed by View. You should edit this method as you build functionality
  def currentInstructions(): Instructions = {
    new Instructions(0, 0)
    this.state.currentInstructions()
  }

  // Accessed by View. You should edit this method as you build functionality
  def doorOpen(): Boolean = {
    this.state.doorOpen()

  }


  def openDoor(): Unit = {
    this.state.openDoor()
  }

  def closeDoor(): Unit = {
    this.state.closeDoor()
  }

  def startPressed(): Unit = {
    this.state.startPressed()
  }

  def powerLevelPressed(): Unit = {
    this.state.powerLevelPressed()
  }

  def cookTimePressed(): Unit = {
    this.state.cookTimePressed()
  }

  def thirtySecondsPressed(): Unit = {
    this.state.thirtySecondsPressed()
  }

  def popcornPressed(): Unit = {
    this.state.popcornPressed()
  }

  def clearPressed(): Unit = {
    this.state.clearPressed()
  }

  def numberPressed(number: Int): Unit = {
    this.state.numberPressed(number: Int)
  }

}

abstract class State(banner:Microwave){
  def currentInstructions(): Instructions
  def doorOpen(): Boolean
  def openDoor(): Unit = {}
  def closeDoor(): Unit = {}
  def startPressed(): Unit = {}
  def powerLevelPressed(): Unit = {}
  def cookTimePressed(): Unit = {}
  def thirtySecondsPressed(): Unit = {}
  def popcornPressed(): Unit = {}
  def clearPressed(): Unit = {}
  def numberPressed(number: Int): Unit = {}

}




class Start(banner: Microwave) extends State(banner) {
  override def currentInstructions(): Instructions = {
    new Instructions(0, 0)
  }

  override def doorOpen(): Boolean = {
    false
  }

  override def cookTimePressed(): Unit = {
    banner.cooktime = "0"


  }

  override def numberPressed(number: Int): Unit = {
    banner.cooktime = banner.cooktime + number.toString
    banner.state = new Close(banner)
  }

  override def powerLevelPressed(): Unit = {
    banner.powerLevel = "0"
    banner.state = new ClosePower(banner)

  }

  override def openDoor(): Unit = {
    banner.state = new Open(banner)
  }

  override def thirtySecondsPressed(): Unit = {
    banner.cooktime = (banner.cooktime.toInt + 30).toString
    banner.state = new StartRunning(banner)
  }
  override def popcornPressed(): Unit = {
    banner.powerLevel = "100"
    banner.cooktime = "140"
    banner.state = new Running(banner)
  }

  override def clearPressed(): Unit = {
    banner.cooktime = "0"
    banner.powerLevel = "100"
  }



}




class Open(banner: Microwave) extends State(banner) {
  override def currentInstructions(): Instructions = {
    new Instructions(0, 0)
  }
  override def doorOpen(): Boolean = {
    true
  }
  override def cookTimePressed(): Unit = {
    banner.cooktime = "0"
  }

  override def numberPressed(number: Int): Unit = {
    banner.cooktime = banner.cooktime + number.toString
  }

  override def powerLevelPressed(): Unit = {
    banner.powerLevel = "0"
    banner.state = new OpenPower(banner)
  }

  override def thirtySecondsPressed(): Unit = {
    banner.cooktime = (banner.cooktime.toInt + 30).toString
  }
  override def popcornPressed(): Unit = {
    banner.powerLevel = "100"
    banner.cooktime = "140"
    banner.state = new NewOpen(banner)
  }

  override def clearPressed(): Unit = {
    banner.cooktime = "0"
    banner.powerLevel = "100"
    banner.state = new OpenStart(banner)
  }

  override def closeDoor(): Unit = {
    banner.state = new Close(banner)
  }

}


class OpenStart(banner: Microwave) extends State(banner) {
  override def currentInstructions(): Instructions = {
    new Instructions(0, 0)
  }

  override def doorOpen(): Boolean = {
    true
  }

  override def cookTimePressed(): Unit = {
    banner.cooktime = "0"
    banner.state = new Open(banner)
  }

  override def numberPressed(number: Int): Unit = {
    banner.cooktime = banner.cooktime + number.toString
    banner.state = new Open(banner)
  }

  override def powerLevelPressed(): Unit = {
    banner.powerLevel = "0"
    banner.state = new OpenPower(banner)
  }

  override def thirtySecondsPressed(): Unit = {
    banner.cooktime = (banner.cooktime.toInt + 30).toString
    banner.state = new Open(banner)
  }
  override def popcornPressed(): Unit = {
    banner.powerLevel = "100"
    banner.cooktime = "140"
    banner.state = new Open(banner)
  }

  override def clearPressed(): Unit = {
    banner.cooktime = "0"
    banner.powerLevel = "100"
  }
  override def closeDoor(): Unit = {
    banner.state = new Close(banner)
  }


}










class Close(banner: Microwave) extends State(banner) {
  override def currentInstructions(): Instructions = {
    new Instructions(0, 0)
  }

  override def doorOpen(): Boolean = {
    false
  }

  override def cookTimePressed(): Unit = {
    banner.cooktime = "0"
  }

  override def numberPressed(number: Int): Unit = {
    banner.cooktime = banner.cooktime + number.toString
  }

  override def powerLevelPressed(): Unit = {
    banner.powerLevel = "0"
    banner.state = new ClosePower(banner)
  }

  override def openDoor(): Unit = {
    banner.state = new Open(banner)
  }
  override def thirtySecondsPressed(): Unit = {
    banner.cooktime = (banner.cooktime.toInt + 30).toString
  }
  override def popcornPressed(): Unit = {
    banner.powerLevel = "100"
    banner.cooktime = "140"
    banner.state = new Running(banner)
  }

  override def clearPressed(): Unit = {
    banner.cooktime = "0"
    banner.powerLevel = "100"
    banner.state = new Start(banner)
  }

  override def startPressed(): Unit = {
    banner.cooktime =  banner.cooktime
    banner.powerLevel = banner.powerLevel
    banner.state = new Running(banner)
  }

}



class ClosePower(banner: Microwave) extends State(banner) {
  override def currentInstructions(): Instructions = {
    new Instructions(0, 0)
  }

  override def doorOpen(): Boolean = {
    false
  }

  override def cookTimePressed(): Unit = {
    banner.cooktime = "0"
    banner.powerLevel = banner.powerLevel
    banner.state = new Close(banner)
  }

  override def numberPressed(number: Int): Unit = {
    banner.powerLevel = banner.powerLevel + number.toString
    banner.powerLevel = (banner.powerLevel.last.toString.toInt * 10).toString
  }

  override def powerLevelPressed(): Unit = {
    banner.powerLevel = "0"
  }

  override def openDoor(): Unit = {
    banner.state = new NewOpen(banner)
  }

  
  override def popcornPressed(): Unit = {
    banner.powerLevel = "100"
    banner.cooktime = "140"
    banner.state = new Running(banner)
  }

  override def clearPressed(): Unit = {
    banner.cooktime = "0"
    banner.powerLevel = "100"
    banner.state = new Start(banner)
  }
  override def startPressed(): Unit = {
    banner.cooktime =  banner.cooktime
    banner.powerLevel = banner.powerLevel
    banner.state = new Running(banner)
  }



}

class OpenPower(banner: Microwave) extends State(banner) {
  override def currentInstructions(): Instructions = {
    new Instructions(0, 0)
  }

  override def doorOpen(): Boolean = {
    true
  }

  override def cookTimePressed(): Unit = {
    banner.cooktime = "0"
    banner.powerLevel = banner.powerLevel
    banner.state = new Open(banner)
  }

  override def numberPressed(number: Int): Unit = {
    banner.powerLevel = banner.powerLevel + number.toString
    banner.powerLevel = (banner.powerLevel.last.toString.toInt * 10).toString
  }

  override def powerLevelPressed(): Unit = {
    banner.powerLevel = "0"
  }



  override def popcornPressed(): Unit = {
    banner.powerLevel = "100"
    banner.cooktime = "140"
    banner.state = new Open(banner)
  }

  override def clearPressed(): Unit = {
    banner.cooktime = "0"
    banner.powerLevel = "100"
    banner.state = new OpenStart(banner)
  }
  override def closeDoor(): Unit = {
    banner.state = new NewClose(banner)
  }


}

class NewOpen(banner: Microwave) extends State(banner) {
  override def currentInstructions(): Instructions = {
    new Instructions(0, 0)
  }

  override def doorOpen(): Boolean = {
    true
  }

  override def cookTimePressed(): Unit = {
    banner.cooktime = "0"
    banner.powerLevel = banner.powerLevel
    banner.state = new Open(banner)
  }

  override def numberPressed(number: Int): Unit = {
    banner.powerLevel = banner.powerLevel + number.toString
    banner.powerLevel = (banner.powerLevel.last.toString.toInt * 10).toString

  }

  override def powerLevelPressed(): Unit = {
    banner.powerLevel = "0"
  }



  override def popcornPressed(): Unit = {
    banner.powerLevel = "100"
    banner.cooktime = "140"
    banner.state = new Open(banner)
  }

  override def clearPressed(): Unit = {
    banner.cooktime = "0"
    banner.powerLevel = "100"
    banner.state = new OpenStart(banner)
  }
  override def closeDoor(): Unit = {
    banner.state = new ClosePower(banner)
  }

}

class NewClose(banner: Microwave) extends State(banner) {
  override def currentInstructions(): Instructions = {
    new Instructions(0, 0)
  }

  override def doorOpen(): Boolean = {
    false
  }

  override def cookTimePressed(): Unit = {
    banner.cooktime = "0"
    banner.powerLevel = banner.powerLevel
    banner.state = new Close(banner)
  }

  override def numberPressed(number: Int): Unit = {
    banner.powerLevel = banner.powerLevel + number.toString
    banner.powerLevel = (banner.powerLevel.last.toString.toInt * 10).toString

  }

  override def powerLevelPressed(): Unit = {
    banner.powerLevel = "0"
  }

  override def openDoor(): Unit = {
    banner.state = new OpenPower(banner)
  }


  override def popcornPressed(): Unit = {
    banner.powerLevel = "100"
    banner.cooktime = "140"
    banner.state = new Running(banner)
  }

  override def clearPressed(): Unit = {
    banner.cooktime = "0"
    banner.powerLevel = "100"
    banner.state = new Start(banner)
  }
  override def startPressed(): Unit = {
    banner.cooktime =  banner.cooktime
    banner.powerLevel = banner.powerLevel
    banner.state = new Running(banner)
  }
}




class Running(banner: Microwave) extends State(banner) {
  override def currentInstructions(): Instructions = {
    new Instructions(banner.cooktime.toInt, banner.powerLevel.toInt)
  }
  override def doorOpen(): Boolean = {
    false
  }

  override def openDoor(): Unit = {
    banner.state = new Open(banner)
  }
  override def thirtySecondsPressed(): Unit = {
    banner.cooktime = (banner.cooktime.toInt + 30).toString
  }

  override def clearPressed(): Unit = {
    banner.cooktime = "0"
    banner.powerLevel = "100"
    banner.state = new Close(banner)
  }



}



class StartRunning(banner: Microwave) extends State(banner) {
  override def currentInstructions(): Instructions = {
    new Instructions(banner.cooktime.toInt, banner.powerLevel.toInt)
  }
  override def doorOpen(): Boolean = {
    false
  }

  override def openDoor(): Unit = {
    banner.state = new PlusOpen(banner)
  }
  override def thirtySecondsPressed(): Unit = {
    banner.cooktime = (banner.cooktime.toInt + 30).toString
  }

  override def clearPressed(): Unit = {
    banner.cooktime = "0"
    banner.powerLevel = "100"
    banner.state = new Close(banner)
  }




}

class PlusOpen(banner: Microwave) extends State(banner) {
  override def currentInstructions(): Instructions = {
    new Instructions(0, 0)
  }
  override def doorOpen(): Boolean = {
    true
  }
  override def cookTimePressed(): Unit = {
    banner.cooktime = "0"
    banner.state = new Open(banner)
  }

  override def numberPressed(number: Int): Unit = {
    banner.cooktime = "0"
    banner.cooktime = banner.cooktime + number.toString
    banner.state = new Open(banner)
  }

  override def powerLevelPressed(): Unit = {
    banner.powerLevel = "0"
    banner.state = new OpenPower(banner)
  }

  override def thirtySecondsPressed(): Unit = {
    banner.cooktime = (banner.cooktime.toInt + 30).toString
    banner.state = new Open(banner)
  }
  override def popcornPressed(): Unit = {
    banner.powerLevel = "100"
    banner.cooktime = "140"
    banner.state = new NewOpen(banner)
  }

  override def clearPressed(): Unit = {
    banner.cooktime = "0"
    banner.powerLevel = "100"
    banner.state = new OpenStart(banner)
  }

  override def closeDoor(): Unit = {
    banner.state = new Close(banner)
  }

}