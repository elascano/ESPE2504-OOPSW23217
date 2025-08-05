import { MazeController } from './controller/MazeController.js';

const rows = 6;
const cols = 6;
const controller = new MazeController(rows, cols);
controller.run();