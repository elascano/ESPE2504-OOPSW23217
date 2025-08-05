
import { Maze } from "./Maze.js";
import { MazeGenerator } from "./MazeGenerator.js";
import { printMaze } from "./MazePrinter.js";

const rows = 6;
const cols = 6;
const maze = new Maze(rows, cols);
const generator = new MazeGenerator(maze);

generator.generate();
printMaze(maze);
