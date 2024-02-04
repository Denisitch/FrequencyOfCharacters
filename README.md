### REST API, вычисляющее частоту встречи символов по заданной строке

#### Сборка:
```bash
./mvnw clean install
```
#### Запуск:
```bash
java -jar ./target/FrequencyOfCharacters-0.0.1-SNAPSHOT.jar
```
#### Использование:
GET HTTP-запрос
```bash
curl http://localhost:8080/api/frequency/{ЗАДАННАЯ_СТРОКА}
```
#### Формат запроса:
Непустая строка до 30 символов включительно
#### Формат ответа:
JSON со значением частоты встречи символов по заданной строке, где данные отсортированы по убыванию количества вхождений символа в заданную строку

