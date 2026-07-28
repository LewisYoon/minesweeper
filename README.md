# Minesweeper

A simple Java-based console Minesweeper game where players reveal cells while avoiding randomly generated mines.

The game allows users to configure the board size and number of mines before starting. Players must reveal all safe cells to win.

## Cell Representation

A cell can have different states depending on its content.

### Mine cell

    +---+
    | * |
    +---+

### Hidden cell

    +---+
    |   |
    +---+

### Revealed cell

    +---+
    | n |
    +---+

`n` represents the number of nearby mines.

## Screenshots

### Setup (Board Size & Mine Count) and Initial Board

<img width="299" height="440" alt="Screenshot 2026-07-28 at 4 37 16 pm" src="https://github.com/user-attachments/assets/69711fff-614c-4ce2-af62-d6e75d7b9227" />

### After Input

<img width="295" height="372" alt="Screenshot 2026-07-28 at 4 37 40 pm" src="https://github.com/user-attachments/assets/95840865-3e4e-4496-97b8-d6bc3bbc21c8" />

### Game Over (Mine Revealed)

<img width="295" height="372" alt="Screenshot 2026-07-28 at 4 37 40 pm" src="https://github.com/user-attachments/assets/95840865-3e4e-4496-97b8-d6bc3bbc21c8" />

### Winning Game (All Safe Cells Revealed)

<img width="317" height="191" alt="Screenshot 2026-07-28 at 4 41 01 pm" src="https://github.com/user-attachments/assets/cbf7bde5-e2e8-4bbc-9e64-2bd1654d4c26" />

### Bonus 2 Cascade revealing (Reveals surrounding of empty cells)
<img width="253" height="601" alt="Screenshot 2026-07-28 at 5 30 09 pm" src="https://github.com/user-attachments/assets/df0f8936-423b-4bd1-9205-49128b4d88df" />

## Features

- Custom board size configuration
- Custom mine count configuration
- Random mine placement
- Reveal cells using row and column coordinates
- Display surrounding mine counts
- Detect mine selection and trigger game over
- Win detection when all safe cells are revealed
- Input validation for invalid coordinates and non-number inputs
- Automatic cascading reveal for empty cells using recursive DFS

## Project Structure

    src
    ├── App.java
    ├── Game.java
    ├── GameBoard.java
    ├── Cell.java
    └── Mine.java

## How to Run

### Compile the Java files

    javac -d bin src/*.java

### Run the app

    java -cp bin App
