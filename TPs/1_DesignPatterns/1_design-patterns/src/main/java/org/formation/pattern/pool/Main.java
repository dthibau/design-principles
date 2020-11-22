package org.formation.pattern.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {

		// I want to initialize the pool
		ReusablePool.getInstance().setMaxPoolSize(50);
		
		// Then I start my Callable Tasks
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Future<Long>> list = new ArrayList<Future<Long>>();
		for (int i = 0; i < 20000; i++) {
			Callable<Long> worker = new Client();
			Future<Long> submit = executor.submit(worker);
			list.add(submit);
		}
	
		// I check the validity of each results
		int i=0;
		for (Future<Long> future : list) {
			try {
				long sum = future.get();
				assert (sum <System.currentTimeMillis()) : "Résultat impossible ";
				System.out.println("Task " + i++ + " seems OK, sum is "+sum);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				System.out.println("Task " + i++ + " seems to fail");
				e.printStackTrace();
			}
		}
		System.exit(0);


	}

}
