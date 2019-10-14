iptables -I INPUT $i -p tcp -m state --state NEW -m tcp --dport 4242 -j ACCEPT  ###open port
