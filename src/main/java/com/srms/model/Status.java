package com.srms.model;

public enum Status {
    SHIFT_LEAD,
    CS,              // Customer Support — отвечает клиентам
    PSR,             // Courier Support — отвечает курьерам
    VENUE,           // Venue Support — работает с ресторанами
    CFC,             // Courier Secondary Platform
    TRAINEE,         // Обучение / Тренировка
    SPECIAL_TASK,    // Выполняет особое задание
    AWAY,            // Отсутствует временно
    MEETING,         // На встрече
    BREAK,           // На перерыве
    STATION_ISSUES,  // Проблемы с оборудованием / станцией
    BRB              // Be Right Back — короткая пауза

}
