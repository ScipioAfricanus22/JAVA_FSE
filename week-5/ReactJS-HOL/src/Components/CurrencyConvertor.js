import React, { useState } from 'react';

const CurrencyConvertor = () => {
  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('');

  // Handle the form submission event
  const handleSubmit = (e) => {
    e.preventDefault(); // Prevent standard HTML form refresh
    
    // Convert Euro to Rupees (Assuming standard conversion rate of 1 Euro = 80 Rupees for this example)
    if (currency.toLowerCase() === 'euro') {
      const convertedAmount = parseFloat(amount) * 80;
      alert(`Converting to Euro Amount is ${convertedAmount}`);
    } else {
      alert(`Conversion for ${currency} is not configured.`);
    }
  };

  return (
    <div style={{ marginTop: '20px' }}>
      <h2 style={{ color: 'green' }}>Currency Convertor!!!</h2>
      <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', width: '250px', gap: '10px' }}>
        <div style={{ display: 'flex', justifyContent: 'space-between' }}>
          <label>Amount:</label>
          <input 
            type="number" 
            value={amount} 
            onChange={(e) => setAmount(e.target.value)} 
          />
        </div>
        <div style={{ display: 'flex', justifyContent: 'space-between' }}>
          <label>Currency:</label>
          <input 
            type="text" 
            value={currency} 
            onChange={(e) => setCurrency(e.target.value)} 
            placeholder="e.g. Euro"
          />
        </div>
        <button type="submit" style={{ width: '80px', alignSelf: 'center', marginTop: '10px' }}>Submit</button>
      </form>
    </div>
  );
};

export default CurrencyConvertor;
