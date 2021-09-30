# Windows - Arch Linux 멀티부팅 세팅방법

디스크 파티션 만들기
---
드라이브가 한개라고 가정할떄, Windows와 Linux가 한 드라이브에 설치되기 위해서는

파티션의 구분이 필요하다.

1. Windows에서 디스크 관리 > 디스크 0의 볼륨을 축소한다.
2. 최소 10기가정도의 공간을 축소해 할당되지 않은 파티션을 만든다.

> GPT vs MBR 차이 이해하기.
>
>> GPT : GUID Partition Table
>> 
>> MBR : Master Boot Record
> 
> GPT가 조금 최신의 하드디스크 구성 방식이며, MBR은 보통 2TB 미만의 하드디스크에서 사용되는 구조이다.
> 
> MBR과 GPT 파티션 구성 방식의 가장 큰 차이점은 주 파티션의 최대 가수이며, MBR은 최대 4개, 
> 
> GPT는 최대 128개라고는 하지만 명확한 제한은 없는 것으로 보인다.
> 
> 여기서 중요한 점은, Windows가 Primary partition을 세개, Linux 또한 Primary partition을 세개
>
> 차지하므로, Windows가 이미 깔려있는 MBR 형식의 하드디스크에는 Linux를 이용한 멀티부팅이 불가능하다!
>
> MBR형식을 GPT형식으로 바꿀 수 있으나, 이는 디스크 포맷을 필요로 하므로 포맷을 할 여분의 컴퓨터가 필요하다.
>
디스크 이미지 파일 다운받기
---
[ArchLinux](https://archlinux.org/download/) 사이트에서 디스크 이미지 파일(.iso) 파일을 다운받는다. 대략 600MB 정도.

설치 USB 만들기
---
[Rufus](https://rufus.ie/ko/) 를 다운받은 뒤, 설치파일을 Rufus 를 이용해 USB로 전달하여 포맷과 동시에 설치 USB를 만든다.

> 이때, 파티션 방식이 MBR이 아닌 GPT로 되어있어야 BIOS 모드가 아닌 UEFI 모드에서 실행되는데,
> 
> UEFI는 대부분의 메인보드 제조사에서 제공하므로 문제가 없으나, MBR이 설치된 운영체제 (x86) 에서는 GPT 파티션 방식으로 포맷이 불가능하므로 64비트 운영체제에서 GPT 파티션 방식으로 설치하여야 한다.

메인보드 옵션 세팅하기
---
USB를 꽂은 후, 부팅시 F2 (메인보드 제조사별로 상이) 하여 BIOS 설정에 들어가면

부팅 순서를 정할 수 있는 옵션이 있는데, 삽입한 USB의 순위를 윈도우가 설치된 하드디스크보다 높은 순위에 둔다.

(추가) Fast Boot 설정이 있다면 이를 끈다.

이후 설정 저장뒤 재부팅한다.

Arch Linux 설치하기
---

재부팅을 한뒤, 나오는 첫 화면이
![image](https://blog.kakaocdn.net/dn/dbpmDq/btq7Y7y3ZE4/hRBkUZWWXNZYqBTZwW0qxK/img.png)
위와 같다면, 이는 BIOS 설치 모드이며,

![image2](https://blog.kakaocdn.net/dn/CuPsY/btq6p8ZKg80/zAdki0v7SKt38zXm6atCK0/img.png)
위와 같다면 이는 UEFI 설치 모드이다.

여기서는 UEFI 모드 설치 기준으로 설명을 진행할 것이다.

[ArchLinux 공식 사이트 설치 가이드](https://wiki.archlinux.org/title/installation_guide) 에 따르면, ping 명령어를 이용해 인터넷 연결을 확인하고,

/sys/firmware/efi/efivars 디렉토리가 존재하는지를 통해 UEFI 모드인것을 확인하라고 권장한다.


