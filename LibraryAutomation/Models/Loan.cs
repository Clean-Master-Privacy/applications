namespace LibraryAutomation.Models
{
    public class Loan
    {
        public int LoanId { get; set; }
        public int UserId { get; set; }
        public int BookId { get; set; }
        public DateTime LoanDate { get; set; }
        public DateTime? ReturnDate { get; set; }

        public User User { get; set; }
        public Book Book { get; set; }
    }
}
