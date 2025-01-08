using Microsoft.EntityFrameworkCore;
using LibraryAutomationBackend.Data;

var builder = WebApplication.CreateBuilder(args);

// Veritabanı bağlantısı ve DbContext ayarları
builder.Services.AddDbContext<LibraryContext>(options =>
    options.UseSqlServer(builder.Configuration.GetConnectionString("DefaultConnection")));

// CORS (Cross-Origin Resource Sharing) ayarları
builder.Services.AddCors(options =>
{
    options.AddPolicy("AllowAll", builder =>
        builder.AllowAnyOrigin()
               .AllowAnyMethod()
               .AllowAnyHeader());
});

builder.Services.AddControllers();

var app = builder.Build();

// CORS politikasını uygula
app.UseCors("AllowAll");

app.UseAuthorization();

app.MapControllers();  // Controller'ları API'ye bağla

app.Run();  // API'yi başlat
