package arrays;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 * @author Keoagile Mafora (ST10457036)
 */
public class Task {
    private String name;
    private String surname;
    private String registeredUsername;
    private String registeredPassword;
    private String loginUsername;
    private String loginPassword;
    boolean valid;
    boolean validTwo;
    boolean validThree;
    String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()-[{}]:;',?/*~$^+=<>]).{8,}$";
    private final Pattern pattern = Pattern.compile(regex);

    //Getters
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getRegisteredUsername() {
        return registeredUsername;
    }

    public String getRegisteredPassword() {
        return registeredPassword;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public boolean isValid() {
        return valid;
    }

    public boolean isValidTwo() {
        return validTwo;
    }

    public boolean isValidThree() {
        return validThree;
    }

    public String getRegex() {
        return regex;
    }

    public Pattern getPattern() {
        return pattern;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setRegisteredUsername(String registeredUsername) {
        this.registeredUsername = registeredUsername;
    }

    public void setRegisteredPassword(String registeredPassword) {
        this.registeredPassword = registeredPassword;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void setValidTwo(boolean validTwo) {
        this.validTwo = validTwo;
    }

    public void setValidThree(boolean validThree) {
        this.validThree = validThree;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
    
    //For making sure that the username has a underscore(_) and less than 5 characters
    public boolean checkUserName(String registeredUsername)  {
        valid = (registeredUsername.contains("_") && (registeredUsername.length() < 6));
        
        return valid;
    }
    
    //For checking the password
    public boolean checkPasswordComplexity(String registeredPassword) {
        Matcher matching =pattern.matcher(registeredPassword);
        
        validTwo = matching.matches();
        
        return validTwo;
    }
    
    //Registering the password and username
    public void registerUser() {
        labelOne: {
            while(registeredPassword != null) {
                break labelOne;
            }
            if(registeredUsername != null) {
                while(!checkUserName(registeredUsername)) {
                    JOptionPane.showMessageDialog(null,"Username is incorrectly formated, "
                                                  + " please make sure that the username has an underscore(_) and has not ore than 5 charaters");
                registeredUsername = JOptionPane.showInputDialog("Please enter the username that meets the requirements");
                }
                
                if(checkUserName(registeredUsername)) {
                    JOptionPane.showMessageDialog(null, "Username is successfully captured");
                }
            }
        }
        if(registeredPassword == null) {
            return;
        }
        
        Matcher matcher = pattern.matcher(registeredPassword);
        
        while(!checkPasswordComplexity(registeredPassword)) {
                    JOptionPane.showMessageDialog(null,"Password is incorrectly formated, "
                                                  + " please make sure that the passwod has a special character,has more than 8 charaters, and has a number");
                registeredPassword = JOptionPane.showInputDialog("Please enter the password that meets the requirements");
                matcher = pattern.matcher(registeredPassword);
                }
                
                if(checkPasswordComplexity(registeredPassword)) {
                    JOptionPane.showMessageDialog(null, "Password is successfully captured");
                    JOptionPane.showMessageDialog(null, "You have successfully registered your account");
                }
    }
    
    //For login the user
    public boolean loginUser() {
        
        validThree = loginPassword.equals(registeredPassword) && loginUsername.equals(registeredUsername);
        
        return validThree;
    }
    
    //The status for the login
    public void returnLoginStatus() {
        while(!loginUser()) {
            JOptionPane.showMessageDialog(null,"Username or password is incorrect, please try again. ");
            loginUsername = JOptionPane.showInputDialog("Please re-enter your username");
            loginPassword = JOptionPane.showInputDialog("Please re-enter your password");
        }
        if (loginUser()) {
            JOptionPane.showMessageDialog(null, "Welcome back " + name + " " + surname);
        }
    }
    
    //Part 2
    
    private int sizery;
    private String[] taskNamery = new String [sizery];
    private String[] taskDescr = new String [sizery];
    private String[] developerDetail = new String [sizery];
    private String[] duration = new String [sizery];
    private int[] statusery = new int[sizery];
    private int totally;
    private int county;
    private String[] opt = {"To DO", "Done", "Doing" };
    private String choicery;
    
    //Getters

    public int getSizery() {
        return sizery;
    }

    public String[] getTaskNamery() {
        return taskNamery;
    }

    public String[] getTaskDescr() {
        return taskDescr;
    }

    public String[] getDeveloperDetail() {
        return developerDetail;
    }

    public String[] getDuration() {
        return duration;
    }

    public int getTotally() {
        return totally;
    }

    public int getCounty() {
        return county;
    }

    public String[] getOpt() {
        return opt;
    }

    public String getChoicery() {
        return choicery;
    }

    public int[] getStatusery() {
        return statusery;
    }
    

    //Setters
    public void setSizery(int sizery) {
        this.sizery = sizery;
    }

    public void setTaskNamery(String[] taskNamery) {
        this.taskNamery = taskNamery;
    }

    public void setTaskDescr(String[] taskDescr) {
        this.taskDescr = taskDescr;
    }

    public void setDeveloperDetail(String[] developerDetail) {
        this.developerDetail = developerDetail;
    }

    public void setDuration(String[] duration) {
        this.duration = duration;
    }

    public void setTotally(int totally) {
        this.totally = totally;
    }

    public void setCounty(int county) {
        this.county = county;
    }

    public void setOpt(String[] opt) {
        this.opt = opt;
    }

    public void setChoicery(String choicery) {
        this.choicery = choicery;
    }

    public void setStatusery(int[] statusery) {
        this.statusery = statusery;
    }
    
    //To check the task description
    public boolean checkTaskDescription(String taskDescr) {
        boolean valid = taskDescr.length() < 51 && taskDescr.length() > 0 ;
        return valid;
    }
    
    //To create the taks ID
    public String createTaskID() {
        
        String one = Character.toString(taskNamery[getCounty()].charAt(0));
        String two = Character.toString(taskNamery[getCounty()].charAt(1));
        String three =  Character.toString(developerDetail[getCounty()].charAt(developerDetail[getCounty()].length()-3));
        String four =  Character.toString(developerDetail[getCounty()].charAt(developerDetail[getCounty()].length()-2));
        String five =  Character.toString(developerDetail[getCounty()].charAt(developerDetail[getCounty()].length()-1));
        
        String taskID = one.toUpperCase() + two.toUpperCase() + ":" + county + ":" + three.toUpperCase() + four.toUpperCase() + five.toUpperCase();
        return taskID;
    }
    
    //To print the task details
    public String printTaskDetails() {
        
        String taskTet = "Status: " + opt[statusery[getCounty()]]
                        +"\nDeveloper: " + developerDetail[getCounty()]
                        +"\nTask Number: " + getCounty()+1
                        +"\nTask Name: " + taskNamery[getCounty()]
                        +"\nTask Description: " + taskDescr[getCounty()]
                        +"\nTask ID: " + createTaskID()
                        +"\nThe Duration: " + duration[getCounty()] + "Hours";
        
        return taskTet;
    }
    
    //The total hours of the task
    public int returnTotalHours() {
        return totally;
    }
    
    //For choosing the options
    public String verifyChoice() {
        while(choicery == null || !(choicery.equals("1")) && !(choicery.equals("2")) && !(choicery.equals("3")) && !(choicery.equals("4")) && !(choicery.equals("5")) && !(choicery.equals("6")) && !(choicery.equals("7")) && !(choicery.equals("8"))) {
         
        choicery = JOptionPane.showInputDialog("Please enter the following: "
                                              +"\n1) Add Task"
                                              +"\n2) Show Report"
                                              +"\n3) All tasks with (Done) "
                                              +"\n4) Task with Longest Duration"
                                              +"\n5) Search for Task"
                                              +"\n6) Search task by developer"
                                              +"\n7) Delete a task"
                                              +"\n8) QUIT!");
    }
        return choicery;
    }
    
    //verifying the task name
    public String verifyTaskName() {
        while(taskNamery[getCounty()].equals("") || taskNamery[getCounty()].length() < 2) {
            taskNamery[getCounty()] = JOptionPane.showInputDialog("Please make sure that you write the task name");
        }
        return taskNamery[getCounty()];
    }
    
    //Verifying the developer name
    public String verifyDeveloperName() {
        
        while(developerDetail[getCounty()].equals("") || developerDetail[getCounty()].length() < 3) {
            developerDetail[getCounty()] = JOptionPane.showInputDialog("Please make sure that you write the Developer name");
        }
        return developerDetail[getCounty()];
    }
    
    //Verifying the task duration
    public String verifyTaskDuration() {
        while (true) {
            try {
                Integer.parseInt(duration[getCounty()]);
                break;
            }
            
            catch (NumberFormatException e) {
                duration[getCounty()] = JOptionPane.showInputDialog("Enter the estimated duration of the task");
            }
        }
        return duration[getCounty()];
    }
    
}
