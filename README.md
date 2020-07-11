# KotlinBase
Clean Architecture 적용해보기

* 모듈 나눠서 구현
* 테스트 코드 작성해보

## Module

### Data
> DataSource, Repository, API 통신, Preference, Room

* 레파지토리 패턴 구현
* Retrofit 을 사용한 API 통신
* Room 을 사용해서 Local DB 구성 및 컨트롤
* Preference 조작 구현

### Model
> 앱에서 사용할 데이터 클래스 모음

* Entity 들의 모임

*Result*
- API 응답에서 성공과 에러를 구분하고 ViewModel 에서도 Result 상태에 따라 결과 처리를 쉽게 할 수 있도록 추가

*Mapper*
- 추후에 필요한 부분만 캐시하기 위해 맵퍼 추가


## Using Library
* Dagger - dependency injection

* Dagger -> Hilt 마이그레이션 하기
    * https://codelabs.developers.google.com/codelabs/android-dagger-to-hilt/#0
    * https://developer.android.com/training/dependency-injection/hilt-android

* Arch - architecture component
 - Lifecycle
 - Room

* Retrofit - api networking
* Glide - image loader
* Timber - logger
* Coroutines

* ThreeTenABP
    * https://github.com/JakeWharton/ThreeTenABP

* RxJava 3
    * https://github.com/ReactiveX/RxJava/wiki/What's-different-in-3.0



## Todo
* Preference 구현
* API 공통 처리 구현
* API 서비스 구현기


## 테스트
* MockWebServer 구현 해보기
* UI 테스트 구현 해보기(esspresso)
* 뷰모델 테스트 구현 해보기