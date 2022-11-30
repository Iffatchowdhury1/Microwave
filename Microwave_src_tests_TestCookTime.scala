package tests

import microwave.model.Microwave
import org.scalatest.FunSuite

class TestCookTime extends FunSuite {

  // Example test case
  test("Enter Time Cook") {
    val microwave: Microwave = new Microwave()

    microwave.numberPressed(3)
    microwave.numberPressed(0)

    assert(microwave.currentInstructions().cookTime == 0)

    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 30)

    val microwave1: Microwave = new Microwave()
    microwave1.thirtySecondsPressed()
    assert(microwave1.currentInstructions().cookTime == 30)

    val microwave2: Microwave = new Microwave()
    microwave2.thirtySecondsPressed()
    microwave2.startPressed()
    assert(microwave2.currentInstructions().cookTime == 30)
    microwave2.clearPressed()
    microwave2.numberPressed(1)
    microwave2.numberPressed(4)
    assert(microwave2.currentInstructions().cookTime == 0)
    microwave2.startPressed()
    assert(microwave2.currentInstructions().cookTime == 14)
    microwave2.thirtySecondsPressed()
    assert(microwave2.currentInstructions().cookTime == 44)



    val microwave3: Microwave = new Microwave()
    microwave3.numberPressed(1)
    microwave3.numberPressed(2)
    microwave3.startPressed()
    assert(microwave3.currentInstructions().cookTime == 12)
    microwave3.clearPressed()
    microwave3.numberPressed(4)
    microwave3.numberPressed(5)
    microwave3.startPressed()
    assert(microwave3.currentInstructions().cookTime == 45)
    microwave3.clearPressed()
    microwave3.numberPressed(6)
    microwave3.numberPressed(7)
    microwave3.startPressed()
    assert(microwave3.currentInstructions().cookTime == 67)
    microwave3.clearPressed()
    microwave3.numberPressed(8)
    microwave3.numberPressed(9)
    microwave3.startPressed()
    assert(microwave3.currentInstructions().cookTime == 89)

  }

}


class TestPowerLevel extends FunSuite {

  // Example test case
  test("Enter Power Level") {

    val microwave: Microwave = new Microwave()

    microwave.numberPressed(5)
    microwave.numberPressed(5)
    microwave.powerLevelPressed()
    microwave.numberPressed(5)
    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 55)
    assert(microwave.currentInstructions().powerLevel == 50)

    val microwave1: Microwave = new Microwave()
    microwave1.numberPressed(5)
    microwave1.numberPressed(5)
    microwave1.powerLevelPressed()
    microwave1.numberPressed(2)
    microwave1.cookTimePressed()
    microwave1.numberPressed(2)
    microwave1.numberPressed(5)
    microwave1.startPressed()

    assert(microwave1.currentInstructions().cookTime == 25)
    assert(microwave1.currentInstructions().powerLevel == 20)

    val microwave2: Microwave = new Microwave()
    microwave2.numberPressed(4)
    microwave2.numberPressed(5)
    microwave2.powerLevelPressed()
    microwave2.numberPressed(6)
    microwave2.numberPressed(8)
    microwave2.numberPressed(3)
    microwave2.startPressed()
    assert(microwave2.currentInstructions().cookTime == 45)
    assert(microwave2.currentInstructions().powerLevel == 30)





  }
}

class TestFullFunctionality extends FunSuite {

