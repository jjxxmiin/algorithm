---
layout: post
title:  "담금질 기법"
summary: "담금질 기법 알아보기"
date:   2019-09-25 13:00 -0400
categories: Algorithm
use_math: true
---

# Simulated annealing
- 담금질 기법
- 최적의 해를 찾는 확률 모델
- gradient-free

담금질 기법을 금속의 담금질로 설명하자면 금속 재료를 가열한 다음 조금씩 냉각시켜서 점점 자신이 원하는 금속 모양으로 만드는 기법이다.

최적의 해를 찾고 그곳이 지역적 최소화일수 있기 때문에 가장 깊숙한 전역적 최소점을 찾기 위해 다시 최적의 해를 찾아 나가는 것을 반복해 가는 최적화 알고리즘이다.

최적의 해를 찾고 또 다른 최적의 해를 찾기 위해서 최소점을 찾기 위한 감소만이 아니라 증가를 허용한다.

```
begin
Get an initial solution S; //  s ← s0; e ← E(s) 초기값을 설정한다.
Get an initial temperature T>0; // 초기 온도값을 설정함, 예) T=1000
while not yet "frozen" do  // 최적의 경우를 찾을 때 까지 즉 온도가 완전히 내려 갈때 까지 프로그램을 Loop한다.
   for 1<= i <= P do       // P=nk 즉 Step의 사이즈가 되고 k는 주어진 종류를 n은 우리가 결정하게 된다. 즉 STEP사이즈를 결정하게 된다.
   Pick a random neighbor S' of S; // 임의로 선택한 솔루션 S' 과 기존의 솔루션 S를 선택한다.
   ∆ ← cost(S')-cost(S); // 기존의 솔루션과 새로운 솔루션을 가격의 차 즉 최적화의 값의 차를 만든다.
                          // ∆ ← area(S')-area(S), 돌을 예를 들면 면적이 크기가 효율성의 차이 이다.
   /* downhill move */ 
   if ∆ <= 0 then S ← S' // S'의 값이 작으면 즉 차지하는 면적이 작고, 더 효율적으로 배치 되었으면, 
                          // 이것이 현재까지의 최적화가 되고 이것을 온도가 내려간다. Downhill로 표현한다.
   /* uphill move */ 
   if ∆ > 0 then S ← S' // S'의 값이 크면 즉 차지하는 면적이 크고, 더 비 효율적으로 배치 되었으면, 이것을 온도가 올라간다.
                         //  uphill로 표현한다.
T ← rT; // 한가지 경우의 수를 처리 했었므로 한 단계 줄어 들게 되면 다음 반복을 진행한다.
return S    // 프로그램이 마무리 되면 우리가 찾는 최적화의 답을 리턴하고, 정확히 최적화의 답을 찾았으면 이것을 Global Optimization 즉 모든 경우의 수중에서 가장 최적화된 것이다.
end
```

# 참조
- [https://ko.wikipedia.org/wiki/%EB%8B%B4%EA%B8%88%EC%A7%88_%EA%B8%B0%EB%B2%95](https://ko.wikipedia.org/wiki/%EB%8B%B4%EA%B8%88%EC%A7%88_%EA%B8%B0%EB%B2%95)
- [https://zzsza.github.io/data/2019/04/01/simulated-annealing/](https://zzsza.github.io/data/2019/04/01/simulated-annealing/)