# Minesweeper

A simple Java-based console Minesweeper game where players reveal cells while avoiding randomly generated mines.

The game allows users to configure the board size and number of mines before starting. Players must reveal all safe cells to win.

# Screenshots

## Cell Representation

A cell can have different states depending on its content.

### Mine cell

```text
Has cell     | Hidden cell   | Revealed cell
             |               | (n representing no. of mines nearby)
 +---+       |    +---+      |     +---+
 | * |       |    |   |      |     | n |
 +---+       |    +---+      |     +---+
```

## Features

- Custom board size configuration
- Custom mine count configuration
- Random mine placement
- Display surrounding mine counts
- Reveal cells using row and column coordinates
- Detect mine selection and trigger game over
- Win detection when all safe cells are revealed
- Input validation for invalid coordinates and non-number inputs
- Automatic cascading reveal for empty cells

## How to Run
