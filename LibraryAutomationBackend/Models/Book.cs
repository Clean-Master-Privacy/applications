namespace LibraryAutomationBackend.Models
{
    public class Book
    {
        public int Id { get; set; }          // Kitap ID'si
        public string Title { get; set; }    // Kitap başlığı
        public string Author { get; set; }   // Kitap yazarı
        public int Year { get; set; }        // Yayın yılı
    }
}
