document.getElementById('contactForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Formun varsayılan gönderim işlemini engelle

    // Geri bildirim mesajını göster
    const messageDiv = document.getElementById('formMessage');
    messageDiv.style.display = 'block';
    messageDiv.innerHTML = 'Thank you for your message! We will get back to you shortly.';
    
    // Formu sıfırla
    this.reset();

    // Mesajı birkaç saniye sonra gizle
    setTimeout(() => {
        messageDiv.style.display = 'none';
    }, 5000);
});
