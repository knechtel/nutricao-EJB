# nutricao-EJB

configure datasource wildfly


> prerequisite
make sure that you heve mysql server installed and one schema test created.

https://www.youtube.com/watch?v=xSHXMcRsF0A

[![Watch the video](https://raw.github.com/GabLeRoux/WebMole/master/ressources/WebMole_Youtube_Video.png)](https://www.youtube.com/watch?v=xSHXMcRsF0A)


1)Perspective JEE select Project Explorer then click right button and select import

2)Choose >Git>Project from Git

3)Maven>Update Project

4)click right button on project nutricao-WEB >Properties then >Project Reference select nutricao-EJB

5)Make a project nutricao-EAR



<br>
<img src='https://4.bp.blogspot.com/-Zv6p0J5tEZ4/WqoPo7-jh1I/AAAAAAAADLA/G-3AYh_rdigrqOXWgGnVOdtRYW8W2X2iQCLcBGAs/s1600/Screen%2BShot%2B2018-03-15%2Bat%2B03.13.44.png'/>
</br>

6)select project nutricao-WEB and nutricao-EJB




<br>
<img src='https://3.bp.blogspot.com/-KRsidrqAtQI/WqoWOhzJQvI/AAAAAAAADLc/bSfFOoAItoMyM4UgeIO2qQPJAIyiSv95ACLcBGAs/s1600/Screen%2BShot%2B2018-03-15%2Bat%2B03.43.23.png'/>
</br>


7)Now we access this url http://localhost:8080/nutricao-WEB/test.jsf

look the database and make sure that we have one user inserted in database.
