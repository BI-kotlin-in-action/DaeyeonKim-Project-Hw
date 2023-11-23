**LottoWeb API**

# Buy-Lotto
### 로또 자동 구매
* **URL**
    * /api/lotto/buy-lottos/auto
* **Method:**
    *  `POST`
* **Data Params**
  * **Required:**
    * `userId=[Long]`
    * `autoLottoCount=[Integer]`
* **Success Response:**
  ** Code: 200 **
* **Error Response:**
  * Code: 500 : "잔액이 부족합니다"

###  로또 수동 구매
* **URL**
  * /api/lotto/buy-lottos/manual
* **Method:**
  *  `POST`
*  **Data Params**
    * `userId=[Long]`
    * `manulLottoCount=[Integer]`
    * `manualLottoNumbers=[List<List<Integer>>]`
* **Success Response:**
  ** Code: 200 **
* **Error Response:**
  * Code: 500 : "잔액이 부족합니다" 

# Bank
### 입금
* **URL**
  * /api/bank/{userId}/deposit/{money}
* **Method:**
  *  `PUT`
* **URL Params**
  * **Required:**
    * `userId=[Long]`
    * `money=[Integer]`
* **Success Response:**
  ** Code: 200 **

### 출금
* **URL**
  * /api/bank/{userId}/withdraw/{money}
* **Method:**
  *  `PUT`
* **URL Params**
  * **Required:**
    * `userId=[Long]`
    * `money=[Integer]`
* **Success Response:**
  ** Code: 200 **
* **Error Response:**
  * Code: 500 : "잔액이 부족합니다" 
### 잔액 조회
* **URL**
  * /api/bank/{userId}/balance
* **Method:**
  *  `GET`
* **Path Params**
  * **Required:**
    * `userId=[Long]`
* **Success Response:**
  ** Code: 200 ** : 잔액(Integer)

# ScoringSystem
### 결과 조회
* **URL**
  * /api/scoring-system/{userId}/check-results
* **Method:**
* `PUT`
* **Path Params**
  * **Required:**
    * `userId=[Long]`
* **Success Response:**
  ** Code: 200 ** : 상금, 결과(List<Rank>)

# UserController
### 회원가입
* **URL**
  * /api/users/join
  * **Method:**
  * `POST`
* **Success Response:**
  ** Code: 200 ** : "id" : #, "money" : 0

#WinningLotto
### 당첨 번호 조회
* **URL**
    * /api/winning-lotto/history/{id}
* **Method:**
* `GET`
* **Path Params**
  * **Required:**
    * `id=[Long]` : 회차
  * **Success Response:**
  * ** Code: 200 ** : 당첨 번호(List<Integer>)
  * **Error Response:**
    * Code: 500 : "아직 공개되지 않은 당첨번호입니다."
