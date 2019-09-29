

import java.util.List;
import java.util.Scanner;

public class StartApp {

	private static final TaskUtil1 TaskUtil1 = null;

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		try
		{
			@SuppressWarnings("resource")
			Scanner sc1 = new Scanner(System.in);
			//@SuppressWarnings("resource")
			Scanner sc2 = new Scanner(System.in);
			
			int ch1=0,ch2=0;
			String catName,taskName,desc,tags,sdt;
			int prio;
			boolean result;
			TaskModel1 model = new TaskModel1();
			
			while(ch1!=5)
			{
				System.out.println("Press 1 to Create Category");
				System.out.println("Press 2 to Load Category");
				System.out.println("Press 3 to Search Category");
				System.out.println("Press 4 to List Category");
				System.out.println("Press 5 to Exit Category");
				System.out.println("Enter choice");
				
				while(!sc1.hasNextInt())
				{
					System.out.println("Enter integer input only boss!!!");
					sc1.next();
				}
				ch1 = sc1.nextInt();
				
				Logger1.getInstance().log("choice entered = "+ch1);
				
				switch(ch1)
				{
					case 1:
							System.out.println("creating...");
							
							System.out.println("Enter category name");
							catName = sc2.nextLine();
							Logger1.getInstance().log("category name given = "+catName);
							//input validate
							System.out.println(catName);
							result = TaskUtil1.isValidWord(catName);
							System.out.println(result);
							while(!result)
							{
								System.out.println("Enter a valid category name - start with letter, min 3 chars, max 40 chars, no spl chars, only one word");
								catName = sc2.nextLine();
								result = TaskUtil1.isValidWord(catName);
							}
							//perform business validation 
							//check if the category already exists!!
							
							result = model.checkIfCategoryExists(catName);
							while(result)
							{
								System.out.println("Category name already exists...you duplicate!! Enter a new one...");
								catName = sc2.nextLine();
								result = model.checkIfCategoryExists(catName);
							}
							Logger1.getInstance().log("category does not exist...");
							ch2 = 0;
							while(ch2!=6)
							{
								System.out.println("Press 1 to add task");
								System.out.println("Press 2 to edit tasks");
								System.out.println("Press 3 to remove tasks");
								System.out.println("Press 4 to list tasks");
								System.out.println("Press 5 to search tasks");
								System.out.println("Press 6 to go back");
								
								ch2 = sc1.nextInt();
								Logger1.getInstance().log("second choice entered = "+ch2);
								switch(ch2)
								{
								case 4:
										List<TaskBean1> beans = model.getTasks(catName);
										for(TaskBean1 b : beans)
										{
											System.out.println("Name : "+b.getName()+" Desc : "+b.getDesc()+" End Dt : "+b.getSdt()+" Priority : "+b.getPriority()+" Status : "+b.getStatus()+" Tags : "+b.getTags() );
										}
										break;
								case 1:
										System.out.println("Enter task name");
										taskName = sc2.nextLine();
										result = TaskUtil1.isValidWord(taskName);
										while(!result)
										{
											System.out.println("Enter a valid word for task name...");
											taskName = sc2.nextLine();
											result = TaskUtil1.isValidWord(taskName);
										}
										
										System.out.println("Enter task description");
										desc = sc2.nextLine();
										
										System.out.println("Enter tags");
										tags = sc2.nextLine();
										
										System.out.println("Enter end dt");
										sdt = sc2.nextLine();
										
										System.out.println("Enter priority (1->High,2->Med,3->Low)");
										prio = sc1.nextInt();
										Logger1.getInstance().log("data obtained from user "+taskName+" "+desc+ " "+sdt+" "+tags+" "+prio);
										
										TaskBean1 bean = new TaskBean1(taskName,desc,tags,sdt,prio,Constant1.STATUS_PENDING);
										
										String msg = model.createTask(bean, catName);
										if(msg.equals(Constant1.Sucess))
										{
											System.out.println("Task "+taskName+" created successfully in category "+catName+"!");
										}
										else
										{
											System.out.println("Oops theres been a problem! Msg is "+msg);
										}
										break;
										
								case 2:
										System.out.println("edit..");
										break;
										
								case 3:
										System.out.println("remove...");
										break;
										
								case 5:
										System.out.println("enter Serach...");
										String partName = sc2.next();
										List<TaskBean1> task= model.getTasks(catName);
										for(TaskBean1 task1 : task)
										{
											TaskBean1 tb= (TaskBean1)task1;
											/*if(tb.getTaskName1().contains(partName))
												System.out.println("match found" +tb);a*/
										}
										break;
										
								case 6:
										System.out.println("go back");
								default:		
										System.out.println("not supported yet...");
										break;
								}
								
							}
							
							break;
					case 2:	
							System.out.println("loading...");
							break;
					case 3:
							System.out.println("search....");
							break;
					case 4:
						    System.out.println("List...");
						    break;
					case 5: 
						    System.out.println("Exit...");
							
					 
					default:
							System.out.println("enter only 1-3, varna darna...");
							break;
				}
				
			}
			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			System.out.println("Oops something bad happened "+e.getMessage());
		}
	
	}

}
