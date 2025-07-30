import { DFSMazeGenerator } from "./DFSMazeGenerator.js";
import { MazeRendererASCII } from "./MazeRendererASCII.js";

const width = 5;
const height = 5;

const generator = new DFSMazeGenerator();
const renderer = new MazeRendererASCII();

const maze = generator.generate(width, height);
renderer.render(maze);
