Feature: Game of Life

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
