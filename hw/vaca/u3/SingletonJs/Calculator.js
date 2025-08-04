document.addEventListener('DOMContentLoaded', () => {
    // Get the USTax singleton instance
    const taxCalculator = USTax.getInstance();
    
    // DOM elements
    const amountInput = document.getElementById('amount');
    const taxPercentageInput = document.getElementById('tax-percentage');
    const calculateBtn = document.getElementById('calculate');
    const resultDiv = document.getElementById('result');
    const currentTaxSpan = document.getElementById('current-tax');
    
    // Display current tax percentage
    currentTaxSpan.textContent = taxCalculator.getTaxPercentage();
    
    // Set up event listeners
    taxPercentageInput.addEventListener('change', (e) => {
        const newPercentage = parseFloat(e.target.value);
        if (!isNaN(newPercentage)) {
            taxCalculator.setTaxPercentage(newPercentage);
            currentTaxSpan.textContent = newPercentage;
        }
    });
    
    calculateBtn.addEventListener('click', () => {
        const amount = parseFloat(amountInput.value);
        if (!isNaN(amount)) {
            const total = taxCalculator.salesTotal(amount);
            resultDiv.innerHTML = `
                <p>Sale Amount: $${amount.toFixed(2)}</p>
                <p>Tax Rate: ${taxCalculator.getTaxPercentage()}%</p>
                <p>Total with Tax: $${total.toFixed(2)}</p>
            `;
        } else {
            resultDiv.textContent = 'Please enter a valid amount';
        }
    });
});