package arrays;

import javax.swing.JOptionPane;

/**
 * @author Keoagile Mafora (ST10457036)
 */

public class POE {
    public static void main(String[] args) {
    
        Task objTask = new Task();
        
        //Declaring variables
        String naMe;
        String surName;
        String userNameReg;
        String passWordReg;
        String userNameLog;
        String passWordLog;
        
        //Input the name
        naMe = JOptionPane.showInputDialog("Enter your First Name");
        objTask.setName(naMe);
        
        //Input the surname
        surName = JOptionPane.showInputDialog("Enter your Surname");
        objTask.setSurname(surName);
        
        //Input the usernamr
        userNameReg = JOptionPane.showInputDialog("\nEnter your Username" 
                                                 + "\n - The username must not exceed 5 characters" 
                                                 + "\n - Must contain an underscore(_)");
        objTask.setRegisteredUsername(userNameReg);
        
        objTask.registerUser();
        
        //Input the password
        passWordReg = JOptionPane.showInputDialog("Enter your Password"
                                                 + "\n - The password must contain 8 characters" 
                                                 + "\n - Must contain Capital letter"
                                                 + "\n - The password must contain a special letter" 
                                                 + "\n - Must contain a digit"   );
        objTask.setRegisteredPassword(passWordReg);
        
        objTask.registerUser();
        
        JOptionPane.showMessageDialog(null,"Please login with your details");
        
        //Input the username you registered to
        userNameLog = JOptionPane.showInputDialog("Please enter your registered Username");
        objTask.setLoginUsername(userNameLog);
        
        //Input the password that you registered with
        passWordLog = JOptionPane.showInputDialog("Please enter your registered Password");
        objTask.setLoginPassword(passWordLog);
        
        objTask.returnLoginStatus();
        
        //Part 3
        String choices;
        String taskName[] = null;
        String taskDescription[] = null;
        String developerName[] = null;
        String taskDuration[] = null;
        String taskID[] = null;
        int status[] = null;
        int size = 0;
        int count;
        int total = 0;
        String[] delete = {"Delete", "Cancel"};
        String[] options = {"To Do", "Done", "Doing"};
        
        //Choose from the following
        choices = JOptionPane.showInputDialog("Please enter the following: "
                                              +"\n1) Add Task"
                                              +"\n2) Show Report"
                                              +"\n3) All tasks with (Done) "
                                              +"\n4) Task with Longest Duration"
                                              +"\n5) Search for Task"
                                              +"\n6) Search task by developer"
                                              +"\n7) Delete a task"
                                              +"\n8) QUIT!");
        
        
        objTask.setChoicery(choices);
        choices = objTask.verifyChoice();
        
        while(choices.equals("1") || choices.equals("2") || choices.equals("3") || choices.equals("4") || choices.equals("5") || choices.equals("6") || choices.equals("7")) {
                
            //For adding tasks
            if(choices.equals("1")) {
                
                // The number of tasks/the size of the arrays
                size = Integer.parseInt(JOptionPane.showInputDialog("Enter how many tasks you want to enter"));
                objTask.setSizery(size);
                
                //Declaring the size of the arrays
                taskName = new String[size];
                developerName = new String[size];
                taskDuration = new String[size];
                taskDescription = new String[size];
                taskID = new String[size];
                status = new int[size];
                
                for (count = 0; count < size; count++) {
                    objTask.setCounty(count);
                    
                    //For input of the task name
                    taskName[count] = JOptionPane.showInputDialog("Enter the name for task" );
                    objTask.setTaskNamery(taskName);
                    taskName[count] = objTask.verifyTaskName();
                    
                    //For the task description
                    taskDescription[count] = JOptionPane.showInputDialog("Enter the task description that has less than 50 characters");
                    objTask.setTaskDescr(taskDescription);
                    while (!objTask.checkTaskDescription(taskDescription[count])) {
                        taskDescription[count] = JOptionPane.showInputDialog("Please enter the task description that is 50 characters or less");
                        objTask.setTaskDescr(taskDescription);
                    }
                    
                    if (objTask.checkTaskDescription(taskDescription[count])) {
                        JOptionPane.showMessageDialog(null, "Task successfully captured");
                    }
                    
                    //For the developer name
                    developerName[count] = JOptionPane.showInputDialog("Pease enter your First and Last name of the developer assigned to the task");
                    objTask.setDeveloperDetail(developerName);
                    developerName[count] = objTask.verifyDeveloperName();
                    
                    //for the duration of the task
                    taskDuration[count] = JOptionPane.showInputDialog("Pease enter the hours for the task");
                    objTask.setDuration(taskDuration);
                    taskDuration[count] = objTask.verifyTaskDuration();
                    
                    //for the task duration
                    total = total + Integer.parseInt(taskDuration[count]);
                    objTask.setTotally(total);
                    
                    //For choosing the status of the task
                    status[count] = JOptionPane.showOptionDialog(null, "The status of this task", "Task Status", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, objTask.getOpt(), null);
                    objTask.setStatusery(status);
                    
                    //For printing the task details
                    JOptionPane.showMessageDialog(null, objTask.printTaskDetails());
                    
                    //Creates the task ID
                    taskID[count] = objTask.createTaskID();
                }
                
            }
            
            //For displaing a report of all of the tasks
        if (choices.equals("2"))  {
            
            StringBuilder displayReport = new StringBuilder();
            for(int i = 0; i<  size; i++ ) {
                if(taskName[i] != null) {
                    displayReport.append("Task Name: ").append(taskName[i])
                                 .append("\nDeveloper Details: ").append(developerName[i])
                                 .append("\nTask Duration: ").append(taskDuration[i] + " Hours")
                                 .append("\nTaskIDs: ").append(taskID[i])
                                 .append("\nStatus: ").append(options[status[i]] + "\n\n");
                }
            }
            
            if (size == 0) {
                JOptionPane.showMessageDialog(null, "Please add a task to view a report");
            }
            else {
                JOptionPane.showMessageDialog(null, displayReport.toString());
            }
        }
        
        //All tasks with the status (Done)
        if (choices.equals("3")) {
            
            StringBuilder doneTask = new StringBuilder();
            int found = 0;
            if (status != null && developerName != null && taskName != null && taskDuration !=null) {
                
                for (int i = 0; i < size; i++) {
                    
                    if(status[i] == 1) {
                        
                        doneTask.append("Task Name: ").append(taskName[i])
                                .append("\nDeveloper Details: ").append(developerName[i])
                                .append("\nTask Duation: ").append(taskDuration[i]).append("Hours\n\n");
                        found++;
                    }
                }
            }
            if (found > 0) {
                JOptionPane.showMessageDialog(null, doneTask.toString());
            }
            else {
                JOptionPane.showMessageDialog(null, "No tasks have been completed");
            }
        }
        
        //For tasks with the longest task duration
        if (choices.equals("4")) {
            if(size == 0) {
                JOptionPane.showMessageDialog(null, "Please add a task to be able to proceed");
        }
            else {
                int largest = 0;
                String longestDurationDeveloper = null;
            
                for (int i = 0; i < size; i++) {
                    if (Integer.parseInt(taskDuration[i]) > largest) {
                    largest = Integer.parseInt(taskDuration[i]);
                    longestDurationDeveloper = developerName[i];
           }
          }
               JOptionPane.showMessageDialog(null, "Developer: " + longestDurationDeveloper + "\nDuration: " + largest + " Hours");
        }
       }
        
        //Looking for the searched task
        if(choices.equals("5")) {
            String search = "";
            boolean found = false;
            
            search = JOptionPane.showInputDialog("Enter the name of the task you are looking for");
            
            for(int i = 0; i < size; i++) {
                if (search.equalsIgnoreCase(taskName[i])) {
                    
                    JOptionPane.showMessageDialog(null, "Task Name: " + taskName[i] + "\nDeveloper Details: " + developerName[i] + "\nStatus" + options[status[i]]);
                found = true;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(null, "The entered task does not exist");
            }
        }
        
        //Search by developer name
        if(choices.equals("6")) {
            
            String search = "";
            boolean found = false;
            StringBuilder searchFound = new StringBuilder();
            
            search = JOptionPane.showInputDialog("Enter the developer name you are looking for");
            for (int i=0; i<size; i++) {
                
                if(search.equalsIgnoreCase(developerName[i])) {
                    searchFound.append("Name: ").append(taskName[i])
                            .append("\nStatus: ").append(options[status[i]]).append("\n\n");
                   found = true;
                }
            }
            if(found) {
                JOptionPane.showMessageDialog(null, searchFound.toString());
            }
            else {
                JOptionPane.showMessageDialog(null, "The Name you searched for is not available");
            }
        }
        
        //For deletint a task
        if (choices.equals("7")) {
                
                String deleted = "";
                boolean deletedTask = false;
                int confirm;
                
                deleted = JOptionPane.showInputDialog("Enter the task name you want to delete");
                for (int i = 0; i < size; i++) {
                    if (deleted.equalsIgnoreCase(taskName[i])) {
                        
                        confirm = JOptionPane.showOptionDialog(null, "Are you sure you want to delete? ", "Confirm", JOptionPane.PLAIN_MESSAGE, JOptionPane.WARNING_MESSAGE, null, delete, null);
                    
                    total = total -Integer.parseInt(taskDuration[i]);
                    objTask.setTotally(total);
                    
                    taskName[i] = null;
                    developerName[i] = null;
                    taskDescription[i] = null;
                    taskDuration[i] = null;
                    status[i] = -1;
                    taskID = null;
                    
                    deletedTask = true;
                    }
                }
             if(deletedTask) {
                 JOptionPane.showMessageDialog(null, "Task is successfully deleted");
             }
             else{
                JOptionPane.showMessageDialog(null, "Task was not found");
             }
        }
            
         choices = JOptionPane.showInputDialog("Please enter the following: "
                                              +"\n1) Add Task"
                                              +"\n2) Show Report"
                                              +"\n3) All tasks with (Done) "
                                              +"\n4) Task with Longest Duration"
                                              +"\n5) Search for Task"
                                              +"\n6) Search task by developer"
                                              +"\n7) Delete a task"
                                              +"\n8) QUIT!");
         objTask.setChoicery(choices);
         choices = objTask.verifyChoice();
        }
        
        //For quitting and displaing the total hours
        if (choices.equals("8")) {
            JOptionPane.showMessageDialog(null, "Your tasks will take the total of: " + objTask.returnTotalHours() + " Hours");
            JOptionPane.showMessageDialog(null, "Quitting...");
        }
    }
}
    

        


