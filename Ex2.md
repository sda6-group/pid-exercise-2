###Description
Imagine that you have many types of protein bars and you are required to take this bars and make it easier for people to find their specific goals. Some of them are maybe interested to eat as much protein (Bodybuilder players I guess) as they can and some of them are interested about eating kolhydrat and so on.
You will have the protein bars information represented in XML file.


###Task
Write Java code with the following functionality:
   Extract the information into a data structure of ur choice.
   After that give the user the ability to choose from  
           -  Show all the bars in a good way of ur choice
           -  Sort based on highest Protein ( Ex: 1- 36g , 2- 30g ,3- 10g)
           -  Sort based on highest Fett
           -  Filter bars which has less than “some number from the user” fiber and sort them from    highest to lowest.
   
  
###Open question
Imagine that you have a very large database. How do you think that the memory will behave with the database if u save it in a data structure ? Are there any problems? If yes, then how to fix it. 
What is the time complexity of ur sorting algorithm? Can it be improved?
What is the best data structure to be used in this situation. Motivate!


###Database
The database will look like this:
<products>
	<barebellsProteinBar>
		<fett>14.4</fett>
		<energi>1510</energi>
		<kolhydrat>25.4</kolhydrat>
		<protein>36</protein>
		<fiber>7.9</fiber>
	</barebellsProteinBar>
</products>




