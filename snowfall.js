(function() {
    const snowflakeSymbol = "❄";  // Kar tanesi sembolü
    const rainSymbol = "💧";      // Yağmur damlası sembolü
    const snowflakes = [];        // Kar tanelerini depolayacak dizi
    const rainDrops = [];         // Yağmur damlalarını depolayacak dizi
    const canvas = document.getElementById('snowfallCanvas');
    const ctx = canvas.getContext('2d');

    // Canvas boyutlarını ekran boyutuna ayarla
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;

    let maosePosition = window.innerWidth / 2; // Maose'nin başlangıç konumu, ekranın ortasında

    // Kar ve yağmur oluşturma fonksiyonu
    function createSnowflake() {
        if (Math.random() > 0.5) {
            // Kar tanesi
            snowflakes.push({
                x: Math.random() * canvas.width,
                y: -10,
                speed: Math.random() * 0.5 + 0.5,
                size: Math.random() * 10 + 3,
                drift: Math.random() * 1 - 0.5,
            });
        } else {
            // Yağmur damlası
            rainDrops.push({
                x: Math.random() * canvas.width,
                y: -10,
                speed: Math.random() * 4 + 2,
                size: Math.random() * 3 + 2,
            });
        }
    }

    // Animasyon fonksiyonu
    function animateElements() {
        ctx.clearRect(0, 0, canvas.width, canvas.height);

        // Her kar tanesinin veya yağmur damlasının hareketini ve çizimini yap
        snowflakes.forEach((snowflake, index) => {
            snowflake.y += snowflake.speed;
            snowflake.x += snowflake.drift;

            if (snowflake.y > canvas.height) {
                snowflake.y = -snowflake.size;
                snowflake.x = Math.random() * canvas.width;
            }

            ctx.font = `${snowflake.size}px Arial`;
            ctx.fillStyle = 'white';
            ctx.fillText(snowflakeSymbol, snowflake.x, snowflake.y);
        });

        rainDrops.forEach((rainDrop, index) => {
            rainDrop.y += rainDrop.speed;

            if (rainDrop.y > canvas.height) {
                rainDrop.y = -rainDrop.size;
                rainDrop.x = Math.random() * canvas.width;
            }

            ctx.font = `${rainDrop.size}px Arial`;
            ctx.fillStyle = 'blue';
            ctx.fillText(rainSymbol, rainDrop.x, rainDrop.y);
        });

        requestAnimationFrame(animateElements);
    }

    // Sürekli olarak kar taneleri veya yağmur damlaları oluştur
    setInterval(createSnowflake, 100);  // Her 100ms'de bir yeni kar tanesi veya yağmur damlası ekle

    // Maose'nin ekran konumuna göre etkileşim
    function checkMaosePosition() {
        if (maosePosition < canvas.width / 2) {
            // Maose sol tarafa yakınsa, yağmur yağacak
            snowflakes.length = 0; // Kar tanelerini temizle
        } else {
            // Maose sağ tarafa yakınsa, kar yağacak
            rainDrops.length = 0; // Yağmur damlalarını temizle
        }
    }

    // Maose'nin konumunu izleyelim
    window.addEventListener('mousemove', (event) => {
        maosePosition = event.clientX; // Maose'nin mevcut x konumu
        checkMaosePosition(); // Durumu kontrol et
    });

    // Animasyonu başlat
    animateElements();
})();
