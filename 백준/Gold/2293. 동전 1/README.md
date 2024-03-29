# [Gold V] 동전 1 - 2293 

[문제 링크](https://www.acmicpc.net/problem/2293) 

### 성능 요약

메모리: 14212 KB, 시간: 140 ms

### 분류

다이나믹 프로그래밍(dp)

### 문제 설명

<p>n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그 경우의 수를 구하시오. 각각의 동전은 몇 개라도 사용할 수 있다.</p>

<p>사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.</p>

### 입력 

 <p>첫째 줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 다음 n개의 줄에는 각각의 동전의 가치가 주어진다. 동전의 가치는 100,000보다 작거나 같은 자연수이다.</p>

### 출력 

 <p>첫째 줄에 경우의 수를 출력한다. 경우의 수는 2<sup>31</sup>보다 작다.</p>

### 문제 풀이

해당 문제는 다이나믹 프로그래밍(DP)으로 풀 수 있다.

점화식만 찾아낸다면 아마 큰 문제없이 풀 수 있을것이다.

동전의 가치를 저장할 배열 num[]와 가치별 경우의 수를 저장할 dp[] 배열을 선언하였다.

점화식을 찾아내는 과정은 이러하다.

1. 동전 가치가 1인 경우
> 가치의 합이 4인 경우와 같다, dp[5] = dp[4]가 된다.

2. 동전 가치가 2인 경우
> 가치의 합이 3인 경우와 같다, dp[5] = dp[3]이 된다.

3. 동전의 가치가 5인 경우
> 가치의 합이 0인 경우와 같다, dp[5] = dp[0]이 된다.

4. 위의 경우에 따라 점화식은 dp[j] += dp[j - num[i]]이 된다는 것을 알 수 있다.
