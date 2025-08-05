const WinFactory = require('../controller/WinFactory');
const LinuxFactory = require('../controller/LinuxFactory');
const GUIFactory = require('../controller/GUIFactory');

console.log("=== WINDOWS ===");
const winFactory = new WinFactory();
const winButton = winFactory.createButton();
winButton.caption = "Play";
winButton.paint();

const winMenu = winFactory.createMenu();
winMenu.paint();

console.log("\n=== LINUX ===");
const linuxFactory = new LinuxFactory();
const linuxButton = linuxFactory.createButton();
linuxButton.caption = "Play";
linuxButton.paint();

const linuxMenu = linuxFactory.createMenu();
linuxMenu.paint();

