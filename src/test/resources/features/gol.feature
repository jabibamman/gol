Feature: Game of Life

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
