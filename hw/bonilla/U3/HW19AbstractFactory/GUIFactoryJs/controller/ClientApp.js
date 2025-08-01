const GUIFactory = require('./GUIFactory');

function main() {
  const aFactory = GUIFactory.getFactory();
  const aButton = aFactory.createButton();
  aButton.caption = "Play";
  aButton.paint();
}

main();
