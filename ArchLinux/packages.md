# 설치한 패키지들

vim
---
주로 사용하는 텍스트 편집기.

개인적으로 사용하는 config는 다음과 같다 (~/.vimrc)
```vimrc
set number
set expandtab
set tabstop = 4
``` 

git
---
git 관리자. 세부사항은 위키 참조


curl, wget
---
파일 다운로드하는데 쓰인다. 개인적으로는 wget을 주로 사용.

openssh
---
ssh연결을 하는데 사용된다. 다른 컴퓨터에 접속을 할수도, 서버를 만들수도 있다.

```
$ sudo systemctl status sshd        # 서버 상태 확인
$ sudo systemctl start/stop sshd    # 서버 시작/중지
$ sudo systemctl enable/disable sshd # 부팅시 서버시작/시작안함
```

sshd 설정 ( /etc/ssh/sshd_config )
```
# 많은 설정값들이 있으나, 주로 사용하는 옵션 두개 :

Port 12345  #기본포트는 22로 설정, 보안에 취약할수있기에 바꿔준다
PermitRootLogin no # Root 권한으로 접속할수 있게 하려면 yes로 설정해준다
```

외부 서버에 접속 :
```
$ ssh -p PORT_NUMBER USERNAME$Addr
```
와 같은 형식으로 외부 서버에 접속 가능하다.