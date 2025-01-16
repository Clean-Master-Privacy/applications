(function() {
    const snowflakeSymbol = "❄";  // Kar tanesi sembolü
    const snowflakes = [];  // Kar tanelerini depolayacak dizi

    const canvas = document.getElementById('snowfallCanvas');
    const ctx = canvas.getContext('2d');

    // Canvas boyutlarını ekran boyutuna ayarla
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;

    // Kar tanelerini oluşturma ve animasyon fonksiyonu
    function createSnowflake() {
        const snowflake = {
            x: Math.random() * canvas.width,
            y: -10,  // Başlangıç noktası ekranın dışında
            speed: Math.random() * 2 + 1,  // Hız
            size: Math.random() * 20 + 10,  // Boyut
            drift: Math.random() * 2 - 1,  // Yanal hareket
        };
        snowflakes.push(snowflake);
    }

    // Kar tanelerinin hareketini çizme fonksiyonu
    function animateSnowflakes() {
        ctx.clearRect(0, 0, canvas.width, canvas.height);

        // Her kar tanesinin hareketini ve çizimini yap
        for (let i = 0; i < snowflakes.length; i++) {
            const snowflake = snowflakes[i];

            // Kar tanesinin y hareketi
            snowflake.y += snowflake.speed;
            snowflake.x += snowflake.drift;

            // Kar tanesi ekranın altına düşerse, üstten yeniden başlat
            if (snowflake.y > canvas.height) {
                snowflake.y = -snowflake.size;
                snowflake.x = Math.random() * canvas.width;
            }

            // Kar tanelerini sembol olarak çiz
            ctx.font = `${snowflake.size}px Arial`;
            ctx.fillStyle = 'white';
            ctx.fillText(snowflakeSymbol, snowflake.x, snowflake.y);
        }

        requestAnimationFrame(animateSnowflakes);
    }

    // Sürekli olarak kar tanesi oluştur
    setInterval(createSnowflake, 100);  // Her 100ms'de bir yeni kar tanesi ekle

    // Animasyonu başlat
    animateSnowflakes();
})();
