// Scroll Animations
window.addEventListener('scroll', function() {
    var elements = document.querySelectorAll('.scroll-anim');
    elements.forEach(function(element) {
        if (element.getBoundingClientRect().top <= window.innerHeight) {
            element.classList.add('fade-in');
        }
    });
});
