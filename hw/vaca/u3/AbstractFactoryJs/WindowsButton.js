class WindowsButton extends Button {
    paint() {
        console.log("Rendering a button in Windows style");
        return "<button class='windows-btn'>Windows Button</button>";
    }
}