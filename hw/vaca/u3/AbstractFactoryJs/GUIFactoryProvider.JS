class GUIFactoryProvider {
    static getFactory() {
        // For demo purposes, we'll use a query parameter to switch between OS
        const urlParams = new URLSearchParams(window.location.search);
        const os = urlParams.get('os') || navigator.platform.toLowerCase();
        
        if (os.includes('win')) {
            return new WinFactory();
        } else if (os.includes('linux') || os.includes('nix')) {
            return new LinuxFactory();
        }
        
        // Default to Linux if OS not recognized
        return new LinuxFactory();
    }
}