// Kitap verilerini tutacak array
let books = [];
let filteredBooks = [];

// Sayfa yüklendiğinde kitapları göster
window.onload = () => {
    displayBooks(books);
};

// Kitap ekleme fonksiyonu
function addBook() {
    const title = document.getElementById("bookTitle").value;
    const author = document.getElementById("bookAuthor").value;

    if (title && author) {
        const newBook = {
            id: books.length + 1,
            title,
            author
        };

        // Kitapları ekleyelim
        books.push(newBook);
        filteredBooks.push(newBook);

        // Görüntüle
        displayBooks(filteredBooks);

        // Formu temizle
        document.getElementById("bookTitle").value = "";
        document.getElementById("bookAuthor").value = "";
    } else {
        alert("Kitap başlığı ve yazar adı boş olamaz!");
    }
}

// Kitapları listeleme fonksiyonu
function displayBooks(booksToDisplay) {
    const bookList = document.getElementById("bookList");
    bookList.innerHTML = "";

    booksToDisplay.forEach(book => {
        const bookItem = document.createElement("div");
        bookItem.classList.add("book-item");
        bookItem.innerHTML = `
            <h3>${book.title}</h3>
            <p>Yazar: ${book.author}</p>
        `;
        bookList.appendChild(bookItem);
    });
}

// Arama fonksiyonu
function searchBooks() {
    const searchQuery = document.getElementById("searchBox").value.toLowerCase();
    filteredBooks = books.filter(book => book.title.toLowerCase().includes(searchQuery));
    displayBooks(filteredBooks);
}
