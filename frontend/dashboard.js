const API = 'http://localhost:8080';

document.addEventListener('DOMContentLoaded', () => {
    loadDashboard();
});

function loadDashboard() {
    fetch(`${API}/api/dashboard`)
        .then(res => res.json())
        .then(data => renderFullDashboard(data));
}

function renderFullDashboard(data) {
    const container = document.getElementById('dashboard');
    container.innerHTML = '';

    const allStatuses = Object.keys(data.platforms);

    allStatuses.forEach(status => {
        const users = data.platforms[status];
        const col = document.createElement('div');
        col.className = 'column';

        const heading = document.createElement('h3');
        heading.textContent = `${status} (${users.length || 0})`;
        col.appendChild(heading);

        if (users.length === 0) {
            const p = document.createElement('p');
            p.textContent = 'no one';
            col.appendChild(p);
        } else {
            users.forEach(user => {
                col.appendChild(createUserCard(user, true));
            });
        }

        container.appendChild(col);
    });
}

function createUserCard(user, withTimer = false) {
    const div = document.createElement('div');
    div.className = 'user';

    if (user.status === 'CS' || user.status === 'BREAK') {
        div.classList.add('purple');
    } else if (user.status === 'BRB') {
        div.classList.add('green');
    }

    const name = document.createElement('div');
    name.className = 'name';
    name.textContent = user.fullName;
    div.appendChild(name);

    if (user.comment) {
        const comment = document.createElement('div');
        comment.className = 'comment';
        comment.textContent = user.comment;
        div.appendChild(comment);
    }

    if (user.status === 'BRB' || user.status === 'BREAK') {
        const timer = document.createElement('div');
        timer.className = 'timer';
        timer.id = `timer-${user.id}`;
        div.appendChild(timer);
        startCountdown(user, timer);
    }

    return div;
}

function startCountdown(user, el) {
    const now = new Date();
    let durationMs;

    if (user.status === 'BRB') {
        durationMs = 0.5 * 60 * 1000; // фиксировано 10 минут
    } else if (user.status === 'BREAK') {
        durationMs = 60 * 60 * 1000;
    } else {
        return;
    }

    const end = new Date(now.getTime() + durationMs);

    function update() {
        const now = new Date();
        const diff = end - now;

        const mins = Math.floor(Math.abs(diff) / 60000);
        const secs = Math.floor((Math.abs(diff) % 60000) / 1000);
        const display = `${mins}:${secs.toString().padStart(2, '0')}`;

        if (diff <= 0) {
            el.textContent = `⏱ -${display}`;
            el.parentElement.classList.remove('green', 'purple');
            el.parentElement.classList.add('red');
        } else {
            el.textContent = `⏱ ${display}`;
        }
    }

    update();
    const interval = setInterval(update, 1000);
}
