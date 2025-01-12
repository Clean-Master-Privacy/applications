<!DOCTYPE html>
<html lang="tr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kayıt Ol - ProtonMail Benzeri</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <header>
        <h1><img src="svgs/logo-icon.svg" alt="Logo" class="logo"> ProtonMail Benzeri</h1>
        <nav>
            <ul>
                <li><a href="index.php">Ana Sayfa</a></li>
                <li><a href="register.php">Kayıt Ol</a></li>
                <li><a href="#">Giriş Yap</a></li>
            </ul>
        </nav>
    </header>
    
    <main>
        <h2>Kayıt Ol</h2>
        <form action="" method="POST">
            <label for="email">E-posta Adresi:</label>
            <input type="email" id="email" name="email" required>
            <label for="password">Şifre:</label>
            <input type="password" id="password" name="password" required>
            <input type="submit" value="Kayıt Ol">
        </form>

        <?php
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            $email = $_POST['email'];
            $password = $_POST['password'];
            
            // Kayıt işlemi burada yapılacak (örn: veritabanına kaydetme)

            echo "<p>Kayıt işleminiz başarılı! E-posta: $email</p>";
        }
        ?>
    </main>
    
    <footer>
        <p>&copy; 2023 ProtonMail Benzeri - Tüm Hakları Saklıdır.</p>
    </footer>
</body>
</html>
