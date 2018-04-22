package com.demo;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.TimeoutException;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;
import mousio.etcd4j.EtcdClient;
import mousio.etcd4j.responses.EtcdAuthenticationException;
import mousio.etcd4j.responses.EtcdException;
import mousio.etcd4j.responses.EtcdKeysResponse;

@Component
public class TaskRegister {
	@Scheduled(cron= "*0 */30 * * * *")
	public static void register() throws IOException {
		System.out.println(
				"---------------------------------------Attempting to initiate ETCD registration---------------------------------------");
		try (EtcdClient etcd = new EtcdClient(URI.create("http://etcd:4001"))) {
			etcd.deleteDir("services").recursive().send();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			}
			EtcdKeysResponse response = etcd.putDir("services").send().get();
			System.out.println("Creating service directory: " + response.node.value);
			EtcdKeysResponse response1 = etcd.put("services/1", "web").send().get();
			EtcdKeysResponse response2 = etcd.put("services/2", "mw").send().get();
			EtcdKeysResponse response3 = etcd.put("services/3", "cmt").send().get();
			EtcdKeysResponse response4 = etcd.put("services/4", "qa").send().get();

		}

		catch (EtcdException e) {
			if(e.getMessage().contains("Not a file")){
			System.out.println("Warning: The directory doesn't exist...Unable to purge!");
			}			
		} catch (IOException e) {
		} catch (EtcdAuthenticationException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

	}
	@Bean
	public TaskScheduler taskScheduler(){
		 return new ThreadPoolTaskScheduler();
	}
}
