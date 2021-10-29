Termux 기본 사용법
---
Termux : 안드로이드 기기에서 리눅스 환경을 실행할수 있게 해주는 터미널 에뮬레이터.

아치리눅스에서 pacman -S, 우분투의 apt-get install 과 같이 패키지 매니저로 package를 쓴다. 

```shell
$ package install pkgname
```
안드로이드 역시 리눅스이므로 일반 리눅스와 같이 다양한 패키지들이 설치 가능하다.

vim은 물론, git, wget 등등을 설치해보았으며 openssh를 통해 로컬 네트워크 내에서 데스크탑과 연결할 수 있었다.

![image](https://i.ibb.co/qdLX7Ff/lnx.jpg)

(포트포워딩을 통해 외부 네트워크에서도 접속 가능할 것으로 보임)

기존 리눅스 환경과 동일한 사용환경을 위해 zsh과 oh-my-zsh, powerlevel10k 테마를 적용해보았고 모두 잘 동작함.

단, 오류인지는 모르겠으나  실행후 git clone 또는 package install이 안되는 경우가 자주 발생하는데, 이때

```shel해
$ package upgrade
```
를 통해 해결이 가능하다.

