// Scroll Animations
window.addEventListener('scroll', function() {
    var elements = document.querySelectorAll('.scroll-anim');
    elements.forEach(function(element) {
        if (element.getBoundingClientRect().top <= window.innerHeight) {
            element.classList.add('fade-in');
        }
        
    });
});

// Hasaralma animasyonunun çalıştığı öğeyi seç
const fadeInSections = document.querySelectorAll('.scroll-anim');

// IntersectionObserver'ı kullanarak sayfada görünürlük durumunu kontrol et
const observer = new IntersectionObserver((entries, observer) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.classList.add('visible'); // Sayfada görünür olduğunda 'visible' sınıfını ekle
            observer.unobserve(entry.target); // Gözlemi sonlandır
        }
    });
}, { threshold: 0.5 }); // Öğenin %50'si görünür olduğunda animasyonu başlat

// Tüm öğeleri gözlemle
fadeInSections.forEach(section => {
    observer.observe(section);
});

