/**
 * 
 */
package be.befootint.consulttweets.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author cazamundo
 *
 */
@Component
public class RunScheduler {

	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;
	
	public void run(){
		try{
			JobParameters param = new JobParametersBuilder().addString("jonathan","jonathan").toJobParameters();
			JobExecution execution = jobLauncher.run(job, param);
			
			System.out.println("Exit status : " + execution.getStatus());
			
		}catch(Exception e){
			System.out.println("RunScheduler fails");
			e.printStackTrace();
		}
	}
}
