// js/app.js
document.addEventListener('DOMContentLoaded', () => {
    // Get the appropriate factory
    const factory = GUIFactoryProvider.getFactory();
    
    // Create UI components
    const button = factory.createButton();
    const menu = factory.createMenu();
    
    // Render components to the DOM
    document.getElementById('gui-container').innerHTML = `
        ${button.paint()}
        ${menu.paint()}
    `;
    
    // Display current OS
    const osInfo = document.createElement('p');
    osInfo.textContent = `Running on: ${navigator.platform}`;
    document.body.appendChild(osInfo);
    
    // Add some demo controls
    const switchOS = document.createElement('div');
    switchOS.innerHTML = `
        <p>Switch OS for demo:</p>
        <a href="?os=win">Windows Style</a> | 
        <a href="?os=linux">Linux Style</a> | 
        <a href=".">Detect Automatically</a>
    `;
    document.body.appendChild(switchOS);
});