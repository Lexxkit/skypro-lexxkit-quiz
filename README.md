### Quize App

This app adds questions with answers to its inner collection and returns from it the number of randomly selected questions desired by the user.

Once the application starts, the initial collection of questions is empty and must be filled in by the user.

#### Mappings
1. <ins>/exam/java/add?question=&answer=</ins>

Add question and its answer to the app. If the app contains the same question and answer - 400 status (Bad Request) will be thrown.

2. <ins>/exam/java/remove?question=&answer=</ins>

Remove question and its answer to the app. If app doesn't contain equal question and answer - 404 status (Not Found) will be thrown.

3. <ins>/exam/java</ins>

Returns list of all questions and answers from the inner storage.

4. <ins>/exam/get/{number}</ins>

Returns a list of desired number of questions picked randomly from the app inner storage. If {number} <= 0 or {number} > amount of questions in the app - 400 status (Bad Request) will be thrown. 
