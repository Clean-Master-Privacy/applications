(function() {
    var canvas = document.getElementById('snowfallCanvas');
    var ctx = canvas.getContext('2d');

    var snowflakes = [];

    // Canvas boyutlarını ayarla
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;

    // Kar tanelerini oluştur
    function createSnowflake() {
        var size = Math.random() * 5 + 3; // Kar tanesi boyutu, daha büyük
        var x = Math.random() * canvas.width; // X pozisyonu
        var y = -size; // Y pozisyonu (başlangıçta üstten başlar)
        var speed = Math.random() * 0.5 + 0.2; // Kar tanelerinin düşme hızı, daha yavaş
        var drift = Math.random() * 1.5 - 0.75; // Yanal kayma, hafif
        var opacity = Math.random() * 0.3 + 0.4; // Opaklık değeri
        var wind = Math.random() * 0.05 - 0.025; // Rüzgar etkisi, hafif dalgalanma
        var rotation = Math.random() * 2 * Math.PI; // Kar tanesinin dönmesi
        snowflakes.push({ x: x, y: y, size: size, speed: speed, drift: drift, opacity: opacity, wind: wind, rotation: rotation });
    }

    // Kar tanelerini güncelle ve çiz
    function updateSnowflakes() {
        ctx.clearRect(0, 0, canvas.width, canvas.height); // Eskisini temizle

        for (var i = 0; i < snowflakes.length; i++) {
            var snowflake = snowflakes[i];
            snowflake.y += snowflake.speed; // Y pozisyonunu güncelle
            snowflake.x += snowflake.drift + snowflake.wind; // Yanal kayma ve rüzgar
            snowflake.rotation += 0.005; // Yavaşça dönme efekti

            // Kar tanelerinin kenarlara gitmesini engelle
            if (snowflake.x > canvas.width) snowflake.x = 0;
            if (snowflake.x < 0) snowflake.x = canvas.width;

            // Kar tanesi ekrandan dışarı çıkarsa, yukarıya taşı
            if (snowflake.y > canvas.height) {
                snowflake.y = -snowflake.size;
                snowflake.x = Math.random() * canvas.width;
                snowflake.drift = Math.random() * 1.5 - 0.75; // Yeni bir yanal kayma hızını ayarla
                snowflake.wind = Math.random() * 0.05 - 0.025; // Yeni bir rüzgar hızı
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

        requestAnimationFrame(updateSnowflakes);
    }

    // Başlangıç
    setInterval(createSnowflake, 200); // Kar tanelerini daha az aralıklarla oluştur
    updateSnowflakes(); // Kar tanelerini güncelle ve çiz
})();
