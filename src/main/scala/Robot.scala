object MyObject {

  /**
    * This Robot class contains several attributes which represent
    * the position of the robot, the map size, and which direction is facing.
    *
    * @param x        Represents the current X Position of the Robot in the map.
    * @param y        Represents the current Y Position of the Robot in the map.
    * @param facing   Represents the current facing direction of the Robot.
    * @param mapSizeX Represents the number of horizontal possible values.
    * @param mapSizeY Represents the number of vertical possible values.
    */
  class Robot(val x: Int, val y: Int, val facing: String, val mapSizeX: Int, val mapSizeY: Int) {
  }


  /**
    * This function creates a new Robot with a new facing direction rotated
    * to the left.
    *
    * @param robot Represents the robot object to be rotated.
    * @return Returns a new robot with a facing direction rotated to the left.
    */
  def rotateLeft(robot: Robot): Robot = {
    if (robot.facing.equals("N")) {
      new Robot(robot.x, robot.y, "W", robot.mapSizeX, robot.mapSizeY)
    } else if (robot.facing.equals("E")) {
      new Robot(robot.x, robot.y, "N", robot.mapSizeX, robot.mapSizeY)
    } else if (robot.facing.equals("S")) {
      new Robot(robot.x, robot.y, "E", robot.mapSizeX, robot.mapSizeY)
    } else {
      new Robot(robot.x, robot.y, "S", robot.mapSizeX, robot.mapSizeY)
    }
  }

  /**
    * This function creates a new Robot with a new facing direction rotated
    * to the Right.
    *
    * @param robot The robot object to be rotated.
    * @return A new robot with a facing direction rotated to the right.
    */
  def rotateRight(robot: Robot): Robot = {
    if (robot.facing.equals("N")) {
      new Robot(robot.x, robot.y, "E", robot.mapSizeX, robot.mapSizeY)
    } else if (robot.facing.equals("E")) {
      new Robot(robot.x, robot.y, "S", robot.mapSizeX, robot.mapSizeY)
    } else if (robot.facing.equals("S")) {
      new Robot(robot.x, robot.y, "W", robot.mapSizeX, robot.mapSizeY)
    } else {
      new Robot(robot.x, robot.y, "N", robot.mapSizeX, robot.mapSizeY)
    }
  }

  /**
    * This function creates a new Robot with a new X or Y position, and
    * it represents the movement of the Robot within the map.
    *
    * @param robot The robot object to be moved.
    * @return A new robot with a new X Y position.
    */
  def moveRobot(robot: Robot): Option[Robot] = {
    if (robot.facing.equals("N")) {
      Some(new Robot(robot.x, robot.y + 1, robot.facing, robot.mapSizeX, robot.mapSizeY))
    } else if (robot.facing.equals("S")) {
      Some(new Robot(robot.x, robot.y - 1, robot.facing, robot.mapSizeX, robot.mapSizeY))
    } else if (robot.facing.equals("E")) {
      Some(new Robot(robot.x + 1, robot.y, robot.facing, robot.mapSizeX, robot.mapSizeY))
    } else if (robot.facing.equals("W")) {
      Some(new Robot(robot.x - 1, robot.y, robot.facing, robot.mapSizeX, robot.mapSizeY))
    } else {
      None
    }
  }

  /**
    * This function returns the X Y position of a robot and its current facing direction.
    *
    * @return The X and Y position of a robot and its facing direction.
    */
  def getRobot(robot: Robot): String = {
    robot.x + " " + robot.y + " " + robot.facing
  }

  /**
    * This function reads the line of instructions given to a robot and rotates
    * or moves the robot depending on the instruction given.
    *
    * @param robot              The robot to be rotated or moved.
    * @param listOfInstructions The list of instructions given to a robot (L, R or M).
    * @return a new robot with a new list containing the remaining instructions to be performed.
    */
  def readInstruction(robot: Robot, listOfInstructions: List[Char]): Option[Robot] = {
    if (listOfInstructions.isEmpty) {
      return Some(robot)
    }
    val nextInstruction :: newList = listOfInstructions

    if (nextInstruction.equals('L')) {
      val r = rotateLeft(robot)
      return readInstruction(r, newList)

    } else if (nextInstruction.equals('R')) {
      val r = rotateRight(robot)
      return readInstruction(r, newList)

    } else if (nextInstruction.equals('M')) {
      val r = moveRobot(robot)
      val r1 = r match {
        case Some(r) => r
        case None => throw new Error("error!!!")
      }

      return readInstruction(r1, newList)
    } else {
      None
    }
  }

  /**
    * The main function reads the input from command line,
    * and prints out the final position of the robot.
    */
  def main(args: Array[String]): Unit = {
    val scanner = new java.util.Scanner(System.in)
    val mapX = scanner.nextInt()
    val mapY = scanner.nextInt()

    while (scanner.hasNextLine()) {
      val initialXPosition = scanner.nextInt()
      val initialYPosition = scanner.nextInt()
      val initialDirection = scanner.next()
      scanner.nextLine()
      val instructions = scanner.nextLine().toList

      val myRobot = readInstruction(new Robot(initialXPosition, initialYPosition, initialDirection, mapX, mapY), instructions)
      val output = myRobot match {
        case Some(myRobot) => getRobot(myRobot)
        case None => "invalid robot"
      }
      println(output)
    }
  }
}
