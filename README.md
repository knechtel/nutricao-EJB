# Portal Nutris (EJB)

Bakend/EJB of Portal Nutris Project

Technologies used: CDI, JSF, EJB, hibernate and Web server wildfly 11, DB MySql

1) Install MySQL 5.7 

- user="root"
- senha="",
- create schema *test*

2) Configure datasource on WildFly named "MySqlDS1". There are 3 ways to do it. Instructions: 

https://www.youtube.com/watch?v=xSHXMcRsF0A

[![Watch the video](https://raw.github.com/GabLeRoux/WebMole/master/ressources/WebMole_Youtube_Video.png)](https://www.youtube.com/watch?v=xSHXMcRsF0A)

3) On Eclipse, perspective Java EE, right-click anywhere in the Project Explorer > Import > Git > Project from Git. Enter the repo information

4) Right-click on the Project > Maven > Update Project

4) Right-click on the Project nutricao_web > Properties > Project Reference, select nutricao-EJB, choose apply and close

5) Create a new "Enterprise Application Project" type project named "nutricao-EAR"

<br>
<img src='https://4.bp.blogspot.com/-Zv6p0J5tEZ4/WqoPo7-jh1I/AAAAAAAADLA/G-3AYh_rdigrqOXWgGnVOdtRYW8W2X2iQCLcBGAs/s1600/Screen%2BShot%2B2018-03-15%2Bat%2B03.13.44.png'/>
</br>

6) Select project nutricao_web and nutricao-EJB

<br>
<img src='https://3.bp.blogspot.com/-KRsidrqAtQI/WqoWOhzJQvI/AAAAAAAADLc/bSfFOoAItoMyM4UgeIO2qQPJAIyiSv95ACLcBGAs/s1600/Screen%2BShot%2B2018-03-15%2Bat%2B03.43.23.png'/>
</br>

7) On a browser, access http://localhost:8080/nutricao_web/
