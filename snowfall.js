(function() {
    var canvas = document.getElementById('snowfallCanvas');
    var ctx = canvas.getContext('2d');

    var snowflakes = [];
    var raindrops = [];

    // Canvas boyutlarını ayarla
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;

    // Altıgen kar taneleri oluşturma fonksiyonu
    function drawSnowflake(x, y, size) {
        ctx.beginPath();
        for (let i = 0; i < 6; i++) {
            let angle = Math.PI / 3 * i;
            let x1 = x + size * Math.cos(angle);
            let y1 = y + size * Math.sin(angle);
            let x2 = x + size / 2 * Math.cos(angle + Math.PI / 6);
            let y2 = y + size / 2 * Math.sin(angle + Math.PI / 6);
            ctx.moveTo(x, y);
            ctx.lineTo(x1, y1);
            ctx.moveTo(x1, y1);
            ctx.lineTo(x2, y2);
        }
        ctx.strokeStyle = `rgba(255, 255, 255, 0.8)`; // Beyaz renk
        ctx.lineWidth = 1;
        ctx.stroke();
        ctx.closePath();
    }

    // Kar tanelerini oluştur
    function createSnowflake() {
        var size = Math.random() * 5 + 5; // Kar tanesi boyutu, daha büyük
        var x = Math.random() * canvas.width; // X pozisyonu
        var y = -size; // Y pozisyonu (başlangıçta üstten başlar)
        var speed = Math.random() * 0.5 + 0.2; // Kar tanelerinin düşme hızı
        var drift = Math.random() * 1.5 - 0.75; // Yanal kayma
        var opacity = Math.random() * 0.4 + 0.4; // Kar tanesinin opaklığı
        var rotation = Math.random() * 2 * Math.PI; // Kar tanesinin dönmesi
        snowflakes.push({ x: x, y: y, size: size, speed: speed, drift: drift, opacity: opacity, rotation: rotation });
    }

    // Yağmur tanelerini oluştur
    function createRaindrop() {
        var size = Math.random() * 2 + 1; // Yağmur damlası boyutu
        var x = Math.random() * canvas.width; // X pozisyonu
        var y = -size; // Y pozisyonu (başlangıçta üstten başlar)
        var speed = Math.random() * 3 + 1; // Yağmur tanelerinin düşme hızı
        var opacity = Math.random() * 0.3 + 0.2; // Yağmur damlası opaklık
        raindrops.push({ x: x, y: y, size: size, speed: speed, opacity: opacity });
    }

    // Kar ve yağmur tanelerini güncelle ve çiz
    function updateParticles() {
        ctx.clearRect(0, 0, canvas.width, canvas.height); // Eskisini temizle

        // Kar tanelerini çiz
        for (var i = 0; i < snowflakes.length; i++) {
            var snowflake = snowflakes[i];
            snowflake.y += snowflake.speed; // Y pozisyonunu güncelle
            snowflake.x += snowflake.drift; // Yanal kaymayı ekle
            snowflake.rotation += 0.005; // Yavaşça dönme efekti

            // Kar tanelerinin kenarlara gitmesini engelle
            if (snowflake.x > canvas.width) snowflake.x = 0;
            if (snowflake.x < 0) snowflake.x = canvas.width;

            // Kar tanesi ekrandan dışarı çıkarsa, yukarıya taşı
            if (snowflake.y > canvas.height) {
                snowflake.y = -snowflake.size;
                snowflake.x = Math.random() * canvas.width;
                snowflake.drift = Math.random() * 1.5 - 0.75; // Yeni bir yanal kayma hızını ayarla
            }

            // Gerçekçi bir kar tanesi çizimi için altıgen şekli kullan
            drawSnowflake(snowflake.x, snowflake.y, snowflake.size);
        }

        // Yağmur tanelerini çiz
        for (var j = 0; j < raindrops.length; j++) {
            var raindrop = raindrops[j];
            raindrop.y += raindrop.speed; // Yağmur damlasının hızını güncelle
            raindrop.opacity = Math.random() * 0.2 + 0.2; // Yağmur damlasının opaklık değeri

            // Yağmur damlası ekrandan dışarı çıkarsa, yukarıya taşı
            if (raindrop.y > canvas.height) {
                raindrop.y = -raindrop.size;
                raindrop.x = Math.random() * canvas.width;
            }

            // Yağmur damlasını çizerken ince bir çizgi şeklinde
            ctx.beginPath();
            ctx.arc(raindrop.x, raindrop.y, raindrop.size, 0, Math.PI * 2);
            ctx.fillStyle = `rgba(173, 216, 230, ${raindrop.opacity})`; // Hafif mavi opaklık
            ctx.fill();
        }

        // Yavaşça yeni kar ve yağmur taneleri ekle
        if (Math.random() < 0.02) createRaindrop(); // Yağmur nadiren eklenir
        if (Math.random() < 0.1) createSnowflake(); // Kar taneleri daha sık eklenir

        requestAnimationFrame(updateParticles);
    }

    // Başlangıç
    updateParticles(); // Kar ve yağmur tanelerini güncelle ve çiz
})();
