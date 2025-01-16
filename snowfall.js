(function() {
    var canvas = document.getElementById('snowfallCanvas');
    var ctx = canvas.getContext('2d');

    var snowflakes = [];
    var raindrops = [];

    // Canvas boyutlarını ayarla
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;

    // Kar tanelerini oluştur
    function createSnowflake() {
        var size = Math.random() * 5 + 3; // Kar tanesi boyutu, biraz daha büyük
        var x = Math.random() * canvas.width; // X pozisyonu
        var y = -size; // Y pozisyonu (başlangıçta üstten başlar)
        var speed = Math.random() * 0.5 + 0.2; // Kar tanelerinin düşme hızı, daha yavaş
        var drift = Math.random() * 1.5 - 0.75; // Yanal kayma, hafif
        var opacity = Math.random() * 0.4 + 0.4; // Kar tanesinin opaklığı
        var rotation = Math.random() * 2 * Math.PI; // Kar tanesinin dönmesi
        snowflakes.push({ x: x, y: y, size: size, speed: speed, drift: drift, opacity: opacity, rotation: rotation });
    }

    // Yağmur tanelerini oluştur
    function createRaindrop() {
        var size = Math.random() * 2 + 1; // Yağmur damlası boyutu
        var x = Math.random() * canvas.width; // X pozisyonu
        var y = -size; // Y pozisyonu (başlangıçta üstten başlar)
        var speed = Math.random() * 3 + 1; // Yağmur tanelerinin düşme hızı, karınkinden hızlı
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

            // Kar tanesini çizerken yuvarlak yapıyoruz ve hafifçe döndürmek için rotation kullanıyoruz
            ctx.beginPath();
            ctx.arc(snowflake.x, snowflake.y, snowflake.size, 0, Math.PI * 2);
            ctx.fillStyle = `rgba(255, 255, 255, ${snowflake.opacity})`; // Opaklık ile birlikte beyaz
            ctx.fill();

            // Hafif döndürme (daha gerçekçi bir hareket için)
            ctx.save();
            ctx.translate(snowflake.x, snowflake.y);
            ctx.rotate(snowflake.rotation);
            ctx.translate(-snowflake.x, -snowflake.y);
            ctx.restore();
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
