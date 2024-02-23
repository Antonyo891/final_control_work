antonyo891@Linux:~/final_work$ cat > Pets.txt 
Cats, Dogs, Hamsters
antonyo891@Linux:~/final_work$ cat Pets.txt 
Cats, Dogs, Hamsters
antonyo891@Linux:~/final_work$ cat > Pack_Animals.txt 
horses, camels, donkey
antonyo891@Linux:~/final_work$ cat Pack_Animals.txt 
horses, camels, donkey
antonyo891@Linux:~/final_work$ cat Pack_Animals.txt Pets.txt > Humans_Friends.txt
antonyo891@Linux:~/final_work$ cat Humans_Friends.txt
horses, camels, donkey
Cats, Dogs, Hamsters
antonyo891@Linux:~/final_work$ mv Humans_Friends.txt Peoples_friends
antonyo891@Linux:~/final_work$ ls
Pack_Animals.txt  Peoples_friends  Pets.txt
antonyo891@Linux:~/final_work$ cat Peoples_friends 
horses, camels, donkey
Cats, Dogs, Hamsters
antonyo891@Linux:~/final_work$ mkdir $pwd Files
antonyo891@Linux:~/final_work$ ls
Files  Pack_Animals.txt  Peoples_friends  Pets.txt
antonyo891@Linux:~/final_work$ mv Peoples_friends Peoples_friends.txt
antonyo891@Linux:~/final_work$ mv Peoples_friends.txt /home/antonyo891/final_work/Files/
antonyo891@Linux:~/final_work$ ls
Files  Pack_Animals.txt  Pets.txt
antonyo891@Linux:~/final_work$ ls Files/
Peoples_friends.txt
antonyo891@Linux:~/final_work$ wget https://dev.mysql.com/get/mysql-apt-config_0.8.29-1_all.deb
--2024-02-23 16:42:38--  https://dev.mysql.com/get/mysql-apt-config_0.8.29-1_all.deb
Resolving dev.mysql.com (dev.mysql.com)... 104.87.162.217, 2a02:2d8:3:9a5::2e31, 2a02:2d8:3:9a9::2e31
Connecting to dev.mysql.com (dev.mysql.com)|104.87.162.217|:443... connected.
HTTP request sent, awaiting response... 302 Moved Temporarily
Location: https://repo.mysql.com//mysql-apt-config_0.8.29-1_all.deb [following]
--2024-02-23 16:42:39--  https://repo.mysql.com//mysql-apt-config_0.8.29-1_all.deb
Resolving repo.mysql.com (repo.mysql.com)... 104.81.113.179, 2a02:26f0:d200:888::1d68, 2a02:26f0:d200:889::1d68
Connecting to repo.mysql.com (repo.mysql.com)|104.81.113.179|:443... connected.
HTTP request sent, awaiting response... 200 OK
Length: 18172 (18K) [application/x-debian-package]
Saving to: ‘mysql-apt-config_0.8.29-1_all.deb’

mysql-apt-config_0.8.29-1 100%[==================================>]  17,75K  --.-KB/s    in 0,001s  

2024-02-23 16:42:39 (32,7 MB/s) - ‘mysql-apt-config_0.8.29-1_all.deb’ saved [18172/18172]

antonyo891@Linux:~/final_work$ ls
Files  mysql-apt-config_0.8.29-1_all.deb  Pack_Animals.txt  Pets.txt
antonyo891@Linux:~/final_work$ sudo dpkg -i mysql-apt-config_0.8.29-1_all.deb 
[sudo] password for antonyo891: 
(Reading database ... 193367 files and directories currently installed.)
Preparing to unpack mysql-apt-config_0.8.29-1_all.deb ...
Unpacking mysql-apt-config (0.8.29-1) over (0.8.14-1) ...
Setting up mysql-apt-config (0.8.29-1) ...
antonyo891@Linux:~/final_work$ sudo apt update 
Hit:1 http://by.archive.ubuntu.com/ubuntu jammy InRelease
Hit:2 http://by.archive.ubuntu.com/ubuntu jammy-updates InRelease                                   
Hit:3 http://by.archive.ubuntu.com/ubuntu jammy-backports InRelease                                 
Hit:4 http://security.ubuntu.com/ubuntu jammy-security InRelease                                    
Get:5 http://repo.mysql.com/apt/ubuntu jammy InRelease [20,2 kB]                                    
Hit:6 https://download.docker.com/linux/ubuntu jammy InRelease                                      
Get:7 http://repo.mysql.com/apt/ubuntu jammy/mysql-8.0 Sources [964 B]                              
Get:8 http://repo.mysql.com/apt/ubuntu jammy/mysql-apt-config amd64 Packages [566 B]                
Get:9 http://repo.mysql.com/apt/ubuntu jammy/mysql-apt-config i386 Packages [566 B]
Get:10 http://repo.mysql.com/apt/ubuntu jammy/mysql-8.0 amd64 Packages [14,6 kB]
Get:11 http://repo.mysql.com/apt/ubuntu jammy/mysql-tools amd64 Packages [4.123 B]
Get:12 http://repo.mysql.com/apt/ubuntu jammy/mysql-tools i386 Packages [458 B]
Fetched 41,5 kB in 14s (2.993 B/s) 
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
63 packages can be upgraded. Run 'apt list --upgradable' to see them.
antonyo891@Linux:~/final_work$ sudo apt install mysql-server
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
The following additional packages will be installed:
  libaio1 libmecab2 mecab-ipadic mecab-ipadic-utf8 mecab-utils mysql-client mysql-common
  mysql-community-client mysql-community-client-core mysql-community-client-plugins
  mysql-community-server mysql-community-server-core
