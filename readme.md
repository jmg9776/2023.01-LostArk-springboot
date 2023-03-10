# 로스트아크 도우미
상세정보
+ 제작기간 : 2023.01.01 ~ 진행중
+ 개발언어 : Springboot, React(예정)
+ 담당 : Front, Backend

# 요약
로스트아크의 간단한 일간, 주간 수익에서부터 효율적인 재화사용을 통한 스팩업 방법을 제공하는 프로젝트입니다.

주요기능
1. 주간 레이드 수익
2. 일간, 주간 카오스 던전 수익
3. 일간, 주간 가디언 토벌 수익
4. 각인 최적화 계산기
5. 스팩업 효율 계산기

# 개발배경

게임과 같이 일상생활에서 계산을 통해서 효율이 좋은 방법을 추구하는 것을 선호하는 편인데, 이러한 정보를 유튜브나 직접적으로 정리하는 사이트들을 통해 전달해 받다 보니,
게임과 같이 재화의 가치가 매우 유동적인 시장인 게임에서는 실시간이 아닌 정보를 얻는 것이 불편했습니다. 

이러한 불편함으로 크롤링을 통해 해결하려 고민하던 도중, 로스트 아크에서 OPEN API를 제공하기 시작하면서 제작을 결정하게 되었습니다.

## LostArk Api Information

thirdParty.lostArk : FeignClient setting and mapping

### How to use?
#### Please check this demo
path : service.aggregator.lostArk -> data and database controller

## Redis
> docker pull redis
> 
> docker run --name redis -d -p 6379:6379 redis
> 
> docker start redis
