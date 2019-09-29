
import java.io.BufferedWriter;
import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Date;

	public class Logger1 {
		
		public void log(final String data)
		{
				new Thread(new Runnable()
				{
					@Override
						public void run() {
						
							BufferedWriter bw= null;
							try
							{
								bw = new BufferedWriter(new FileWriter(Constant1.LOGPATH,true));
								Date dt = new Date();
								bw.write(dt.toString()+":"+data);
								bw.newLine();
								if(Constant1.LOGGER_MODE)
									System.out.println(data);
							}
							catch(IOException e)
							{
								e.printStackTrace();
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

				}).start();
		}
		private Logger1()
		{
			//System.out.println("in Logger() no-arg constr");
		}
		private static Logger1 obj = null;
		
		public static Logger1 getInstance()
		{
			//System.out.println("in Logger getInstance(), apogee = "+obj);
			if(obj == null)
				obj = new Logger1();
			
			return obj;
		}
		
	}