The following NEW packages will be installed:
  libaio1 libmecab2 mecab-ipadic mecab-ipadic-utf8 mecab-utils mysql-client mysql-common
  mysql-community-client mysql-community-client-core mysql-community-client-plugins
  mysql-community-server mysql-community-server-core mysql-server
0 upgraded, 13 newly installed, 0 to remove and 63 not upgraded.
Need to get 37,9 MB of archives.
After this operation, 273 MB of additional disk space will be used.
Do you want to continue? [Y/n] y
Get:1 http://by.archive.ubuntu.com/ubuntu jammy/main amd64 libaio1 amd64 0.3.112-13build1 [7.176 B]
Get:2 http://by.archive.ubuntu.com/ubuntu jammy/main amd64 libmecab2 amd64 0.996-14build9 [199 kB]
Get:3 http://by.archive.ubuntu.com/ubuntu jammy/main amd64 mecab-utils amd64 0.996-14build9 [4.850 B]
Get:4 http://by.archive.ubuntu.com/ubuntu jammy/main amd64 mecab-ipadic all 2.7.0-20070801+main-3 [6.718 kB]
Get:5 http://repo.mysql.com/apt/ubuntu jammy/mysql-8.0 amd64 mysql-common amd64 8.0.36-1ubuntu22.04 [67,9 kB]
Get:6 http://repo.mysql.com/apt/ubuntu jammy/mysql-8.0 amd64 mysql-community-client-plugins amd64 8.0.36-1ubuntu22.04 [1.443 kB]
Get:7 http://repo.mysql.com/apt/ubuntu jammy/mysql-8.0 amd64 mysql-community-client-core amd64 8.0.36-1ubuntu22.04 [2.126 kB]
Get:8 http://by.archive.ubuntu.com/ubuntu jammy/main amd64 mecab-ipadic-utf8 all 2.7.0-20070801+main-3 [4.384 B]
Get:9 http://repo.mysql.com/apt/ubuntu jammy/mysql-8.0 amd64 mysql-community-client amd64 8.0.36-1ubuntu22.04 [2.199 kB]
Get:10 http://repo.mysql.com/apt/ubuntu jammy/mysql-8.0 amd64 mysql-client amd64 8.0.36-1ubuntu22.04 [66,6 kB]
Get:11 http://repo.mysql.com/apt/ubuntu jammy/mysql-8.0 amd64 mysql-community-server-core amd64 8.0.36-1ubuntu22.04 [24,9 MB]
Get:12 http://repo.mysql.com/apt/ubuntu jammy/mysql-8.0 amd64 mysql-community-server amd64 8.0.36-1ubuntu22.04 [78,4 kB]
Get:13 http://repo.mysql.com/apt/ubuntu jammy/mysql-8.0 amd64 mysql-server amd64 8.0.36-1ubuntu22.04 [66,6 kB]
Fetched 37,9 MB in 9s (4.012 kB/s)                                                                  
Preconfiguring packages ...
Selecting previously unselected package mysql-common.
(Reading database ... 193367 files and directories currently installed.)
Preparing to unpack .../00-mysql-common_8.0.36-1ubuntu22.04_amd64.deb ...
Unpacking mysql-common (8.0.36-1ubuntu22.04) ...
Selecting previously unselected package mysql-community-client-plugins.
Preparing to unpack .../01-mysql-community-client-plugins_8.0.36-1ubuntu22.04_amd64.deb ...
Unpacking mysql-community-client-plugins (8.0.36-1ubuntu22.04) ...
Selecting previously unselected package mysql-community-client-core.
Preparing to unpack .../02-mysql-community-client-core_8.0.36-1ubuntu22.04_amd64.deb ...
Unpacking mysql-community-client-core (8.0.36-1ubuntu22.04) ...
Selecting previously unselected package mysql-community-client.
Preparing to unpack .../03-mysql-community-client_8.0.36-1ubuntu22.04_amd64.deb ...
Unpacking mysql-community-client (8.0.36-1ubuntu22.04) ...
Selecting previously unselected package mysql-client.
Preparing to unpack .../04-mysql-client_8.0.36-1ubuntu22.04_amd64.deb ...
Unpacking mysql-client (8.0.36-1ubuntu22.04) ...
Selecting previously unselected package libaio1:amd64.
Preparing to unpack .../05-libaio1_0.3.112-13build1_amd64.deb ...
Unpacking libaio1:amd64 (0.3.112-13build1) ...
Selecting previously unselected package libmecab2:amd64.
Preparing to unpack .../06-libmecab2_0.996-14build9_amd64.deb ...
Unpacking libmecab2:amd64 (0.996-14build9) ...
Selecting previously unselected package mysql-community-server-core.
Preparing to unpack .../07-mysql-community-server-core_8.0.36-1ubuntu22.04_amd64.deb ...
Unpacking mysql-community-server-core (8.0.36-1ubuntu22.04) ...
Selecting previously unselected package mysql-community-server.
Preparing to unpack .../08-mysql-community-server_8.0.36-1ubuntu22.04_amd64.deb ...
Unpacking mysql-community-server (8.0.36-1ubuntu22.04) ...
Selecting previously unselected package mecab-utils.
Preparing to unpack .../09-mecab-utils_0.996-14build9_amd64.deb ...
Unpacking mecab-utils (0.996-14build9) ...
Selecting previously unselected package mecab-ipadic.
Preparing to unpack .../10-mecab-ipadic_2.7.0-20070801+main-3_all.deb ...
Unpacking mecab-ipadic (2.7.0-20070801+main-3) ...
Selecting previously unselected package mecab-ipadic-utf8.
Preparing to unpack .../11-mecab-ipadic-utf8_2.7.0-20070801+main-3_all.deb ...
Unpacking mecab-ipadic-utf8 (2.7.0-20070801+main-3) ...
Selecting previously unselected package mysql-server.
Preparing to unpack .../12-mysql-server_8.0.36-1ubuntu22.04_amd64.deb ...
Unpacking mysql-server (8.0.36-1ubuntu22.04) ...
Setting up libmecab2:amd64 (0.996-14build9) ...
Setting up mysql-common (8.0.36-1ubuntu22.04) ...
update-alternatives: using /etc/mysql/my.cnf.fallback to provide /etc/mysql/my.cnf (my.cnf) in auto m
ode
Setting up mecab-utils (0.996-14build9) ...
Setting up mysql-community-client-plugins (8.0.36-1ubuntu22.04) ...
Setting up libaio1:amd64 (0.3.112-13build1) ...
Setting up mecab-ipadic (2.7.0-20070801+main-3) ...
Compiling IPA dictionary for Mecab.  This takes long time...
reading /usr/share/mecab/dic/ipadic/unk.def ... 40
emitting double-array: 100% |###########################################| 
/usr/share/mecab/dic/ipadic/model.def is not found. skipped.
reading /usr/share/mecab/dic/ipadic/Symbol.csv ... 208
reading /usr/share/mecab/dic/ipadic/Noun.proper.csv ... 27328
reading /usr/share/mecab/dic/ipadic/Noun.name.csv ... 34202
reading /usr/share/mecab/dic/ipadic/Auxil.csv ... 199
reading /usr/share/mecab/dic/ipadic/Conjunction.csv ... 171
reading /usr/share/mecab/dic/ipadic/Noun.adjv.csv ... 3328
reading /usr/share/mecab/dic/ipadic/Others.csv ... 2
reading /usr/share/mecab/dic/ipadic/Noun.adverbal.csv ... 795
reading /usr/share/mecab/dic/ipadic/Noun.csv ... 60477
reading /usr/share/mecab/dic/ipadic/Interjection.csv ... 252
reading /usr/share/mecab/dic/ipadic/Postp-col.csv ... 91
reading /usr/share/mecab/dic/ipadic/Noun.number.csv ... 42
reading /usr/share/mecab/dic/ipadic/Filler.csv ... 19
reading /usr/share/mecab/dic/ipadic/Noun.place.csv ... 72999
reading /usr/share/mecab/dic/ipadic/Prefix.csv ... 221
reading /usr/share/mecab/dic/ipadic/Adnominal.csv ... 135
reading /usr/share/mecab/dic/ipadic/Adverb.csv ... 3032
reading /usr/share/mecab/dic/ipadic/Postp.csv ... 146
reading /usr/share/mecab/dic/ipadic/Noun.nai.csv ... 42
reading /usr/share/mecab/dic/ipadic/Noun.demonst.csv ... 120
reading /usr/share/mecab/dic/ipadic/Noun.org.csv ... 16668
reading /usr/share/mecab/dic/ipadic/Noun.verbal.csv ... 12146
reading /usr/share/mecab/dic/ipadic/Noun.others.csv ... 151
reading /usr/share/mecab/dic/ipadic/Verb.csv ... 130750
reading /usr/share/mecab/dic/ipadic/Adj.csv ... 27210
reading /usr/share/mecab/dic/ipadic/Suffix.csv ... 1393
emitting double-array: 100% |###########################################| 
reading /usr/share/mecab/dic/ipadic/matrix.def ... 1316x1316
emitting matrix      : 100% |###########################################| 

