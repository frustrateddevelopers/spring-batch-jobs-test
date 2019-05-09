package com.example.springbatch.myfirstspringbatchexample.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class TaskletTwo implements Tasklet{

	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {
		System.out.println("executing tasklet Two");
		
		Thread.sleep(2000);
		return RepeatStatus.FINISHED;
	}

}
