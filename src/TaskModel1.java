
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskModel1 {

	public List<TaskBean1> getTasks(String catName)
	{
		List<TaskBean1> beans = new ArrayList<TaskBean1>();
		TaskBean1 beanie = null;
		
		BufferedReader br = null;
		try
		{
			String line;
			br = new BufferedReader(new FileReader(catName+".tasks"));
			while((line = br.readLine())!=null)
			{
				beanie = new TaskBean1();
				String[] sa = line.split(":");
				beanie.setName(sa[0]);
				beanie.setDesc(sa[1]);
				beanie.setSdt(sa[2]);
				beanie.setPriority(Integer.parseInt(sa[3]));
				beanie.setStatus(sa[4]);
				beanie.setTags(sa[5]);
				
				beans.add(beanie);
			}
		
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return beans;
	}
	
	public String createTask(TaskBean1 bean, String catName)
	{
		Logger1.getInstance().log("TM->createTask()->starting...");
		/*
		 * 1) create a file named with catname
		 * 2) convert data in bean to a string line with : delimiter
		 * 3) write the line into file
		 * 4) close the file
		 * 5) return success
		 * 6) any failure, return error msg as string
		 */
		BufferedWriter bw = null;
		try
		{
			bw = new BufferedWriter(new FileWriter(catName+".tasks",true));
			String line = bean.getName()+":"+bean.getDesc()+":"+bean.getSdt()+":"+bean.getPriority()+":"+bean.getStatus()+":"+bean.getTags();
			Logger1.getInstance().log("TM->createTask() line = "+line);
			bw.write(line);
			bw.newLine();
			return Constant1.Sucess;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return "Something bad happened in writing to file "+e.getMessage();
		}
		finally
		{
			if(bw!=null)
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	}
	
	public boolean checkIfCategoryExists(String catName)
	{
		Logger1.getInstance().log("TM->checkIfCategoryExists()->starting...");
		File f = new File(catName+".tasks");
		Logger1.getInstance().log("TM->checkIfCategoryExists()->cat exists ?..."+f.exists());
		if(f.exists())
			return true;
		else
			return false;
	}
	
    public 
	
}
