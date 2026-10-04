const diffBtns= document.querySelectorAll(".diff");
const triesCounter= document.querySelector(".triesCounter");
const indicator= document.querySelector(".indicator");
const guessSpace = document.querySelector(".guessSpace");
const numBtns = document.querySelectorAll(".num");
const suprBtn = document.querySelector(".supr");
const checkBtn = document.querySelector(".check");

let answer = 0
let correct = randint(0, 10)
let tries = 0

function randint(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

numBtns.forEach(button => {
    button.addEventListener("click", () => {
        guessSpace.value += button.textContent;
    });
});

diffBtns.forEach(button => {
    button.addEventListener("click", () => {
        correct = randint(0, button.dataset.value);
        guessSpace.value = "";
    });
});

suprBtn.addEventListener("click", () => {
    guessSpace.value = guessSpace.value.slice(0, -1);
});

checkBtn.addEventListener("click", () => {
    answer = guessSpace.value;
    
    if (answer.trim() === "") {
        indicator.textContent = "Ingresa un número";
        return;
    }
    
    if (answer == correct) {
        indicator.textContent = "Correcto!"
    } else if (answer > correct) {
        indicator.textContent = "Es menor"
    } else if (answer < correct) {
        indicator.textContent = "Es mayor"
    } else {
        indicator.textContent = "Error?"
    }
    
    tries += 1;
    triesCounter.textContent = tries;
});