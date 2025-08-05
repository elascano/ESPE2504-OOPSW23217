class LinuxMenu extends Menu {
    paint() {
        console.log("Rendering a menu in Linux style");
        return "<ul class='linux-menu'><li>Linux Menu Item</li></ul>";
    }
}