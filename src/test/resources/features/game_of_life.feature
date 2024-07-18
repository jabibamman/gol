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
      When the center (position [1,1]) cell is alive
      And all other cells are dead
      Then the graphical representation is
        |-|-|-|
        |-|X|-|
        |-|-|-|

  Rule: Cell dies from underpopulation
  Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.

    Scenario: Live cell with one live neighbour dies
      Given the following 3x3 grid
        | - | - | - |
        | - | X | X |
        | - | - | - |
      When I update the grid
      Then the grid should be
        | - | - | - |
        | - | - | X |
        | - | - | - |

  Rule: Dead cell becomes alive
  Any dead cell with exactly three live neighbours becomes a live cell.

    Scenario: Dead cell with three live neighbours becomes alive
      Given the following 3x3 grid
        | - | X | - |
        | X | - | X |
        | - | - | - |
      When I update the grid
      Then the grid should be
        | - | X | - |
        | X | X | X |
        | - | - | - |

  Rule: Cell dies from overcrowding
  Any live cell with more than three live neighbours dies, as if by overcrowding.

    Scenario: Live cell with four live neighbours dies
      Given the following 3x3 grid
        | - | X | - |
        | X | X | X |
        | - | X | - |
      When I update the grid
      Then the grid should be
        | - | X | - |
        | X | - | X |
        | - | X | - |

  Rule: Live cell stays alive
  Any live cell with two or three live neighbours lives on to the next generation

  Scenario: Live cell with two neighbours
    Given the following grid
      |-|-|-|
      |X|X|X|
      |-|-|-|
    When I update the grid
    Then the cell at position [1, 1] stays alive

  Scenario: Live cell with three neighbours
    Given the following grid
      |X|-|X|
      |-|X|-|
      |X|-|-|
    When I update the grid
    Then the cell at position [1, 1] stays alive
