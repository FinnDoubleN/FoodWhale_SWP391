/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var swiper = new Swiper(".mySwiper", {
    slidesPerView: 1,
    spaceBetween: 30,
    loop: true,
    autoplay: {
        delay: 2500,
        disableOnInteraction: false,
    },
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
});

var slides = document.querySelectorAll('.slide')
var prev = document.querySelector('.prev-btn')
var next = document.querySelector('.next-btn')
var img_cloud = document.querySelectorAll('.img-cloud')
var img_content = document.querySelectorAll('.img-content')
var content_h2 = document.querySelectorAll('.content-h2')
var content_title = document.querySelectorAll('.content-title')
var btn_content = document.querySelectorAll('.btn-content')
var img_rocket = document.querySelector('.img-rocket')
var header = document.querySelector('.header')
var scrollup = document.querySelector('.scrollup')
slide = 0

for (var i = 0; i < content_h2.length; i++) {
    const values = content_h2[i].textContent
    arryText = values.split('')
    const spanText = arryText.map((value, index) =>
        `<span style="--i:${index};">${value}</span>`
    )
    content_h2[i].innerHTML = spanText.join('')
}

var showSlide = function() {
    slides[slide].classList.add('active')
    setTimeout(function() {
        img_cloud[slide].classList.add('active')
        img_content[slide].classList.add('active')
        content_h2[slide].classList.add('active')
        content_title[slide].classList.add('active')
        btn_content[slide].classList.add('active')
        img_rocket.classList.add('active')
    }, 100)

}
showSlide()

var nextAuto = function() {
    {
        slide++
        for (var i = 0; i < img_cloud.length; i++) {
            img_cloud[i].className = img_cloud[i].className.replace(' active', '')
        }
        for (var i = 0; i < img_content.length; i++) {
            img_content[i].className = img_content[i].className.replace(' active', '')
        }
        for (var i = 0; i < content_h2.length; i++) {
            content_h2[i].className = content_h2[i].className.replace(' active', '')
        }
        for (var i = 0; i < content_title.length; i++) {
            content_title[i].className = content_title[i].className.replace(' active', '')
        }
        for (var i = 0; i < btn_content.length; i++) {
            btn_content[i].className = btn_content[i].className.replace(' active', '')
        }
        img_rocket.className = img_rocket.className.replace(' active', '')

        if (slide > slides.length - 1)
            slide = 0

        setTimeout(function() {
            for (var i = 0; i < slides.length; i++) {
                slides[i].className = slides[i].className.replace(' active', '')
            }
            slides[slide].classList.add('active')
            img_cloud[slide].classList.add('active')
            img_content[slide].classList.add('active')
            content_h2[slide].classList.add('active')
            content_title[slide].classList.add('active')
            btn_content[slide].classList.add('active')
            if (slide == 0) {
                img_rocket.classList.add('active')
            }
        },500)
    }
}
var prevAuto = function() {
    {
        slide--
        for (var i = 0; i < img_cloud.length; i++) {
            img_cloud[i].className = img_cloud[i].className.replace(' active', '')
        }
        for (var i = 0; i < img_content.length; i++) {
            img_content[i].className = img_content[i].className.replace(' active', '')
        }
        for (var i = 0; i < content_h2.length; i++) {
            content_h2[i].className = content_h2[i].className.replace(' active', '')
        }
        for (var i = 0; i < content_title.length; i++) {
            content_title[i].className = content_title[i].className.replace(' active', '')
        }
        for (var i = 0; i < btn_content.length; i++) {
            btn_content[i].className = btn_content[i].className.replace(' active', '')
        }
        if (slide < 0)
            slide = slides.length - 1

        setTimeout(function() {
            for (var i = 0; i < slides.length; i++) {
                slides[i].className = slides[i].className.replace(' active', '')
            }
            slides[slide].classList.add('active')
            img_cloud[slide].classList.add('active')
            img_content[slide].classList.add('active')
            content_h2[slide].classList.add('active')
            content_title[slide].classList.add('active')
            btn_content[slide].classList.add('active')
            if (slide == 0 ) {
                img_rocket.classList.add('active')
            }
        }, 1500)
    }
}
var auto
var repeat = function() {
    auto = setInterval(nextAuto, 15000)
}
repeat()
next.addEventListener('click', function() {
    nextAuto()
    clearInterval(auto)
    repeat()
})

prev.addEventListener('click', function() {
    prevAuto()
    clearInterval(auto)
    repeat()
})

function shows() {
    if (this.scrollY >= 50) {
        header.classList.add('active')
        scrollup.classList.add('active')

    } else {
        header.classList.remove('active')
        scrollup.classList.remove('active')
    }
}
window.addEventListener('scroll', shows)
let box_monthy = document.querySelectorAll('.box-monthy')
let box_yearly = document.querySelectorAll('.box-yearly')
let price_links = document.querySelectorAll('.price__links')
for (let i = 0; i < price_links.length; i++) {
    price_links[i].onclick = function() {
        let j = 0
        while (j < price_links.length) {
            price_links[j++].className = 'price__links'
        }
        price_links[i].className = 'price__links active'
        if (i == 1) {
            for (let i = 0; i < box_yearly.length; i++) {
                let j = 0
                while (j < box_monthy.length) {
                    box_monthy[j++].className = 'box__content box-monthy'
                }
                box_yearly[i].className = 'box__content box-yearly active'
            }

        }
        if (i == 0) {
            for (let i = 0; i < box_monthy.length; i++) {
                let j = 0
                while (j < box_yearly.length) {
                    box_yearly[j++].className = 'box__content box-yearly'
                }
                box_monthy[i].className = 'box__content box-monthy active'
            }
        }
    }
}
var numbers = document.querySelectorAll('.number')

