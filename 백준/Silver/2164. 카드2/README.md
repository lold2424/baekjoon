# [Silver IV] 카드2 - 2164 

[문제 링크](https://www.acmicpc.net/problem/2164) 

### 성능 요약

메모리: 45556 KB, 시간: 200 ms

### 분류

자료 구조(data_structures), 큐(queue)

### 문제 설명

<p>N장의 카드가 있다. 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며, 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.</p>

<p>이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다. 우선, 제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.</p>

<p>예를 들어 N=4인 경우를 생각해 보자. 카드는 제일 위에서부터 1234 의 순서로 놓여있다. 1을 버리면 234가 남는다. 여기서 2를 제일 아래로 옮기면 342가 된다. 3을 버리면 42가 되고, 4를 밑으로 옮기면 24가 된다. 마지막으로 2를 버리고 나면, 남는 카드는 4가 된다.</p>

<p>N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 정수 N(1 ≤ N ≤ 500,000)이 주어진다.</p>

### 출력 

 <p>첫째 줄에 남게 되는 카드의 번호를 출력한다.</p>

### 문제 풀이

 맨 앞의 수를 poll로 삭제하고, 다음 수를 poll로 삭제한것을 다시 맨 뒤에 offer로 삽입하는 과정을 사용했다.
 
 위의 과정으로 while을 이용해서 수가 1개 남을때까지 반복하였다.
 
 다른 사람의 풀이를 찾아보니, 직접 구현하는 방법도 있었다.
 
 단순히 큐만 보인다고해서 큐만 사용하려 하지 말고 단순 구현을 해보려고 노력해보아야겠다.
