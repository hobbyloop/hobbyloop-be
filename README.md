# hobbyloop-be

## 하비루프 백엔드 저장소입니다.

- 스택
  - Spring
  - Jpa
  - MySQL


## 기능 구현시
1. 이슈 생성
   - 이슈명 : [category] 구현할 기능
   - ex. [CI/CD] pr 트리거시의 github action workflow 수정
2. 원격 레포 변경사항 불러오기
   - git checkout develop
   - git pull origin develop
3. 작업할 브랜치 생성
   - git checkout -b 'branchName'
   - 브랜치명은 '작업자'/'작업내용' 으로 생성
   - ex) git checkout -b dongmoo/user-login
   - 기능을 구현하면서 상세 내용 및 트러블 슈팅 등을 이슈에 작성
4. 작업 완료 후 원격 레포에 푸시
   - git commit -m 'commit message'
   - git push origin branchName
   - ex. git push origin dongmoo/user-login
5. pr 생성
   - 생성 시 comment 에 생성한 이슈 태그
   - 리뷰어에 본인을 제외한 작업자 추가
   > <img width="301" alt="스크린샷 2023-04-17 오후 9 15 23" src="https://user-images.githubusercontent.com/99455667/232482985-a2028064-9387-4924-afc3-9d045e0c03f1.png">
   - Assignees 에 본인 추가
   > <img width="317" alt="스크린샷 2023-04-17 오후 9 15 31" src="https://user-images.githubusercontent.com/99455667/232482995-740e0c8d-c516-4f87-861f-9f08e4201bfd.png">
   
