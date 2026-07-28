# Minesweeper

A simple Java-based console Minesweeper game where players reveal cells while avoiding randomly generated mines.

The game allows users to configure the board size and number of mines before starting. Players must reveal all safe cells to win.

# Screenshots
## Setup (size of board & no. mine) && displaying board

<img width="299" height="440" alt="Screenshot 2026-07-28 at 4 37 16 pm" src="https://github.com/user-attachments/assets/69711fff-614c-4ce2-af62-d6e75d7b9227" />

## After input 

<img width="295" height="372" alt="Screenshot 2026-07-28 at 4 37 40 pm" src="https://github.com/user-attachments/assets/95840865-3e4e-4496-97b8-d6bc3bbc21c8" />

## Lose game (reveals cell with mine)

<img width="326" height="188" alt="Screenshot 2026-07-28 at 4 40 29 pm" src="https://github.com/user-attachments/assets/b160f3a6-e1f3-45ec-b01c-95fd0f62e4f3" />

## Win game (reveals all cells without mines)

<img width="317" height="191" alt="Screenshot 2026-07-28 at 4 41 01 pm" src="https://github.com/user-attachments/assets/cbf7bde5-e2e8-4bbc-9e64-2bd1654d4c26" />


## Cell Representation

A cell can have different states depending on its content.

### Mine cell

```text
Has mine     | Hidden cell   | Revealed cell (n representing no. of mines nearby)
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