  // Example test case
  test("Enter Full") {

    val microwave: Microwave = new Microwave()

    assert(microwave.currentInstructions().cookTime == 0)
    assert(microwave.currentInstructions().powerLevel == 0)

    microwave.openDoor()
    microwave.startPressed()
    assert(microwave.currentInstructions().cookTime == 0)
    assert(microwave.currentInstructions().powerLevel == 0)
    microwave.numberPressed(3)
    microwave.powerLevelPressed()
    microwave.numberPressed(4)
    microwave.numberPressed(5)
    assert(microwave.currentInstructions().cookTime == 0)
    assert(microwave.currentInstructions().powerLevel == 0)
    microwave.closeDoor()
    assert(microwave.currentInstructions().cookTime == 0)
    assert(microwave.currentInstructions().powerLevel == 0)
    microwave.startPressed()
    assert(microwave.currentInstructions().cookTime == 3)
    assert(microwave.currentInstructions().powerLevel == 50)
    microwave.openDoor()
    assert(microwave.currentInstructions().cookTime == 0)
    assert(microwave.currentInstructions().powerLevel == 0)
    microwave.closeDoor()
    assert(microwave.currentInstructions().cookTime == 0)
    assert(microwave.currentInstructions().powerLevel == 0)
    microwave.startPressed()
    assert(microwave.currentInstructions().cookTime == 3)
    assert(microwave.currentInstructions().powerLevel == 50)
    microwave.openDoor()
    assert(microwave.currentInstructions().cookTime == 0)
    assert(microwave.currentInstructions().powerLevel == 0)
    microwave.closeDoor()
    microwave.powerLevelPressed()
    microwave.numberPressed(6)
    microwave.numberPressed(7)
    assert(microwave.currentInstructions().cookTime == 0)
    assert(microwave.currentInstructions().powerLevel == 0)
    microwave.startPressed()
    assert(microwave.currentInstructions().cookTime == 3)
    assert(microwave.currentInstructions().powerLevel == 70)
    microwave.clearPressed()
    assert(microwave.currentInstructions().cookTime == 0)
    assert(microwave.currentInstructions().powerLevel == 0)
    microwave.popcornPressed()
    assert(microwave.currentInstructions().cookTime == 140)
    assert(microwave.currentInstructions().powerLevel == 100)
    microwave.openDoor()
    assert(microwave.currentInstructions().cookTime == 0)
    assert(microwave.currentInstructions().powerLevel == 0)
    microwave.closeDoor()
    microwave.clearPressed()
    assert(microwave.currentInstructions().cookTime == 0)
    assert(microwave.currentInstructions().powerLevel == 0)
    microwave.openDoor()
    assert(microwave.currentInstructions().cookTime == 0)
    assert(microwave.currentInstructions().powerLevel == 0)
    microwave.popcornPressed()
    assert(microwave.currentInstructions().cookTime == 0)
    assert(microwave.currentInstructions().powerLevel == 0)
    microwave.closeDoor()
    assert(microwave.currentInstructions().cookTime == 0)
    assert(microwave.currentInstructions().powerLevel == 0)



    val microwave1: Microwave = new Microwave()
    microwave1.popcornPressed()
    assert(microwave1.currentInstructions().cookTime == 140)
    assert(microwave1.currentInstructions().powerLevel == 100)
    microwave1.openDoor()
    assert(microwave1.currentInstructions().cookTime == 0)
    assert(microwave1.currentInstructions().powerLevel == 0)




    val microwave2: Microwave = new Microwave()
    microwave2.numberPressed(4)
    microwave2.numberPressed(5)
    microwave2.powerLevelPressed()
    microwave2.numberPressed(6)
    microwave2.numberPressed(8)
    microwave2.numberPressed(3)
    microwave2.startPressed()
    assert(microwave2.doorOpen() == false)
    assert(microwave2.currentInstructions().cookTime == 45)
    assert(microwave2.currentInstructions().powerLevel == 30)
    microwave2.openDoor()
    assert(microwave2.doorOpen() == true)
    assert(microwave2.currentInstructions().cookTime == 0)
    assert(microwave2.currentInstructions().powerLevel == 0)
    microwave2.closeDoor()
    microwave2.startPressed()
    assert(microwave2.currentInstructions().cookTime == 45)
    assert(microwave2.currentInstructions().powerLevel == 30)

    val microwave3: Microwave = new Microwave()
    microwave3.numberPressed(1)
    microwave3.openDoor()
    microwave3.popcornPressed()
    assert(microwave3.currentInstructions().cookTime == 0)
    assert(microwave3.currentInstructions().powerLevel == 0)
    microwave3.closeDoor()
    microwave3.startPressed()
    assert(microwave3.currentInstructions().cookTime == 140)
    assert(microwave3.currentInstructions().powerLevel == 100)


    val microwave4: Microwave = new Microwave
    assert(microwave.doorOpen()==false)
    microwave4.numberPressed(1)
    microwave.openDoor()
    assert(microwave.doorOpen()==true)
    microwave4.clearPressed()
    microwave4.closeDoor()
    assert(microwave4.doorOpen()==false)
    microwave4.numberPressed(2)
    microwave4.powerLevelPressed()
    microwave4.numberPressed(2)
    microwave4.startPressed()
    assert(microwave4.currentInstructions().cookTime == 2)
    assert(microwave4.currentInstructions().powerLevel == 20)

    val microwave5: Microwave = new Microwave
    microwave5.openDoor()
    microwave5.popcornPressed()
    microwave5.startPressed()
    assert(microwave5.currentInstructions().cookTime == 0)
    assert(microwave5.currentInstructions().powerLevel == 0)
    microwave5.closeDoor()
    microwave5.startPressed()
    assert(microwave5.currentInstructions().cookTime == 140)
    assert(microwave5.currentInstructions().powerLevel == 100)





    val microwave6: Microwave = new Microwave()

    microwave6.numberPressed(5)
    microwave6.numberPressed(5)
    microwave6.powerLevelPressed()
    microwave6.numberPressed(5)
    microwave6.startPressed()

    assert(microwave6.currentInstructions().cookTime == 55)
    assert(microwave6.currentInstructions().powerLevel == 50)

    val microwave7: Microwave = new Microwave()
    microwave7.numberPressed(5)
    microwave7.numberPressed(5)
    microwave7.powerLevelPressed()
    microwave7.numberPressed(2)
    microwave7.cookTimePressed()
    microwave7.numberPressed(2)
    microwave7.numberPressed(5)
    microwave7.startPressed()

    assert(microwave7.currentInstructions().cookTime == 25)
    assert(microwave7.currentInstructions().powerLevel == 20)

    val microwave8: Microwave = new Microwave()
    microwave8.numberPressed(4)
    microwave8.numberPressed(5)
    microwave8.powerLevelPressed()
    microwave8.numberPressed(6)
    microwave8.numberPressed(8)
    microwave8.numberPressed(3)
    microwave8.startPressed()
    assert(microwave8.currentInstructions().cookTime == 45)
    assert(microwave8.currentInstructions().powerLevel == 30)




    val microwave9: Microwave = new Microwave()

    microwave9.numberPressed(3)
    microwave9.numberPressed(0)

    assert(microwave9.currentInstructions().cookTime == 0)

    microwave9.startPressed()

    assert(microwave9.currentInstructions().cookTime == 30)

    val microwave10: Microwave = new Microwave()
    microwave10.thirtySecondsPressed()
    assert(microwave10.currentInstructions().cookTime == 30)

    val microwave11: Microwave = new Microwave()
    microwave11.thirtySecondsPressed()
    microwave11.startPressed()
    assert(microwave11.currentInstructions().cookTime == 30)
    microwave11.clearPressed()
    microwave11.numberPressed(1)
    microwave11.numberPressed(4)
    assert(microwave11.currentInstructions().cookTime == 0)
    microwave11.startPressed()
    assert(microwave11.currentInstructions().cookTime == 14)
    microwave11.thirtySecondsPressed()
    assert(microwave11.currentInstructions().cookTime == 44)


    val microwave12: Microwave = new Microwave()
    microwave12.numberPressed(1)
    microwave12.numberPressed(2)
    microwave12.startPressed()
    assert(microwave12.currentInstructions().cookTime == 12)
    microwave12.clearPressed()
    microwave12.numberPressed(4)
    microwave12.numberPressed(5)
    microwave12.startPressed()
    assert(microwave12.currentInstructions().cookTime == 45)
    microwave12.clearPressed()
    microwave12.numberPressed(6)
    microwave12.numberPressed(7)
    microwave12.startPressed()
    assert(microwave12.currentInstructions().cookTime == 67)
    microwave12.clearPressed()
    microwave12.numberPressed(8)
    microwave12.numberPressed(9)
    microwave12.startPressed()
    assert(microwave12.currentInstructions().cookTime == 89)


    val microwave13: Microwave = new Microwave()
    assert(microwave13.doorOpen() == false)
    microwave13.openDoor()
    assert(microwave13.currentInstructions().cookTime == 0)
    assert(microwave13.currentInstructions().powerLevel == 0)
    assert(microwave13.doorOpen() == true)
    microwave13.numberPressed(9)
    microwave13.numberPressed(9)
    microwave13.closeDoor()
    assert(microwave13.doorOpen() == false)
    assert(microwave13.currentInstructions().cookTime == 0)
    assert(microwave13.currentInstructions().powerLevel == 0)
    microwave13.clearPressed()
    assert(microwave13.currentInstructions().cookTime == 0)
    assert(microwave13.currentInstructions().powerLevel == 0)
    microwave13.popcornPressed()
    assert(microwave13.currentInstructions().cookTime == 140)
    assert(microwave13.currentInstructions().powerLevel == 100)
    microwave13.openDoor()
    assert(microwave13.doorOpen() == true)
    microwave13.clearPressed()
    microwave13.numberPressed(4)
    microwave13.numberPressed(3)
    assert(microwave13.currentInstructions().cookTime == 0)
    assert(microwave13.currentInstructions().powerLevel == 0)
    microwave13.powerLevelPressed()
    microwave13.numberPressed(4)
    microwave13.numberPressed(3)
    microwave13.numberPressed(5)
    microwave13.numberPressed(9)
    assert(microwave13.currentInstructions().cookTime == 0)
    assert(microwave13.currentInstructions().powerLevel == 0)
    microwave13.cookTimePressed()
    microwave13.numberPressed(1)
    microwave13.numberPressed(2)
    assert(microwave13.currentInstructions().cookTime == 0)
    assert(microwave13.currentInstructions().powerLevel == 0)
    microwave13.closeDoor()
    assert(microwave13.currentInstructions().cookTime == 0)
    assert(microwave13.currentInstructions().powerLevel == 0)
    microwave13.startPressed()
    assert(microwave13.currentInstructions().cookTime == 12)
    assert(microwave13.currentInstructions().powerLevel == 90)
    microwave13.openDoor()
    assert(microwave13.currentInstructions().cookTime == 0)
    assert(microwave13.currentInstructions().powerLevel == 0)
    microwave13.closeDoor()
    assert(microwave13.currentInstructions().cookTime == 0)
    assert(microwave13.currentInstructions().powerLevel == 0)
    microwave13.startPressed()
    assert(microwave13.currentInstructions().cookTime == 12)
    assert(microwave13.currentInstructions().powerLevel == 90)

    val microwave14: Microwave = new Microwave()
    microwave14.openDoor()
    microwave14.numberPressed(6)
    microwave14.numberPressed(7)
    microwave14.startPressed()
    assert(microwave14.currentInstructions().cookTime == 0)
    assert(microwave14.currentInstructions().powerLevel == 0)
    microwave14.closeDoor()
    microwave14.startPressed()
    assert(microwave14.currentInstructions().cookTime == 67)
    assert(microwave14.currentInstructions().powerLevel == 100)

    val microwave15: Microwave = new Microwave()
    microwave15.openDoor()
    microwave15.popcornPressed()
    microwave15.closeDoor()
    microwave15.startPressed()
    assert(microwave15.currentInstructions().cookTime == 140)
    assert(microwave15.currentInstructions().powerLevel == 100)


    val microwave16: Microwave = new Microwave()
    microwave16.numberPressed(6)
    microwave16.numberPressed(7)
    microwave16.openDoor()
    microwave16.powerLevelPressed()
    microwave16.numberPressed(6)
    microwave16.numberPressed(2)
    microwave16.startPressed()
    assert(microwave16.doorOpen() == true)
    assert(microwave16.currentInstructions().cookTime == 0)
    assert(microwave16.currentInstructions().powerLevel == 0)
    microwave16.popcornPressed()
    microwave16.closeDoor()
    microwave16.startPressed()
    assert(microwave16.currentInstructions().cookTime == 140)
    assert(microwave16.currentInstructions().powerLevel == 100)


    val microwave17: Microwave = new Microwave()
    microwave17.numberPressed(6)
    microwave17.numberPressed(7)
    microwave17.openDoor()
    microwave17.numberPressed(6)
    microwave17.numberPressed(7)
    microwave17.closeDoor()
    microwave17.startPressed()
    assert(microwave17.currentInstructions().cookTime == 6767)
    assert(microwave17.currentInstructions().powerLevel == 100)


    val microwave18: Microwave = new Microwave()
    microwave18.numberPressed(7)
    microwave18.powerLevelPressed()
    microwave18.numberPressed(7)
    assert(microwave18.currentInstructions().cookTime == 0)
    assert(microwave18.currentInstructions().powerLevel == 0)
    microwave18.startPressed()
    assert(microwave18.currentInstructions().cookTime == 7)
    assert(microwave18.currentInstructions().powerLevel == 70)
    microwave18.clearPressed()
    assert(microwave18.currentInstructions().cookTime == 0)
    assert(microwave18.currentInstructions().powerLevel == 0)
    microwave18.doorOpen()
    microwave18.closeDoor()
    microwave18.doorOpen()
    microwave18.popcornPressed()
    assert(microwave18.currentInstructions().cookTime == 140)
    assert(microwave18.currentInstructions().powerLevel == 100)
    microwave18.thirtySecondsPressed()
    microwave18.closeDoor()
    microwave18.openDoor()
    microwave18.powerLevelPressed()
    microwave18.numberPressed(4)
    assert(microwave18.doorOpen() == true)
    assert(microwave18.currentInstructions().cookTime == 0)
    assert(microwave18.currentInstructions().powerLevel == 0)
    microwave18.closeDoor()
    assert(microwave18.doorOpen() == false)
    assert(microwave18.currentInstructions().cookTime == 0)
    assert(microwave18.currentInstructions().powerLevel == 0)
    microwave18.cookTimePressed()
    microwave18.numberPressed(7)
    microwave18.numberPressed(7)
    microwave18.startPressed()
    assert(microwave18.currentInstructions().cookTime == 77)
    assert(microwave18.currentInstructions().powerLevel == 40)


    val microwave19: Microwave = new Microwave()
    microwave19.openDoor()
    microwave19.numberPressed(2)
    microwave19.powerLevelPressed()
    microwave19.numberPressed(4)
    assert(microwave19.doorOpen() == true)
    assert(microwave19.currentInstructions().cookTime == 0)
    assert(microwave19.currentInstructions().powerLevel == 0)
    microwave19.closeDoor()
    assert(microwave19.doorOpen() == false)
    assert(microwave19.currentInstructions().cookTime == 0)
    assert(microwave19.currentInstructions().powerLevel == 0)
    microwave19.numberPressed(8)
    microwave19.numberPressed(7)
    microwave19.startPressed()
    assert(microwave19.currentInstructions().cookTime == 2)
    assert(microwave19.currentInstructions().powerLevel == 70)

    val microwave20: Microwave = new Microwave()
    microwave20.thirtySecondsPressed()
    assert(microwave20.currentInstructions().cookTime == 30)
    assert(microwave20.currentInstructions().powerLevel == 100)
    microwave20.thirtySecondsPressed()
    assert(microwave20.currentInstructions().cookTime == 60)
    assert(microwave20.currentInstructions().powerLevel == 100)


    val microwave21: Microwave = new Microwave()
    microwave21.openDoor()
    microwave21.numberPressed(7)
    microwave21.thirtySecondsPressed()
    microwave21.closeDoor()
    microwave21.startPressed()
    assert(microwave21.currentInstructions().cookTime == 37)
    assert(microwave21.currentInstructions().powerLevel == 100)
    microwave21.thirtySecondsPressed()
    assert(microwave21.currentInstructions().cookTime == 67)
    assert(microwave21.currentInstructions().powerLevel == 100)





    val microwave24: Microwave = new Microwave()
    microwave24.openDoor()
    microwave24.thirtySecondsPressed()
    microwave24.closeDoor()
    microwave24.numberPressed(1)
    microwave24.startPressed()
    assert(microwave24.currentInstructions().cookTime == 301)
    assert(microwave24.currentInstructions().powerLevel == 100)

    
    val microwave22: Microwave = new Microwave()
    microwave22.thirtySecondsPressed()
    assert(microwave22.currentInstructions().cookTime == 30)
    assert(microwave22.currentInstructions().powerLevel == 100)
    microwave22.openDoor()
    microwave22.numberPressed(7)
    microwave22.closeDoor()
    microwave22.startPressed()
    assert(microwave22.currentInstructions().cookTime == 7)
    assert(microwave22.currentInstructions().powerLevel == 100)





    val microwave23: Microwave = new Microwave()
    microwave23.thirtySecondsPressed()
    assert(microwave23.currentInstructions().cookTime == 30)
    assert(microwave23.currentInstructions().powerLevel == 100)
    microwave23.openDoor()
    assert(microwave23.currentInstructions().cookTime == 0)
    assert(microwave23.currentInstructions().powerLevel == 0)
    microwave23.closeDoor()
    microwave23.startPressed()
    assert(microwave23.currentInstructions().cookTime == 30)
    assert(microwave23.currentInstructions().powerLevel == 100)



    val microwave25: Microwave = new Microwave()
    microwave25.thirtySecondsPressed()
    assert(microwave25.currentInstructions().cookTime == 30)
    assert(microwave25.currentInstructions().powerLevel == 100)
    microwave25.clearPressed()
    microwave25.numberPressed(7)
    microwave25.numberPressed(1)
    microwave25.startPressed()
    assert(microwave25.currentInstructions().cookTime == 71)
    assert(microwave25.currentInstructions().powerLevel == 100)
    microwave25.clearPressed()
    microwave25.numberPressed(7)
    microwave25.numberPressed(1)
    microwave25.popcornPressed()
    assert(microwave25.currentInstructions().cookTime == 140)
    assert(microwave25.currentInstructions().powerLevel == 100)
    microwave25.thirtySecondsPressed()
    assert(microwave25.currentInstructions().cookTime == 170)
    assert(microwave25.currentInstructions().powerLevel == 100)
    microwave25.openDoor()
    microwave25.closeDoor()
    microwave25.startPressed()
    assert(microwave25.currentInstructions().cookTime == 170)
    assert(microwave25.currentInstructions().powerLevel == 100)
    microwave25.openDoor()
    microwave25.closeDoor()
    microwave25.powerLevelPressed()
    microwave25.numberPressed(7)
    microwave25.numberPressed(1)
    microwave25.startPressed()
    assert(microwave25.currentInstructions().cookTime == 170)
    assert(microwave25.currentInstructions().powerLevel == 10)
    microwave25.openDoor()
    microwave25.closeDoor()
    microwave25.powerLevelPressed()
    microwave25.numberPressed(0)
    microwave25.startPressed()
    assert(microwave25.currentInstructions().cookTime == 170)
    assert(microwave25.currentInstructions().powerLevel == 0)
    microwave25.clearPressed()
    microwave25.popcornPressed()
    assert(microwave25.currentInstructions().cookTime == 140)
    assert(microwave25.currentInstructions().powerLevel == 100)
    microwave25.openDoor()
    microwave25.numberPressed(1)
    microwave25.numberPressed(2)
    microwave25.closeDoor()
    microwave25.popcornPressed()
    assert(microwave25.currentInstructions().cookTime == 140)
    assert(microwave25.currentInstructions().powerLevel == 100)
    microwave25.openDoor()
    microwave25.powerLevelPressed()
    microwave25.numberPressed(1)
    microwave25.numberPressed(2)
    microwave25.closeDoor()
    microwave25.popcornPressed()
    assert(microwave25.currentInstructions().cookTime == 140)
    assert(microwave25.currentInstructions().powerLevel == 100)
    microwave25.openDoor()
    microwave25.popcornPressed()
    microwave25.closeDoor()
    microwave25.startPressed()
    assert(microwave25.currentInstructions().cookTime == 140)
    assert(microwave25.currentInstructions().powerLevel == 100)
    microwave25.openDoor()
    microwave25.thirtySecondsPressed()
    microwave25.closeDoor()
    microwave25.popcornPressed()
    assert(microwave25.currentInstructions().cookTime == 140)
    assert(microwave25.currentInstructions().powerLevel == 100)
    microwave25.openDoor()
    microwave25.startPressed()
    assert(microwave25.currentInstructions().cookTime == 0)
    assert(microwave25.currentInstructions().powerLevel == 0)
    microwave25.clearPressed()
    microwave25.closeDoor()
    microwave25.numberPressed(1)
    microwave25.startPressed()
    assert(microwave25.currentInstructions().cookTime == 1)
    assert(microwave25.currentInstructions().powerLevel == 100)























































  }
}


