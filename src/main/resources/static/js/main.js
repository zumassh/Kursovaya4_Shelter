// Функция для открытия pop-up карточки
function openPopup(card) {
    var popup = card.previousElementSibling;
    var overlay = popup.previousElementSibling;

    // Показываем pop-up и затемнение фона
    popup.style.display = 'block';
    overlay.style.display = 'block';

    // Добавляем обработчик события клика на кнопку закрытия
    var closeBtn = document.getElementById('closeBtn');
    closeBtn.onclick = function() {
        // Скрываем pop-up и затемнение фона при клике на кнопку закрытия
        popup.style.display = 'none';
        overlay.style.display = 'none';
    };
}

// Добавляем обработчик события клика на затемнение фона
function closePopup(overlay){
    console.log(overlay)
    var popup = overlay.nextElementSibling;
    popup.style.display = 'none';
    overlay.style.display = 'none';
}

function sendPostRequest() {
    var xhr = new XMLHttpRequest();
    var url = '/your-endpoint-url'; // Укажите URL вашего обработчика POST-запроса

    // Настройка запроса
    xhr.open('POST', url, true);
    xhr.setRequestHeader('Content-Type', 'application/json'); // Устанавливаем заголовок Content-Type

    // Данные для отправки (в формате JSON)
    var data = JSON.stringify({ key: 'value' }); // Замените на ваш объект данных

    // Отправка запроса
    xhr.send(data);
}

function back(){
    window.history.back();
}