function isElementInViewport(el) {
    var rect = el.getBoundingClientRect();
    return (
        rect.top >= 0 &&
        rect.left >= 0 &&
        rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&
        rect.right <= (window.innerWidth || document.documentElement.clientWidth)
    )
}

function callbackfunc() {
    for (var i = 0; i < numbers.length; i++) {
        if (isElementInViewport(numbers[i])) {
            if (numbers[0].textContent == 0) {
                animateNumber(95, 3000, 0, function(number) {
                    const formattedNumber = number.toLocaleString()
                    numbers[0].innerText = formattedNumber
                })
            }
            if (numbers[1].textContent == 0) {
                animateNumber(80, 3000, 0, function(number) {
                    const formattedNumber = number.toLocaleString()
                    numbers[1].innerText = formattedNumber
                })
            }
            if (numbers[2].textContent == 0) {
                animateNumber(83, 3000, 0, function(number) {
                    const formattedNumber = number.toLocaleString()
                    numbers[2].innerText = formattedNumber
                })
            }
            if (numbers[3].textContent == 0) {
                animateNumber(76, 3000, 0, function(number) {
                    const formattedNumber = number.toLocaleString()
                    numbers[3].innerText = formattedNumber
                })
            }
        }
    }
}
window.addEventListener("scroll", callbackfunc)
window.addEventListener("load", callbackfunc)
window.addEventListener("resize", callbackfunc)

let n = 0

function animateNumber(finalNumber, duration = 5000, startNumber = 0, callback) {
    let currentNumber = startNumber
    const interval = window.setInterval(updateNumber, 17)

    function updateNumber() {
        if (currentNumber >= finalNumber) {
            clearInterval(interval)
        } else {
            let inc = Math.ceil(finalNumber / (duration / 17))
            if (currentNumber + inc > finalNumber) {
                currentNumber = finalNumber
                clearInterval(interval)
            } else {
                currentNumber += inc
            }
            callback(currentNumber)
        }
    }
}

function widthWindow() {
    var widthWd = window.innerWidth
    if (widthWd <= 768) {
        return 1
    } else return 2
}

window.addEventListener("resize", widthWindow);
window.addEventListener("load", widthWindow)

var swiper_1 = new Swiper(".mySwiper_1", {
    slidesPerView: widthWindow(),
    spaceBetween: 50,
    loop: true,
    autoplay: {
        delay: 2500,
        disableOnInteraction: false,
    },
    pagination: {
        el: ".swiper-pagination",
        type: "fraction",
    },
    navigation: {
        nextEl: ".blog__next",
        prevEl: ".blog__prev",
    },
});
window.addEventListener("resize", function() {
    var swiper_1 = new Swiper(".mySwiper_1", {
        slidesPerView: widthWindow(),
        spaceBetween: 50,
        loop: true,
        autoplay: {
            delay: 2500,
            disableOnInteraction: false,
        },
        pagination: {
            el: ".swiper-pagination",
            type: "fraction",
        },
        navigation: {
            nextEl: ".blog__next",
            prevEl: ".blog__prev",
        },
    });
});

const sections = document.querySelectorAll('section[id]')

function scrollActive() {
    sections.forEach(current => {
        const sectionHeight = current.offsetHeight
        const sectionTop = current.offsetTop - 50;
        sectionId = current.getAttribute('id')
        if (this.scrollY > sectionTop && this.scrollY <= sectionTop + sectionHeight) {
            document.querySelector('.nav-menu a[href*=' + sectionId + ']').classList.add('active')
        } else {
            document.querySelector('.nav-menu a[href*=' + sectionId + ']').classList.remove('active')
        }
    })
}
window.addEventListener('scroll', scrollActive)

var header__toggle = document.querySelector('.header__toggle')
var nav_menu = document.querySelector('.nav-menu')
header__toggle.onclick = function() {
    header__toggle.classList.toggle('active')
    nav_menu.classList.toggle('active')
}

const navLink = document.querySelectorAll('.nav-link')

function linkAction() {
    const navMenu = document.querySelector('.nav-menu')
    navMenu.classList.remove('active')
    header__toggle.classList.remove('active')
}
navLink.forEach(n => n.addEventListener('click', linkAction))

const sr = ScrollReveal({
    distance: '60px',
    duration: 2500,
    delay: 50,
})

sr.reveal(`.box-1`, { delay: 10, origin: 'left' })
sr.reveal(`.box-3`, { delay: 10, origin: 'right' })
sr.reveal(`.box-2`, { delay: 10 })
sr.reveal(`.services-img`, { delay: 0, origin: 'left' })
sr.reveal(`.service__nav-1`, { delay: 5, origin: 'right' })
sr.reveal(`.service__nav-2`, { delay: 15, origin: 'right' })
sr.reveal(`.service__nav-3`, { delay: 30, origin: 'right' })
sr.reveal(`.container-img`, { delay: 10, origin: 'right' })
sr.reveal(`.project-animate`, { delay: 10, origin: 'top' })
sr.reveal(`.btn-animate`, { delay: 10 })
sr.reveal(`.box__animate-1`, { delay: 10, origin: 'top' })
sr.reveal(`.box__animate-2`, { delay: 10 })
sr.reveal(`.maps`, { delay: 10, origin: 'right' })

var btn = $('#scrollupId');
btn.on('click', function(e) {
    e.preventDefault();
    $('html, body').animate({ scrollTop: 0 }, '1000');
});


