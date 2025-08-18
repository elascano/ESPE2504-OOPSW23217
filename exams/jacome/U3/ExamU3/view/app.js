document.getElementById('sortBtn').addEventListener('click', async () => {
  const input = document.getElementById('inputArray').value;
  const numbers = input.split(',').map(n => parseInt(n.trim(), 10)).filter(n => !isNaN(n));

  if (numbers.length <= 1) {
    alert('Please enter more than one number.');
    return;
  }

  const response = await fetch('/api/sort', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ array: numbers })
  });

  const result = await response.json();

  alert(
    `Unsorted: ${result.unsorted}\n` +
    `Size: ${result.size}\n` +
    `Algorithm: ${result.algorithm}\n` +
    `Sorted: ${result.sorted}`
  );
});
