const apiUrl = 'https://my-library-api.herokuapp.com/api/book'; // Backend API URL

// Sayfa yüklendiğinde kitapları getir
window.onload = () => {
    fetchBooks();
};

// Kitapları API'den al
async function fetchBooks() {
    const response = await fetch(apiUrl);
    const books = await response.json();

    // Kitapları listele
    const bookList = document.getElementById('bookList');
    bookList.innerHTML = '';
    books.forEach(book => {
        const bookItem = document.createElement('div');
        bookItem.classList.add('book-item');
        bookItem.innerHTML = `<h3>${book.title}</h3><p>Yazar: ${book.author}</p>`;
        bookList.appendChild(bookItem);
    });
}

// Kitap ekle
async function addBook() {
    const title = document.getElementById("bookTitle").value;
    const author = document.getElementById("bookAuthor").value;

    if (title && author) {
        const newBook = { title, author };

        const response = await fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newBook)
        });

        if (response.ok) {
            fetchBooks();  // Kitap ekledikten sonra listeyi güncelle
        }
    } else {
        alert("Kitap başlığı ve yazar adı boş olamaz!");
    }
}
