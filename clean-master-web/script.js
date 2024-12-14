// Konum Bilgisi Alma
document.getElementById('getLocation').addEventListener('click', function () {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition, showError);
    } else {
        document.getElementById('location').innerHTML = "Tarayıcınız konum bilgisine erişmiyor.";
    }
});

function showPosition(position) {
    document.getElementById('location').innerHTML = "Enlem: " + position.coords.latitude +
        "<br>Boylam: " + position.coords.longitude;
}

function showError(error) {
    switch (error.code) {
        case error.PERMISSION_DENIED:
            document.getElementById('location').innerHTML = "Kullanıcı konumun paylaşılmasını reddetti."
            break;
        case error.POSITION_UNAVAILABLE:
            document.getElementById('location').innerHTML = "Konum bilgisi mevcut değil."
            break;
        case error.TIMEOUT:
            document.getElementById('location').innerHTML = "İstek zaman aşımına uğradı."
            break;
        case error.UNKNOWN_ERROR:
            document.getElementById('location').innerHTML = "Bilinmeyen bir hata oluştu."
            break;
    }
}

// Kamera Erişimi
document.getElementById('startCamera').addEventListener('click', function () {
    const video = document.getElementById('video');
    navigator.mediaDevices.getUserMedia({ video: true })
        .then(function (stream) {
            video.srcObject = stream;
        })
        .catch(function (error) {
            console.log("Kamera açılırken bir hata oluştu: " + error);
        });
});

// Fotoğraf Çekme
document.getElementById('snap').addEventListener('click', function () {
    const canvas = document.getElementById('canvas');
    const video = document.getElementById('video');
    const context = canvas.getContext('2d');
    
    context.drawImage(video, 0, 0, canvas.width, canvas.height);
});

// Cihaz Yönelimi
window.addEventListener('deviceorientation', function (event) {
    const orientation = document.getElementById('orientation');
    orientation.innerHTML = `Alpha: ${event.alpha}, Beta: ${event.beta}, Gamma: ${event.gamma}`;
});
