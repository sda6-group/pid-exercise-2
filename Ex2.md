### Description<br>
Imagine that you have many types of protein bars and you are required to present these bars to make it easier for people to reach their nutritional goals. Some of them might be interested in eating as much protein as they can (bodybuilders, I guess) and some of them might be interested in eating carbohydrates as well and so on. At your disposal you have the information about the protein bars represented in an XML file [`bars.xml`](bars.xml).


### Task<br>
Write Java code with the following functionality(Text Interface Program as the IP Project):<br>
   Extract the information into a data structure of ur choice.<br>
   After that give the user the ability to choose from:  <br>
   <ul>
     <li> Show the name of all bars. </li>
        <li> Sort based on highest Protein ( Ex: 1- 36g , 2- 30g ,3- 10g). </li>
          <li>Sort based on highest Fett. </li>
          <li> Filter bars which has less than “some number from the user” fiber and sort them from highest to lowest.</li>
           <li>Find all protein bars with more than X protein reviewed by Y (X and Y should be entered from the user).</li>
</ul>
  
### Open question<br>
Imagine that you have a very large database. How do you think that the memory will behave with the database if u save it in a data structure ? Are there any problems? If yes, then how to fix it.<br>
What is the best sort algorithm to be used here and what is its time complexity. Motivate!<br>


### Database<br>
The database will look like this:
```xml
<products>
    	<ILSAHBAR  SN="VyfdmYr">
		<fett>27.19</fett>
		<energy>1288.07</energy>
		<kolhydrat>25.96</kolhydrat>
		<protein>39.49</protein>
		<fiber>44.04</fiber>
		<review>
			<reviewer personID="PJ8">
				<date>2014-02-11</date>
				<score>4</score>
			</reviewer>   
		</review>
	</ILSAHBAR>


	<OHRITBAR  SN="pQEk83O">
		<fett>6.14</fett>
		<energy>2426.02</energy>
		<kolhydrat>1.4</kolhydrat>
		<protein>23.45</protein>
		<fiber>17.21</fiber>
		<review>
			<reviewer personID="k6Y">
				<date>2000-10-09</date>
				<score>5</score>
			</reviewer>
			<reviewer personID="k6p">
				<date>2000-10-09</date>
				<score>5</score>
			</reviewer>
		</review>
	</OHRITBAR>   
</products>
```




