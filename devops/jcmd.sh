echo 'SSH CLIENT MobaXterm 12.3'
su user
ps ef | grep java  ### see java process
top -H -p <procecessID>
jcmd <processID> help



####
yum install sysstat
iostat 2 3 ##info IO opearation
iostat -t 2 20 ##show kb/s writing



#CoreFreq
sudo yum group install 'Development Tools' -y
git clone https://github.com/cyring/CoreFreq.git