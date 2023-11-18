const homeScore = document.getElementById('home-score');
const awayScore = document.getElementById('away-score');
const homePlusBtn = document.getElementById('home-plus');
const homeMinusBtn = document.getElementById('home-minus');
const awayPlusBtn = document.getElementById('away-plus');
const awayMinusBtn = document.getElementById('away-minus');

let homeTeamScore = 0;
let awayTeamScore = 0;

homePlusBtn.addEventListener('click', () => {
    homeTeamScore++;
    homeScore.textContent = homeTeamScore;
});

homeMinusBtn.addEventListener('click', () => {
    if (homeTeamScore > 0) {
        homeTeamScore--;
        homeScore.textContent = homeTeamScore;
    }
});

awayPlusBtn.addEventListener('click', () => {
    awayTeamScore++;
    awayScore.textContent = awayTeamScore;
});

awayMinusBtn.addEventListener('click', () => {
    if (awayTeamScore > 0) {
        awayTeamScore--;
        awayScore.textContent = awayTeamScore;
    }
});