done!
update-alternatives: using /var/lib/mecab/dic/ipadic to provide /var/lib/mecab/dic/debian (mecab-dict
ionary) in auto mode
Setting up mysql-community-client-core (8.0.36-1ubuntu22.04) ...
Setting up mysql-community-server-core (8.0.36-1ubuntu22.04) ...
Setting up mecab-ipadic-utf8 (2.7.0-20070801+main-3) ...
Compiling IPA dictionary for Mecab.  This takes long time...
reading /usr/share/mecab/dic/ipadic/unk.def ... 40
emitting double-array: 100% |###########################################| 
/usr/share/mecab/dic/ipadic/model.def is not found. skipped.
reading /usr/share/mecab/dic/ipadic/Symbol.csv ... 208
reading /usr/share/mecab/dic/ipadic/Noun.proper.csv ... 27328
reading /usr/share/mecab/dic/ipadic/Noun.name.csv ... 34202
reading /usr/share/mecab/dic/ipadic/Auxil.csv ... 199
reading /usr/share/mecab/dic/ipadic/Conjunction.csv ... 171
reading /usr/share/mecab/dic/ipadic/Noun.adjv.csv ... 3328
reading /usr/share/mecab/dic/ipadic/Others.csv ... 2
reading /usr/share/mecab/dic/ipadic/Noun.adverbal.csv ... 795
reading /usr/share/mecab/dic/ipadic/Noun.csv ... 60477
reading /usr/share/mecab/dic/ipadic/Interjection.csv ... 252
reading /usr/share/mecab/dic/ipadic/Postp-col.csv ... 91
reading /usr/share/mecab/dic/ipadic/Noun.number.csv ... 42
reading /usr/share/mecab/dic/ipadic/Filler.csv ... 19
reading /usr/share/mecab/dic/ipadic/Noun.place.csv ... 72999
reading /usr/share/mecab/dic/ipadic/Prefix.csv ... 221
reading /usr/share/mecab/dic/ipadic/Adnominal.csv ... 135
reading /usr/share/mecab/dic/ipadic/Adverb.csv ... 3032
reading /usr/share/mecab/dic/ipadic/Postp.csv ... 146
reading /usr/share/mecab/dic/ipadic/Noun.nai.csv ... 42
reading /usr/share/mecab/dic/ipadic/Noun.demonst.csv ... 120
reading /usr/share/mecab/dic/ipadic/Noun.org.csv ... 16668
reading /usr/share/mecab/dic/ipadic/Noun.verbal.csv ... 12146
reading /usr/share/mecab/dic/ipadic/Noun.others.csv ... 151
reading /usr/share/mecab/dic/ipadic/Verb.csv ... 130750
reading /usr/share/mecab/dic/ipadic/Adj.csv ... 27210
reading /usr/share/mecab/dic/ipadic/Suffix.csv ... 1393
emitting double-array: 100% |###########################################| 
reading /usr/share/mecab/dic/ipadic/matrix.def ... 1316x1316
emitting matrix      : 100% |###########################################| 

