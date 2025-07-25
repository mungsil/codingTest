# [Gold V] 문자 해독 - 1593 

[문제 링크](https://www.acmicpc.net/problem/1593) 

### 성능 요약

메모리: 149720 KB, 시간: 424 ms

### 분류

문자열, 슬라이딩 윈도우

### 제출 일자

2025년 7월 22일 00:04:46

### 문제 설명

<p>마야 문자를 해독하는 일은 예상 외로 어려운 일이다. 현재에도 뜻이 완전히 밝혀진 마야 문자는 거의 없는 실정이며, 그나마 해독에 진척이 시작된 지는 30여 년도 되지 않았다.</p>

<p>마야 문자는 소리를 나타내는 여러 종류의 그림글자로 구성되는데, 이 글자들이 여러 위치에서 결합함으로써 단어를 형성한다.</p>

<p>마야 문자 해독을 어렵게 하는 요인 중 하나는 바로 단어를 읽는 순서이다. 마야 문자를 쓰는 고대인들은 단어를 기록할 때 특정한 규칙 대신, 그들이 보기에 좋게 보이도록 단어를 이루는 글자들을 아무렇게나 배열했다. 그렇기 때문에 고고학자들이 마야 기록에서 단어를 이루는 각 그림글자들의 발음을 알아내더라도 그 단어를 실제로 발음하는 방법은 정확히 알 수 없는 셈이다.</p>

<p>고고학자들은 W라는 특정 단어를 발굴 기록으로부터 찾고 있다. 그 단어를 구성하는 각 글자들은 무엇인지 알고 있지만, 이것이 고대 기록에 어떤 형태로 숨어 있는지는 다 알지 못한다.</p>

<p>W를 이루고 있는 g개의 그림문자와, 연구 대상인 벽화에 기록된 마야 문자열 S가 주어졌을 때, 단어 W가 마야 문자열 S에 들어있을 수 있는 모든 가짓수를 계산하는 프로그램을 작성하시오. 즉, 문자열  S안에서 문자열 W의 순열 중 하나가 부분 문자열로 들어있는 모든 경우의 수를 계산하라는 뜻이다.</p>

### 입력 

 <p>첫째 줄에 고고학자들이 찾고자 하는 단어 W의 길이 g와 발굴된 벽화에서 추출한 문자열 S의 길이 |S|가 빈 칸을 사이에 두고 주어진다. (1≤g≤3000,  g≤|S|≤3,000,000) 둘째 줄에 W, 셋째 줄에 S의 실제 내용이 들어있다. 모든 문자열은 알파벳으로 이루어지며, 대소문자를 구분한다.</p>

### 출력 

 <p>첫째 줄에 W의 순열이 S 안에 있을 수 있는 형태의 개수를 출력한다.</p>

