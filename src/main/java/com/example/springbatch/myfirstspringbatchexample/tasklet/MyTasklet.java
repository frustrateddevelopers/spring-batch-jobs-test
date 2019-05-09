package com.example.springbatch.myfirstspringbatchexample.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class MyTasklet implements Tasklet{

	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("executing tasklet");
		System.out.println(arg0);
		System.out.println(arg1);
		return RepeatStatus.FINISHED;
	}

}
