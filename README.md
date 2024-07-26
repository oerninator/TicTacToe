
# TicTacToe

This is a simple TicTacToe game developed using the Model-View-Controller (MVC) pattern in Java.

## Features

- Playable TicTacToe game with a graphical user interface.
- Implements the MVC design pattern to separate concerns.
- Two-player game with alternating turns.

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/tictactoe.git
    ```
2. Navigate to the project directory:
    ```bash
    cd tictactoe
    ```
3. Compile the Java files:
    ```bash
    javac mvc/*.java
    ```

## Usage

1. Run the TicTacToe game:
    ```bash
    java mvc.Main
    ```

## Project Structure

```
tictactoe/
└── TicTacToeGradle/
    └── src/
        └── main/
            └── java/
                └── mvc/
                    ├── Controller.java
                    ├── FieldType.java
                    ├── Main.java
                    ├── Model.java
                    ├── Player.java
                    ├── Result.java
                    ├── View.java
                    └── ViewInterface.java
```

- **`Controller.java`**: Contains the `Controller` class which handles the game logic and user interactions.
- **`FieldType.java`**: Enum representing the state of each field in the TicTacToe grid (EMPTY, CIRCLE, CROSS).
- **`Main.java`**: Contains the `Main` class which starts the application.
- **`Model.java`**: Contains the `Model` class which maintains the game state.
- **`Player.java`**: Enum representing the players (CIRCLE, CROSS).
- **`Result.java`**: Enum representing the result of the game (DRAW, CIRCLE, CROSS).
- **`View.java`**: Contains the `View` class which handles the graphical user interface.
- **`ViewInterface.java`**: Interface for the view to ensure update method is implemented.

## Classes and Methods

### Controller.java

- **start()**: Initializes the game and starts the main game loop.

### FieldType.java

- **EMPTY**: Represents an empty field.
- **CIRCLE**: Represents a field occupied by a circle.
- **CROSS**: Represents a field occupied by a cross.

### Main.java

- **main(String[] args)**: Entry point of the application. Initializes the model, view, and controller, and starts the game.

### Model.java

- **registerView(ViewInterface view)**: Registers a view to be updated.
- **update()**: Updates all registered views.
- **getField()**: Returns the current state of the game board.
- **setField(FieldType[][] field)**: Sets the state of the game board.
- **getCurrentPlayer()**: Returns the current player.
- **switchPlayer()**: Switches to the next player.
- **getRound()**: Returns the current round number.

### Player.java

- **CIRCLE**: Represents the circle player.
- **CROSS**: Represents the cross player.

### Result.java

- **DRAW**: Represents a draw result.
- **CIRCLE**: Represents a win for the circle player.
- **CROSS**: Represents a win for the cross player.

### View.java

- **update()**: Updates the view based on the model state.
- **gameOver()**: Checks if the game is over and prints the result.

### ViewInterface.java

- **update()**: Method to be implemented by the view to update its state.

## Contribution

Feel free to contribute to this project by creating pull requests or reporting issues. Your feedback and contributions are highly appreciated.

## License

This project is licensed under the Apache License. See the [LICENSE](LICENSE) file for details.

## Contact

For any questions or suggestions, please contact me at arneseufert@web.de.

---

Thank you for playing TicTacToe!
