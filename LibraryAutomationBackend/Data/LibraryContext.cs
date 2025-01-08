using Microsoft.EntityFrameworkCore;
using LibraryAutomationBackend.Models;

namespace LibraryAutomationBackend.Data
{
    public class LibraryContext : DbContext
    {
        public LibraryContext(DbContextOptions<LibraryContext> options) : base(options)
        {
        }

        public DbSet<Book> Books { get; set; }  // Kitapları içeren DbSet
    }
}
