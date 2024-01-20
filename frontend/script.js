async function generateQRCode() {
    const text = document.getElementById('qrCodeText').value;
    const width = document.getElementById('qrCodeWidth').value;
    const height = document.getElementById('qrCodeHeight').value;

    const response = await fetch('http://localhost:8080/generateqr', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ text, width, height }),
    });

    if (response.ok) {
        const blob = await response.blob();

        const qrCodeImage = document.getElementById('qrCodeImage');
        qrCodeImage.innerHTML = ''; // Clear previous image
        const img = document.createElement('img');
        img.src = URL.createObjectURL(blob);
        img.alt = "QR Code";
        qrCodeImage.appendChild(img);
    } else {
        console.error('Failed to generate QR code:', response.status, response.statusText);
    }
} 