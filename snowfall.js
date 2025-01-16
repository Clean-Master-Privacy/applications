(function() {
    var canvas = document.getElementById('snowfallCanvas');
    var ctx = canvas.getContext('2d');

    var snowflakes = [];

    // Canvas boyutlarını ayarla
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;

    // Kar tanelerini oluştur
    function createSnowflake() {
        var size = Math.random() * 3 + 2; // Kar tanesi boyutu
        var x = Math.random() * canvas.width; // X pozisyonu
        var y = -size; // Y pozisyonu (başlangıçta üstten başlar)
        var speed = Math.random() * 1 + 0.5; // Kar tanelerinin düşme hızı
        var drift = Math.random() * 2 - 1; // Yanal kayma
        var opacity = Math.random() * 0.3 + 0.4; // Kar tanesinin opaklık değeri
        snowflakes.push({ x: x, y: y, size: size, speed: speed, drift: drift, opacity: opacity });
    }

    // Kar tanelerini güncelle ve çiz
    function updateSnowflakes() {
        ctx.clearRect(0, 0, canvas.width, canvas.height); // Eskisini temizle

        for (var i = 0; i < snowflakes.length; i++) {
            var snowflake = snowflakes[i];
            snowflake.y += snowflake.speed; // Y pozisyonunu güncelle
            snowflake.x += snowflake.drift; // Yanal kaymayı ekle

            // Kar tanelerinin kenarlara gitmesini engelle
            if (snowflake.x > canvas.width) snowflake.x = 0;
            if (snowflake.x < 0) snowflake.x = canvas.width;

            // Kar tanesi ekrandan dışarı çıkarsa, yukarıya taşı
            if (snowflake.y > canvas.height) {
                snowflake.y = -snowflake.size;
                snowflake.x = Math.random() * canvas.width;
                snowflake.drift = Math.random() * 2 - 1; // Yeni bir yanal kayma hızını ayarla
            }

            // Kar tanesini çiz
            ctx.beginPath();
            ctx.arc(snowflake.x, snowflake.y, snowflake.size, 0, Math.PI * 2);
            ctx.fillStyle = `rgba(255, 255, 255, ${snowflake.opacity})`; // Opaklık ile birlikte beyaz
            ctx.fill();
        }

        requestAnimationFrame(updateSnowflakes);
    }

    // Başlangıç
    setInterval(createSnowflake, 100); // Kar tanelerini aralıklarla oluştur
    updateSnowflakes(); // Kar tanelerini güncelle ve çiz
})();
