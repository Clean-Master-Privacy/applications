// Snowfall Effect: Kar yağma efektini başlatacak kod
(function() {
    var canvas = document.getElementById('snowfallCanvas');
    var ctx = canvas.getContext('2d');

    var snowflakes = [];

    // Canvas boyutlarını ayarla
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;

    // Kar tanelerini oluştur
    function createSnowflake() {
        var size = Math.random() * 5 + 2; // Kar tanesi boyutu
        var x = Math.random() * canvas.width; // X pozisyonu
        var y = -size; // Y pozisyonu (başlangıçta üstten başlar)
        var speed = Math.random() * 3 + 1; // Kar tanelerinin düşme hızı
        snowflakes.push({ x: x, y: y, size: size, speed: speed });
    }

    // Kar tanelerini güncelle ve çiz
    function updateSnowflakes() {
        ctx.clearRect(0, 0, canvas.width, canvas.height); // Eskisini temizle
        for (var i = 0; i < snowflakes.length; i++) {
            var snowflake = snowflakes[i];
            snowflake.y += snowflake.speed; // Y pozisyonunu güncelle

            // Kar tanesi ekrandan dışarı çıkarsa, yukarıya taşı
            if (snowflake.y > canvas.height) {
                snowflake.y = -snowflake.size;
                snowflake.x = Math.random() * canvas.width;
            }

            // Kar tanesini çiz
            ctx.beginPath();
            ctx.arc(snowflake.x, snowflake.y, snowflake.size, 0, Math.PI * 2);
            ctx.fillStyle = 'white';
            ctx.fill();
        }

        requestAnimationFrame(updateSnowflakes);
    }

    // Başlangıç
    setInterval(createSnowflake, 100); // Kar tanelerini aralıklarla oluştur
    updateSnowflakes(); // Kar tanelerini güncelle ve çiz
})();
