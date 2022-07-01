# [Bronze II] Pirates - 15238 

[문제 링크](https://www.acmicpc.net/problem/15238) 

### 성능 요약

메모리: 14544 KB, 시간: 136 ms

### 분류

구현(implementation), 문자열(string)

### 문제 설명

<p>Pirates talk a funny way. They say word where the letters are repeated more than they need to be. We would like know which letter appears the most frequently in a Pirate word.</p>

<p>For example: In the word “arrrrrghh”, the letter “r” appears 5 times while “h” appears twice.</p>

<p>Write a program that reads a pirate word from the terminal and writes the letter that occurs most frequently.</p>

<p>It is guaranteed that only one letter is the most repeated. That is, words like “aipo” won’t appear because no single letter wins.</p>

### 입력 

 <p dir="ltr">The input will consist of two lines.</p>

<p dir="ltr">The first line will contain the size of the word and the second the word to process.</p>

<p dir="ltr">The word will only contain lowercase letters from a to z. The size of the word will be at most 1000 characters. No spaces or other symbols will appear.</p>

### 출력 

 <p dir="ltr">Print a single line with the character that appears the most and the number of occurrences.</p>

### 문제풀이

해당 문제는 몇개의 문자가 들어갈지 입력받은 후 문자열을 입력하여 해당 문자열에 똑같은 문자가 몇개가 있는지 출력하는 문제이다.

문자열을 배열에 입력받은 후 미리 알파벳 순서대로 입력해둔 배열을 이용하여 같을 경우에는 또 다른 배열에 숫자를 더하여 저장해줬다.

이런 방식으로 입력받은 배열을 전부다 확인하고 그 중 최대값을 찾아 출력해줬다.

처음에는 리스트형식으로 바꿔 인덱스값을 찾아보려 했지만 indexOf를 사용해도 찾을 수 없어서 노가다로 문제를 풀었다.

문제를 다 풀고보니 아스키 코드를 이용해서도 쉽게 풀이가 가능할것같다.
