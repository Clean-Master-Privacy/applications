function loginUser(event) {
    event.preventDefault(); // Formun sayfa yenilemesini engelle

    // Kullanıcı adı ve şifreyi al
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Basit doğrulama (gerçek dünyada backend doğrulaması gereklidir)
    if (username === "admin" && password === "password123") {
        // Başarılı giriş mesajı
        document.getElementById('loginMessage').textContent = "Login successful!";
        document.getElementById('loginMessage').style.color = "green";
        // Giriş başarılıysa, formu sıfırla veya yönlendirme yap
        setTimeout(() => {
            window.location.href = "/dashboard"; // Yönlendirme yapılabilir
        }, 2000);
    } else {
        // Başarısız giriş mesajı
        document.getElementById('loginMessage').textContent = "Invalid username or password!";
        document.getElementById('loginMessage').style.color = "red";
    }
}
