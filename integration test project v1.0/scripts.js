// API URL'i, Azure'da barındırdığınız API'nin URL'ine göre değiştirin
const apiUrl = 'https://your-api-url.azurewebsites.net/api/books';

// Kitapları listele
async function getBooks() {
    const response = await fetch(apiUrl);
    const books = await response.json();

    const tableBody = document.querySelector('#book-table tbody');
    tableBody.innerHTML = '';

    books.forEach((book, index) => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${index + 1}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.year}</td>
            <td><button class="delete" onclick="deleteBook(${book.id})">Sil</button></td>
        `;
        tableBody.appendChild(row);
    });
}

// Kitap ekle
document.getElementById('book-form').addEventListener('submit', async function(event) {
    event.preventDefault();

    const title = document.getElementById('book-title').value;
    const author = document.getElementById('book-author').value;
    const year = document.getElementById('book-year').value;

    const newBook = { title, author, year };

    const response = await fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newBook)
    });

    if (response.ok) {
        // Yeni kitap ekledikten sonra listeyi güncelle
        getBooks();
    }
});

// Kitap silme
async function deleteBook(id) {
    const response = await fetch(`${apiUrl}/${id}`, {
        method: 'DELETE',
    });

    if (response.ok) {
        // Kitap silindikten sonra listeyi güncelle
        getBooks();
    }
}

// Sayfa yüklendiğinde kitapları listele
window.onload = getBooks;
