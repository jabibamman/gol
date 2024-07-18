Feature: Game of Life

  Background:
    Given a 3x3 grid of dead cells
    And a coordinate positions system represented by the syntax [x, y]
    And the top left cell is at position [0,0]
    And the bottom left cell is at position [2, 0]
    And a live cell is graphically represented by the ascii character 'X'
    And a dead cell is graphically represented by the ascii character '-'
    And borders are graphically represented by the ascii character '|'

    Example: A live cell in the center
      Given a 3x3 grid of cells
      When the center cell is alive
      And all other cells are dead
      Then the graphical representation is
        |-|-|-|
        |-|X|-|
        |-|-|-|

  Rule: Cell dies from underpopulation
  Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.

    Scenario: Cell with one live neighbour dies
      Given a 3x3 grid
      And a live cell at [1, 1]
      And a live cell at [1, 2]
      When I update the grid
      Then the cell at [1, 1] should be dead
      And the cell at [1, 2] should be alive

  Rule: Dead cell becomes alive
  Any dead cell with exactly three live neighbours becomes a live cell.

    Scenario: Dead cell with three live neighbours becomes alive
      Given a 3x3 grid
      And a live cell at [0, 1]
      And a live cell at [1, 0]
      And a live cell at [1, 2]
      And a dead cell at [1, 1]
      When I update the grid
      Then the cell at [1, 1] should be alive

  Rule: Cell dies from overcrowding
  Any live cell with more than three live neighbours dies, as if by overcrowding.

    Scenario: Cell with four live neighbours dies
      Given a 3x3 grid
      And a live cell at [1, 1]
      And a live cell at [0, 1]
      And a live cell at [0, 2]
      And a live cell at [1, 0]
      And a live cell at [1, 2]
      When I update the grid
      Then the cell at [1, 1] should be dead

  Rule: Live cell stays alive
  Any live cell with two or three live neighbours lives on to the next generation

  Scenario: Live cell with two neighbours
    Given a live cell at position [1, 0]
    And a live cell at position [1, 1]
    And a live cell at position [1, 2]
    When I update the grid
    Then the cell at position [1, 1] stays alive

  Scenario: Live cell with three neighbours
    Given a live cell at position [0, 0]
    And a live cell at position [0, 2]
    And a live cell at position [2, 0]
    And a live cell at position [1, 1]
    When I update the grid
    Then the cell at position [1, 1] stays alive
