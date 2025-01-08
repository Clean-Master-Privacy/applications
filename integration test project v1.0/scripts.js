// scripts.js

// Kitapları saklayacağımız dizi
let books = [];

// Kitapları tabloya eklemek için fonksiyon
function renderBooks() {
    const tableBody = document.querySelector('#book-table tbody');
    tableBody.innerHTML = ''; // Tablodaki mevcut içerikleri temizle

    books.forEach((book, index) => {
        const row = document.createElement('tr');

        row.innerHTML = `
            <td>${index + 1}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.year}</td>
            <td><button class="delete" onclick="deleteBook(${index})">Sil</button></td>
        `;

        tableBody.appendChild(row);
    });
}

// Kitap ekleme işlemi
document.getElementById('book-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const title = document.getElementById('book-title').value;
    const author = document.getElementById('book-author').value;
    const year = document.getElementById('book-year').value;

    // Yeni kitap nesnesini diziye ekle
    const newBook = { title, author, year };
    books.push(newBook);

    // Formu sıfırla
    document.getElementById('book-form').reset();

    // Kitapları yeniden render et
    renderBooks();
});

// Kitap silme işlemi
function deleteBook(index) {
    books.splice(index, 1);  // Kitap dizisinden sil
    renderBooks();  // Tabloyu güncelle
}

// Sayfa yüklendiğinde kitapları render et
renderBooks();
