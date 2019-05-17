This project was made with the collaboration of 2 CSC171 students:
Names: Bahawar Dhillon(Net ID: bdhillon)
	   Darman Khan  (Net ID: dkhan2)
	   
	   
User's Guide: Enter an angle, speed and time delay for the firework and select a color and type from the dropdown menus. Click "launch" to launch the projectile. 
	   
The program builds a firework display by making use of GUI. The user enters the speed and the angle at which the firework projectile is launched and the time delay 
for the explosion. Using the equations provided the x and y positions are calculated for the projected using time as a parameter. These x and y positions are 
calculated using a for loop which also plots a line between the current and previous position over small increments of time. This method is used to draw the 
trajectory of the projectile. 

User's Guide: Enter an angle, speed and time delay for the firework and select a color and type from the dropdown menus. Click "launch" to launch the projectile. 
	   
The program builds a firework display by making use of GUI. The user enters the speed and the angle at which the firework projectile is launched and the time delay 
for the explosion. Using the equations provided the x and y positions are calculated for the projected using time as a parameter. These x and y positions are 
calculated using a for loop which also plots a line between the current and previous position over small increments of time. This method is used to draw the 
trajectory of the projectile. 
In the Project03Main Class three JLabels along with JTextFields are used for angle, velocity, time and two JComboBox  for colors and explosion types. A JButton 
“Launch” launches the firework. These are all added to a JPanel along with an instance of the Canvas_1 class which draws the projectile. The BorderLayout option 
is used to set the layout. The actionPerformed method in the Project03Main class is used to collect input from the text fields and Combo boxes and using the setter 
methods in the canvas class they change the values of the velocity, angle, time, color and explosion type to the detected input. In the canvas class six explosion 
types are created, a string “BOOM”, a spider web, a pattern of concentric circles, an explosion pattern, flower petals and a spiral ring. 

Extra credit:
A seventh explosion type “G” is created so that after the original firework completes its trajectory the projectile breaks into smaller pieces which shoot off in 
different directions as separate projectiles and explode separately. This is achieved through for loops.
 