done!
update-alternatives: using /var/lib/mecab/dic/ipadic-utf8 to provide /var/lib/mecab/dic/debian (mecab
-dictionary) in auto mode
Setting up mysql-community-client (8.0.36-1ubuntu22.04) ...
Setting up mysql-client (8.0.36-1ubuntu22.04) ...
Setting up mysql-community-server (8.0.36-1ubuntu22.04) ...
update-alternatives: using /etc/mysql/mysql.cnf to provide /etc/mysql/my.cnf (my.cnf) in auto mode
Created symlink /etc/systemd/system/multi-user.target.wants/mysql.service > /lib/systemd/system/mysql
.service.
Setting up mysql-server (8.0.36-1ubuntu22.04) ...
Processing triggers for man-db (2.10.2-1) ...
Processing triggers for libc-bin (2.35-0ubuntu3.6) ...
antonyo891@Linux:~/final_work$
antonyo891@Linux:~/final_work$ wget http://archive.ubuntu.com/ubuntu/pool/universe/n/nginx/nginx-full_1.18.0-6ubuntu14.4_amd64.deb
--2024-02-23 17:26:44--  http://archive.ubuntu.com/ubuntu/pool/universe/n/nginx/nginx-full_1.18.0-6ubuntu14.4_amd64.deb
Resolving archive.ubuntu.com (archive.ubuntu.com)... 185.125.190.39, 91.189.91.82, 91.189.91.81, ...
Connecting to archive.ubuntu.com (archive.ubuntu.com)|185.125.190.39|:80... connected.
HTTP request sent, awaiting response... 200 OK
Length: 4342 (4,2K) [application/x-debian-package]
Saving to: ‘nginx-full_1.18.0-6ubuntu14.4_amd64.deb’

