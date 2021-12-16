Для запуска программы необходимо выполнить команду:
maven clean package
после выполнить
java -jar .\target\currency-0.0.1-SNAPSHOT.jar
в файле с нахождением:
currency-0.0.1-SNAPSHOT.jar.original.

Для получения валюты необходимо выполнить get запрос по следующему адресу:
http://localhost:8080/api/currencies/eur?currency=RUB
с параметром 
1. eur?currency=RUB
и/или
2. eur?date=2021-12-15
В параметре currency вносится валюта в формате "RUB", "USD" или указывается дата.
Данный гет запрос вернет валюту еслиы внсена валюта и выведет список валют и их ставки на выбранную дату.