nginx-full_1.18.0-6ubuntu 100%[==================================>]   4,24K  --.-KB/s    in 0s      

2024-02-23 17:26:44 (36,0 MB/s) - ‘nginx-full_1.18.0-6ubuntu14.4_amd64.deb’ saved [4342/4342]

antonyo891@Linux:~/final_work$ ls
Files                              nginx-full_1.18.0-6ubuntu14.4_amd64.deb  Pets.txt
mysql-apt-config_0.8.29-1_all.deb  Pack_Animals.txt
antonyo891@Linux:~/final_work$ dpkg -i nginx-full_1.18.0-6ubuntu14.4_amd64.deb 
dpkg: error: requested operation requires superuser privilege
antonyo891@Linux:~/final_work$ sudo !!
sudo dpkg -i nginx-full_1.18.0-6ubuntu14.4_amd64.deb 
[sudo] password for antonyo891: 
Selecting previously unselected package nginx-full.
(Reading database ... 193726 files and directories currently installed.)
Preparing to unpack nginx-full_1.18.0-6ubuntu14.4_amd64.deb ...
Unpacking nginx-full (1.18.0-6ubuntu14.4) ...
dpkg: dependency problems prevent configuration of nginx-full:
 nginx-full depends on libnginx-mod-http-auth-pam; however:
  Package libnginx-mod-http-auth-pam is not installed.
 nginx-full depends on libnginx-mod-http-dav-ext; however:
  Package libnginx-mod-http-dav-ext is not installed.
 nginx-full depends on libnginx-mod-http-echo; however:
  Package libnginx-mod-http-echo is not installed.
 nginx-full depends on libnginx-mod-http-geoip2; however:
  Package libnginx-mod-http-geoip2 is not installed.
 nginx-full depends on libnginx-mod-http-subs-filter; however:
  Package libnginx-mod-http-subs-filter is not installed.
 nginx-full depends on libnginx-mod-http-upstream-fair; however:
  Package libnginx-mod-http-upstream-fair is not installed.
 nginx-full depends on libnginx-mod-stream-geoip2; however:
  Package libnginx-mod-stream-geoip2 is not installed.
 nginx-full depends on nginx-core (>= 1.18.0-6ubuntu14.4); however:
  Package nginx-core is not installed.
 nginx-full depends on nginx-core (<< 1.18.0-6ubuntu14.4.1~); however:
  Package nginx-core is not installed.

dpkg: error processing package nginx-full (--install):
 dependency problems - leaving unconfigured
Errors were encountered while processing:
 nginx-full
antonyo891@Linux:~/final_work$ sudo dpkg -r nginx-full 
(Reading database ... 193729 files and directories currently installed.)
Removing nginx-full (1.18.0-6ubuntu14.4) ...
antonyo891@Linux:~/final_work$ 



